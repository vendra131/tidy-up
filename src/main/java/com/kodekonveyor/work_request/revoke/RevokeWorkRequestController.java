package com.kodekonveyor.work_request.revoke;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.WorkRequestConstants;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;

@RestController
public class RevokeWorkRequestController {

  @Autowired
  WorkRequestRepository workRequestRepository;

  @Autowired
  AuthenticatedUserService authenticatedUserService;

  @GetMapping("/workRequest/@workRequestId")
  public void call(@RequestParam final long workRequestId) {
    inputValidation(workRequestId);

    final WorkRequestEntity workRequestEntity =
        workRequestRepository.findByWorkRequestId(workRequestId).get(0);

    final UserEntity user = authenticatedUserService.call();
    final UserEntity customer = workRequestEntity.getCustomer();

    if (customer.getId() == user.getId())
      workRequestRepository.delete(workRequestEntity);
    else
      throw new ValidationException(
          WorkRequestConstants.UNAUTHORIZE_REVOKE_WORK_REQUEST
      );

  }

  private void inputValidation(final long workRequestId) {

    final int workId = 0;
    if (workRequestId <= workId)
      throw new ValidationException(
          WorkRequestConstants.NON_POSITIVE_WORK_REQUEST_ID_EXCEPTION
      );

    final List<WorkRequestEntity> workRequestEntity =
        workRequestRepository.findByWorkRequestId(workRequestId);
    if (workRequestEntity.isEmpty())
      throw new ValidationException(
          WorkRequestConstants.INVALID_WORK_REQUEST_ID_EXCEPTION
      );

  }

}
