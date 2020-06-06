package com.kodekonveyor.work_request.revoke;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;

import static com.kodekonveyor.work_request.WorkRequestConstants.FAILURE;
import static com.kodekonveyor.work_request.WorkRequestConstants.INVALID_WORK_REQUEST_ID_EXCEPTION;
import static com.kodekonveyor.work_request.WorkRequestConstants.LOG_API_CALL;
import static com.kodekonveyor.work_request.WorkRequestConstants.LOG_API_CALL_FALURE_STATUS;
import static com.kodekonveyor.work_request.WorkRequestConstants.LOG_API_CALL_STATUS;
import static com.kodekonveyor.work_request.WorkRequestConstants.NON_POSITIVE_WORK_REQUEST_ID_EXCEPTION;
import static com.kodekonveyor.work_request.WorkRequestConstants.SUCCESS;
import static com.kodekonveyor.work_request.WorkRequestConstants.UNAUTHORIZE_REVOKE_WORK_REQUEST;

@RestController
public class RevokeWorkRequestController {

  @Autowired
  WorkRequestRepository workRequestRepository;

  @Autowired
  AuthenticatedUserService authenticatedUserService;

  @Autowired
  Logger loggerService;

  @GetMapping("/workRequest/@workRequestId")
  public void call(@RequestParam final long workRequestId) {
    loggerService.info(LOG_API_CALL);

    inputValidation(workRequestId);

    final WorkRequestEntity workRequestEntity =
            workRequestRepository.findByWorkRequestId(workRequestId).get(0);

    final UserEntity user = authenticatedUserService.call();
    final UserEntity customer = workRequestEntity.getCustomer();

    if (customer.getId() == user.getId())
      workRequestRepository.delete(workRequestEntity);
    else {
      loggerService.warn(LOG_API_CALL_FALURE_STATUS, FAILURE, UNAUTHORIZE_REVOKE_WORK_REQUEST );
      throw new ValidationException(UNAUTHORIZE_REVOKE_WORK_REQUEST);
    }

    loggerService.debug(LOG_API_CALL_STATUS, SUCCESS);
  }

  private void inputValidation(final long workRequestId) {

    final int workId = 0;

    if (workRequestId <= workId) {
      loggerService.warn(LOG_API_CALL_FALURE_STATUS, FAILURE, NON_POSITIVE_WORK_REQUEST_ID_EXCEPTION );
      throw new ValidationException(NON_POSITIVE_WORK_REQUEST_ID_EXCEPTION);
    }
    final List<WorkRequestEntity> workRequestEntity =
            workRequestRepository.findByWorkRequestId(workRequestId);

    if (workRequestEntity.isEmpty()) {
      loggerService.warn(LOG_API_CALL_FALURE_STATUS, FAILURE, INVALID_WORK_REQUEST_ID_EXCEPTION );
      throw new ValidationException(INVALID_WORK_REQUEST_ID_EXCEPTION);
    }
  }

}
