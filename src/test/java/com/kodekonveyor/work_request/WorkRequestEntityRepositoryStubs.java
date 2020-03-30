package com.kodekonveyor.work_request;

import static org.mockito.Mockito.doReturn;

import java.util.List;

import com.kodekonveyor.authentication.UserEntityTestData;

public class WorkRequestEntityRepositoryStubs {

  public static void behaviour(
      final WorkRequestRepository workRequestRepository
  ) {

    doReturn(WorkRequestEntityTestData.list())
        .when(workRequestRepository)
        .findByCustomer(UserEntityTestData.get());
    doReturn(List.of(WorkRequestEntityTestData.get()))
        .when(workRequestRepository)
        .findByWorkRequestId(WorkRequestEntityTestData.WORK_REQUEST_ID);
    doReturn(WorkRequestEntityTestData.list())
        .when(workRequestRepository)
        .findByWorkRequestId(WorkRequestEntityTestData.WORK_REQUEST_ID);
    doReturn(List.of(WorkRequestEntityTestData.getCustomerBadUser()))
        .when(workRequestRepository)
        .findByWorkRequestId(WorkRequestEntityTestData.REVOKE_WORK_REQUEST_ID);
    doReturn(WorkRequestEntityTestData.list())
        .when(workRequestRepository)
        .findByTypeAndCountryAndCity(
            WorkTypeEnum.CLEANING, AddressEntityTestData.COUNTRY,
            AddressEntityTestData.CITY
        );

  }

  public static void behaviour2(
      final WorkRequestRepository workRequestRepository
  ) {
    doReturn(List.of(WorkRequestEntityTestData.getStatusPosted()))
        .when(workRequestRepository)
        .findByWorkRequestId(
            WorkRequestEntityTestData.WORK_REQUEST_ID
        );
  }

}
