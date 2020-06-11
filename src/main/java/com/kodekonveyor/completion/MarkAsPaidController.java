package com.kodekonveyor.completion;

import static com.kodekonveyor.completion.CompletionConstants.FAILURE;
import static com.kodekonveyor.completion.CompletionConstants.INVALID_WORK_STATE_FOR_MARK_PAID;
import static com.kodekonveyor.completion.CompletionConstants.MARK_AS_PAID_PATH;
import static com.kodekonveyor.completion.CompletionConstants.MARK_AS_PAID_WORK_REQUEST_ID;
import static com.kodekonveyor.completion.CompletionConstants.SUCCESS;

import com.kodekonveyor.work_request.WorkRequestConstants;
import com.kodekonveyor.work_request.WorkRequestDTO;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkRequestStatusEnum;
import com.kodekonveyor.work_request.WorkRequestUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkAsPaidController {

  @Autowired
  WorkRequestRepository repository;

  @Autowired
  Logger loggerService;

  @PutMapping(MARK_AS_PAID_PATH)
  public WorkRequestDTO call(
      @PathVariable(MARK_AS_PAID_WORK_REQUEST_ID) final Long workRequestId
  ) {
    loggerService.info(WorkRequestConstants.LOG_API_CALL);

    final WorkRequestEntity workRequest =
        repository.findById(workRequestId).get();

    if (!workRequest.getStatus().equals(WorkRequestStatusEnum.VERIFIED)) {
      loggerService.warn(WorkRequestConstants.LOG_API_CALL_FALURE_STATUS, FAILURE, INVALID_WORK_STATE_FOR_MARK_PAID);
      throw new IllegalStateException();
    }

    workRequest.setStatus(WorkRequestStatusEnum.PAID);
    repository.save(workRequest);

    WorkRequestDTO workRequestDTO = WorkRequestUtil
            .convertWorkRequestEntityToDTO(workRequest);

    loggerService.debug(WorkRequestConstants.LOG_API_CALL_STATUS, SUCCESS);

    return workRequestDTO;
  }

}
