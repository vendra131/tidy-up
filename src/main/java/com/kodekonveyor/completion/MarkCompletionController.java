package com.kodekonveyor.completion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.work_request.AddressDTO;
import com.kodekonveyor.work_request.AddressEntity;
import com.kodekonveyor.work_request.WorkRequestDTO;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;

@RestController
public class MarkCompletionController {

  @Autowired
  WorkRequestRepository workRequestRepository;

  @PutMapping("/completed/{workRequestId}")
  public WorkRequestDTO call(final Long workRequestId) {
    final List<WorkRequestEntity> entities =
        workRequestRepository.findByWorkRequestId(workRequestId);
    final WorkRequestDTO workRequestDTO1 = new WorkRequestDTO();
    final WorkRequestDTO workRequestDTO = workRequestDTO1;
    final WorkRequestEntity entity = entities.get(0);

    final AddressDTO address = new AddressDTO();

    final AddressEntity addressEntity = entity.getAddress();

    address.setAddress(addressEntity.getAddress());
    address.setCity(addressEntity.getCity());
    address.setCountry(addressEntity.getCountry());
    address.setId(addressEntity.getId());

    workRequestDTO.setDescription(entity.getDescription());
    workRequestDTO.setWorkRequestId(entity.getId());
    workRequestDTO.setWorkType(entity.getWorkType());
    workRequestDTO.setAddress(address);

    return workRequestDTO;
  }
}
