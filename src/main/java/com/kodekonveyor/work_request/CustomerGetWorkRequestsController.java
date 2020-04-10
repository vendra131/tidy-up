package com.kodekonveyor.work_request;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.authentication.UserEntityRepository;
import com.kodekonveyor.webapp.ValidationException;

@RestController
public class CustomerGetWorkRequestsController {

  @Autowired
  WorkRequestRepository workRequestRepository;
  @Autowired
  UserEntityRepository userEntityRepository;

  @GetMapping("/work-request/byOwner/{ownerId}")
  public WorkRequestListDTO call(final String ownerId) {
    inputValidation(ownerId);

    final Optional<UserEntity> user =
        userEntityRepository.findById(Long.parseLong(ownerId));
    if (user.isEmpty())
      throw new ValidationException(WorkRequestConstants.INVALID_OWNERID);

    final List<WorkRequestEntity> requests =
        workRequestRepository.findByCustomer(user.get());

    final WorkRequestListDTO workRequestListDTO = new WorkRequestListDTO();

    final AddressDTO address = new AddressDTO();
    final WorkRequestDTO workRequestDTO = new WorkRequestDTO();
    for (final WorkRequestEntity workRequestEntity : requests) {

      workRequestDTO.setWorkType(workRequestEntity.getWorkType());

      workRequestDTO.setWorkRequestId(workRequestEntity.getId());
      address.setAddress(workRequestEntity.getAddress().getAddress());
      address.setCity(workRequestEntity.getAddress().getCity());
      address.setCountry(workRequestEntity.getAddress().getCountry());
      address.setId(workRequestEntity.getAddress().getId());
      workRequestDTO.setAddress(address);
      workRequestDTO.setDescription(workRequestEntity.getDescription());
      workRequestDTO.setStatus(workRequestEntity.getStatus());
      workRequestListDTO.getRequests().add(workRequestDTO);
    }

    return workRequestListDTO;
  }

  private void inputValidation(final String ownerId) {
    if (null == ownerId)
      throw new ValidationException(WorkRequestConstants.NULL_OWNERID);

    if (!ownerId.matches(WorkRequestConstants.OWNER_ID_REGEX))
      throw new ValidationException(WorkRequestConstants.ALPHACHAR_OWNERID);

  }

}
