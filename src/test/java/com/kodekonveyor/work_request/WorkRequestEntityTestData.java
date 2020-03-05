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
  public static final String WORK_TYPE = "CLEANING";
  public static final String DESCRIPTION = "Clean up the mess";
  public static final boolean IS_ACTIVE = true;
  public static final Long CUSTOMER_ID = (long) 4242;

  public static WorkRequestEntity get() {
    final WorkRequestEntity workRequestEntity = new WorkRequestEntity();
    workRequestEntity.setCustomer(UserEntityTestData.get());
    workRequestEntity.setWorkType(WORK_TYPE);
    workRequestEntity.setId(WORK_REQUEST_ID);
    workRequestEntity.setDescription(DESCRIPTION);
    workRequestEntity.setAddress(AddressEntityTestData.get());
    return workRequestEntity;
  }

  public static WorkRequestEntity getCustomerBadUser() {
    final WorkRequestEntity workRequestEntity = get();
    workRequestEntity.setCustomer(UserEntityTestData.getIdForBadUser());
    workRequestEntity.setId(REVOKE_WORK_REQUEST_ID);
    return workRequestEntity;
  }

  public static List<WorkRequestEntity> list() {
    return List.of(get());
  }
}
