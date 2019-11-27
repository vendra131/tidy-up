package com.kodekonveyor.work_request;

import static org.mockito.Mockito.doReturn;

public class WorkRequestEntityRepositoryStubs {

  public static void behaviour(
      final WorkRequestRepository workRequestRepository,
      final WorkRequestTestData workRequestTestData,
      final AddressTestData addressTestData
  ) {
    doReturn(workRequestTestData.WORK_REQUEST_ENTITY_LIST)
        .when(workRequestRepository)
        .findByWorkRequestId(workRequestTestData.WORK_REQUEST_ID);
    doReturn(workRequestTestData.WORK_REQUEST_ENTITY_LIST)
        .when(workRequestRepository)
        .findByTypeAndCountryAndCity(
            WorkTypeEnum.CLEANING, addressTestData.COUNTRY, addressTestData.CITY
        );
  }
}
