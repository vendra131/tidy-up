package com.kodekonveyor.work_request;

import static org.mockito.Mockito.doReturn;

import java.util.List;
import java.util.Optional;

import com.kodekonveyor.authentication.UserEntityTestData;

public class WorkRequestEntityRepositoryStubs {

  public static void behaviour(
      final WorkRequestRepository workRequestRepository
  ) {

    doReturn(WorkRequestEntityTestData.list())
        .when(workRequestRepository)
        .findByCustomer(UserEntityTestData.get());
    doReturn(List.of(WorkRequestEntityTestData.getStatusNotPosted()))
        .when(workRequestRepository)
        .findByWorkRequestId(
            WorkRequestEntityTestData.WORK_REQUEST_ID_NOT_POSTED
        );
    doReturn(
        List.of(WorkRequestEntityTestData.getStatusNotPostedWithCustomer())
    )
        .when(workRequestRepository)
        .findByWorkRequestId(
            WorkRequestEntityTestData.WORK_REQUEST_ID_NOT_POSTED_WITH_CUSTOMER
        );
    doReturn(
        List.of(WorkRequestEntityTestData.getStatusNotPostedWithProvider())
    )
        .when(workRequestRepository)
        .findByWorkRequestId(
            WorkRequestEntityTestData.WORK_REQUEST_ID_NOT_POSTED_WITH_PROVIDER
        );
    doReturn(WorkRequestEntityTestData.list())
        .when(workRequestRepository)
        .findByWorkRequestId(WorkRequestEntityTestData.WORK_REQUEST_ID);

    doReturn(List.of(WorkRequestEntityTestData.getCustomerBadUser()))
        .when(workRequestRepository)
        .findByWorkRequestId(WorkRequestEntityTestData.REVOKE_WORK_REQUEST_ID);
    doReturn(WorkRequestEntityTestData.listForCountryCityAndTypeQuery())
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

  public static void agreedWorkRequest(
      final WorkRequestRepository workRequestRepository
  ) {
    doReturn(List.of(WorkRequestEntityTestData.getStatusAgreed()))
        .when(workRequestRepository)
        .findByWorkRequestId(
            WorkRequestEntityTestData.WORK_REQUEST_ID
        );
  }

    public static void verifiedWorkRequest(
            final WorkRequestRepository workRequestRepository
    ) {
        doReturn(Optional.of(WorkRequestEntityTestData.getStatusVerified()))
                .when(workRequestRepository)
                .findById(
                        WorkRequestEntityTestData.VERIFIED_WORK_REQUEST_ID
                );
    }

}
