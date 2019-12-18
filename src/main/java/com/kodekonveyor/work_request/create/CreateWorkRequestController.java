
package com.kodekonveyor.work_request.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.authentication.UserEntityRepository;
import com.kodekonveyor.work_request.AddressDTO;
import com.kodekonveyor.work_request.AddressEntity;
import com.kodekonveyor.work_request.AddressUtil;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkTypeEnum;

@Controller
public class CreateWorkRequestController { //NOPMD Cyclomatic complexity

  @Autowired
  public WorkRequestRepository workRequestRepository;
  @Autowired
  public UserEntityRepository userEntityRepository;
  @Autowired
  public AuthenticatedUserService authenticatedUserService;
  @Autowired
  public WorkTypeEnum workTypeEnum;

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
    workRequestEntity.setId(customerId);
    workRequestEntity.setDescription(createWorkRequestDTO.getDescription());
    workRequestEntity.setAddress(addressEntity);
    workRequestRepository.save(workRequestEntity);

  }

}
