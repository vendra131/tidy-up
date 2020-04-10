package com.kodekonveyor.work_request;

import java.util.List;

import com.kodekonveyor.authentication.UserEntityTestData;

public class WorkRequestEntityTestData {

  public static final String NO_WORKREQUESTS = "No Work Request";
  public static final String NO_WORKREQUESTS_ID = "4243";
  public static final Long NON_POSITIVE_WORK_REQUEST_ID = 0L;
  public static final Long WORK_REQUEST_ID = 4242L;
  public static final Long INVALID_WORK_REQUEST_ID = 3454L;

  public static final Long REVOKE_WORK_REQUEST_ID = 4241L;

  public static final String OWNER_ID = "4242";
  public static final Long NON_OWNER_ID = 4343L;
  public static final String WORK_TYPE = "CLEANING";
  public static final String DESCRIPTION = "Clean up the mess";
  public static final boolean IS_ACTIVE = true;
  public static final Long CUSTOMER_ID = (long) 4242;
  public static final WorkRequestStatusEnum STATUS =
      WorkRequestStatusEnum.POSTED;

  public static WorkRequestEntity get() {
    final WorkRequestEntity workRequestEntity = new WorkRequestEntity();
    workRequestEntity.setCustomer(UserEntityTestData.get());
    workRequestEntity.setProvider(UserEntityTestData.get());
    workRequestEntity.setWorkType(WORK_TYPE);
    workRequestEntity.setId(WORK_REQUEST_ID);
    workRequestEntity.setDescription(DESCRIPTION);
    workRequestEntity.setStatus(WorkRequestStatusEnum.POSTED);
    workRequestEntity.setAddress(AddressEntityTestData.get());
    return workRequestEntity;
  }

  public static WorkRequestEntity getCustomerBadUser() {
    final WorkRequestEntity workRequestEntity = get();
    workRequestEntity.setCustomer(UserEntityTestData.getIdForBadUser());
    workRequestEntity.setId(REVOKE_WORK_REQUEST_ID);
    workRequestEntity.setAddress(AddressEntityTestData.get());
    return workRequestEntity;
  }

  public static WorkRequestEntity getStatusPosted() {
    final WorkRequestEntity workRequestEntity = get();
    workRequestEntity.setStatus(WorkRequestStatusEnum.POSTED);
    workRequestEntity.setCustomer(UserEntityTestData.get());
    return workRequestEntity;
  }

  public static List<WorkRequestEntity> list() {
    return List.of(get());
  }

  public static List<WorkRequestEntity> listForCountryCityAndTypeQuery() {
    return List.of(
        get(),
        getStatusNotPostedAndNonOWner(),
        getStatusNotPostedAndUserIsCustomer(),
        getStatusNotPostedAndUserIsProvider()
    );
  }

  public static WorkRequestEntity getStatusNotPostedAndNonOWner() {
    final WorkRequestEntity workRequestEntity = get();
    workRequestEntity.setId(NON_OWNER_ID);
    workRequestEntity.setCustomer(UserEntityTestData.getIdForBadUser());
    workRequestEntity.setProvider(UserEntityTestData.getIdForBadUser());
    workRequestEntity.setStatus(WorkRequestStatusEnum.AGREED);
    return workRequestEntity;
  }

  public static WorkRequestEntity getStatusNotPostedAndUserIsCustomer() {
    final WorkRequestEntity workRequestEntity = get();
    workRequestEntity.setCustomer(UserEntityTestData.get());
    workRequestEntity.setProvider(UserEntityTestData.getIdForBadUser());
    workRequestEntity.setStatus(WorkRequestStatusEnum.AGREED);
    return workRequestEntity;
  }

  public static WorkRequestEntity
      getStatusNotPostedAndUserIsProvider() {
    final WorkRequestEntity workRequestEntity = get();
    workRequestEntity.setCustomer(UserEntityTestData.getIdForBadUser());
    workRequestEntity.setProvider(UserEntityTestData.get());
    workRequestEntity.setStatus(WorkRequestStatusEnum.PAID);
    return workRequestEntity;
  }

}
