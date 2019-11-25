package com.kodekonveyor.work_request;

import static org.mockito.Mockito.doReturn;

import java.util.List;

public class WorkRequestRepositoryStub { // NOPMD

  public static void behaviour(
      final WorkRequestRepository workRequestRepository,
      final WorkRequestTestData workRequestTestData
  ) {

    doReturn(workRequestTestData.WORK_REQUEST_ENTITY_LIST)
        .when(workRequestRepository)
        .findByCustomer(workRequestTestData.userTestData.USER);
    doReturn(List.of(workRequestTestData.WORK_REQUEST_ENTITY))
        .when(workRequestRepository)
        .findByWorkRequestId(workRequestTestData.WORK_REQUEST_ID);

  }

}
