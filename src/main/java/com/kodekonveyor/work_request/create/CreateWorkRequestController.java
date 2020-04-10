package com.kodekonveyor.work_request.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.authentication.UserEntityRepository;
import com.kodekonveyor.work_request.AddressDTO;
import com.kodekonveyor.work_request.AddressEntity;
import com.kodekonveyor.work_request.AddressUtil;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkRequestStatusEnum;
import com.kodekonveyor.work_request.WorkTypeEnum;

@RestController
public class CreateWorkRequestController {

  @Autowired
  WorkRequestRepository workRequestRepository;
  @Autowired
  UserEntityRepository userEntityRepository;
  @Autowired
  AuthenticatedUserService authenticatedUserService;
  @Autowired
  WorkTypeEnum workTypeEnum;

  @PostMapping("/work-request")
  public void
      call(@RequestBody final CreateWorkRequestDTO createWorkRequestDTO) {

    WorkRequestValidationUtil.validateWorkRequest(createWorkRequestDTO);

    createWorkRequest(createWorkRequestDTO);

  }

  private void createWorkRequest(
      final CreateWorkRequestDTO createWorkRequestDTO
  ) {
    final WorkRequestEntity workRequestEntity = new WorkRequestEntity();
    workRequestEntity.setWorkType(createWorkRequestDTO.getWorkType());
    final UserEntity userEntity = authenticatedUserService.call();

    final AddressDTO address = createWorkRequestDTO.getAddress();
    final Long customerId = createWorkRequestDTO.getCustomerId();
    final AddressEntity addressEntity =
        AddressUtil.createAddressEntityFromDTO(address, customerId);
    workRequestEntity.setCustomer(userEntity);
    workRequestEntity.setProvider(userEntity);
    workRequestEntity.setId(customerId);
    workRequestEntity.setDescription(createWorkRequestDTO.getDescription());
    workRequestEntity.setStatus(WorkRequestStatusEnum.POSTED);
    workRequestEntity.setAddress(addressEntity);
    workRequestRepository.save(workRequestEntity);

  }

}
