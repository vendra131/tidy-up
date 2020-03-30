package com.kodekonveyor.work_request.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.work_request.AddressDTO;
import com.kodekonveyor.work_request.WorkRequestDTO;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;

@RestController

public class AcceptOfferController {

  @Autowired
  OfferEntityRepository offerEntityRepository;

  @Autowired
  WorkRequestRepository workRequestReposiory;

  @PutMapping("/accept/{offerId}")
  public WorkRequestDTO call(final long offerId) {

    final OfferEntity offerEntity =
        offerEntityRepository.findById(offerId).get();
    final WorkRequestEntity workRequest = offerEntity.getWorkRequest();
    return getWorkRequestDTO(workRequest);

  }

  private WorkRequestDTO
      getWorkRequestDTO(final WorkRequestEntity workRequest) {
    final WorkRequestDTO workRequestDTO = new WorkRequestDTO();
    workRequestDTO
        .setDescription(workRequest.getDescription());
    workRequestDTO.setStatus(workRequest.getStatus());
    workRequestDTO.setWorkRequestId(workRequest.getId());
    workRequestDTO.setWorkType(workRequest.getWorkType());

    final AddressDTO addressDTO = new AddressDTO();
    addressDTO
        .setAddress(workRequest.getAddress().getAddress());
    addressDTO.setCity(workRequest.getAddress().getCity());
    addressDTO.setId(workRequest.getAddress().getId());
    addressDTO
        .setCountry(workRequest.getAddress().getCountry());

    workRequestDTO.setAddress(addressDTO);
    return workRequestDTO;
  }
}
