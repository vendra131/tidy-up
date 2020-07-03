package com.kodekonveyor.work_request.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.webapp.LoggerService;
import com.kodekonveyor.work_request.AddressDTO;
import com.kodekonveyor.work_request.WorkRequestDTO;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkRequestStatusEnum;

@RestController

public class AcceptOfferController {

  @Autowired
  OfferEntityRepository offerEntityRepository;
  @Autowired
  AuthenticatedUserService authenticatedUserService;
  @Autowired
  WorkRequestRepository workRequestRepository;
  @Autowired
  LoggerService loggerService;

  @PutMapping("/accept/{offerId}")
  public WorkRequestDTO call(final long offerId) {
    loggerService.call(OfferConstants.ACCEPT_OFFER_CONTROLLER_IS_STARTED);
    final OfferEntity offerEntity =
        offerEntityRepository.findById(offerId).get();
    final WorkRequestEntity workRequest = offerEntity.getWorkRequest();
    workRequest.setStatus(WorkRequestStatusEnum.AGREED);
    workRequestRepository.save(workRequest);
    loggerService.call(OfferConstants.SUCCESS + workRequest.getId());
    return getWorkRequestDTOStatusAgreed(workRequest);
  }

  private WorkRequestDTO
      getWorkRequestDTO(final WorkRequestEntity workRequest) {
    final WorkRequestDTO workRequestDTO = new WorkRequestDTO();
    workRequestDTO
        .setDescription(workRequest.getDescription());
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

  private WorkRequestDTO
      getWorkRequestDTOStatusAgreed(final WorkRequestEntity workRequest) {
    final WorkRequestDTO workRequestDTO = getWorkRequestDTO(workRequest);
    workRequestDTO.setStatus(workRequest.getStatus());
    workRequestDTO.setProvider(workRequest.getProvider());
    return workRequestDTO;
  }

}
