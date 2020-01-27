package com.kodekonveyor.completion;

import static com.kodekonveyor.completion.CompletionConstants.MARK_AS_PAID_PATH;
import static com.kodekonveyor.completion.CompletionConstants.MARK_AS_PAID_WORK_REQUEST_ID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkRequestStatusEnum;

@RestController
public class MarkAsPaidController {

  @Autowired
  WorkRequestRepository repository;

  @PutMapping(MARK_AS_PAID_PATH)
  public void call(
      @PathVariable(MARK_AS_PAID_WORK_REQUEST_ID) final Long workRequestId
  ) {

    final WorkRequestEntity workRequest =
        repository.findById(workRequestId).get();
    if (!workRequest.getStatus().equals(WorkRequestStatusEnum.VERIFIED))
      throw new IllegalStateException();
    workRequest.setStatus(WorkRequestStatusEnum.PAID);
    repository.save(workRequest);

  }

}
