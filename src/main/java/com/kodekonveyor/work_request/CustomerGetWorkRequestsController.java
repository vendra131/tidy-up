package com.kodekonveyor.work_request;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.authentication.UserEntityRepository;
import com.kodekonveyor.webapp.ValidationException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static com.kodekonveyor.work_request.WorkRequestConstants.FAILURE;
import static com.kodekonveyor.work_request.WorkRequestConstants.SUCCESS;
import static com.kodekonveyor.work_request.WorkRequestConstants.UNAUTHORIZE_GET_WORK_REQUESTS_FOR_USER;
import static com.kodekonveyor.work_request.WorkRequestConstants.WORK_REQUEST_ERROR;
import static com.kodekonveyor.work_request.WorkRequestConstants.WORK_REQUEST_INPUT_VALIDATION_ERROR;

@RestController
public class CustomerGetWorkRequestsController {

  @Autowired
  WorkRequestRepository workRequestRepository;
  @Autowired
  UserEntityRepository userEntityRepository;
  @Autowired
  AuthenticatedUserService authenticatedUserService;

  @Autowired
  Logger loggerService;

  @GetMapping("/work-request/byOwner/{ownerId}")
  public WorkRequestListDTO call(final String ownerId) {
      loggerService.info(WorkRequestConstants.SERVICE_CALL_NAME, CustomerGetWorkRequestsController.class.getName());

    inputValidation(ownerId);

    final Optional<UserEntity> user =
        userEntityRepository.findById(Long.parseLong(ownerId));

    if (user.isEmpty()) {
        loggerService.warn(
                WORK_REQUEST_ERROR,
                WorkRequestConstants.INVALID_OWNERID,
                FAILURE
        );
      throw new ValidationException(WorkRequestConstants.INVALID_OWNERID);
    }

    final UserEntity sessionUser = authenticatedUserService.call();

    if (sessionUser.getId() != user.get().getId()){
      loggerService.warn(
              WORK_REQUEST_ERROR,
              UNAUTHORIZE_GET_WORK_REQUESTS_FOR_USER,
              FAILURE
      );
      throw new ValidationException(UNAUTHORIZE_GET_WORK_REQUESTS_FOR_USER);
    }

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

    loggerService.debug(WorkRequestConstants.FIND_WORK_REQUEST_BY_CUSTOMER_API_CALL_STATUS, ownerId, SUCCESS);

    return workRequestListDTO;
  }

  private void inputValidation(final String ownerId) {
    if (null == ownerId) {
      loggerService.warn(
              WORK_REQUEST_INPUT_VALIDATION_ERROR,
              ownerId,
              FAILURE,
              WorkRequestConstants.NULL_OWNERID
      );
      throw new ValidationException(WorkRequestConstants.NULL_OWNERID);
    }

    if (!ownerId.matches(WorkRequestConstants.OWNER_ID_REGEX)) {
      loggerService.warn(
              WORK_REQUEST_INPUT_VALIDATION_ERROR,
              ownerId,
              FAILURE,
              WorkRequestConstants.ALPHACHAR_OWNERID
      );
      throw new ValidationException(WorkRequestConstants.ALPHACHAR_OWNERID);
    }
  }

}
