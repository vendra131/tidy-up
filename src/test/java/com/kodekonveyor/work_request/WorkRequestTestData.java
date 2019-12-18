package com.kodekonveyor.work_request;

import java.util.ArrayList;
import java.util.List;

import com.kodekonveyor.authentication.UserTestData;

public class WorkRequestTestData {

  public final String NO_WORKREQUESTS = "No Work Request";
  public final String NO_WORKREQUESTS_ID = "4243";

  public final WorkRequestDTO WORK_REQUEST_DTO;
  public WorkRequestListDTO WORK_REQUEST_LIST_DTO;
  public final WorkRequestEntity WORK_REQUEST_ENTITY;
  public List<WorkRequestEntity> WORK_REQUEST_ENTITY_LIST;
  public final List<Object> EMPTY_LIST = new ArrayList<>();
  public final String OWNER_ID = "4242";
  public final String WORK_TYPE = "CLEANING";
  public final Long WORK_REQUEST_ID = (long) 4242;
  public final String DESCRIPTION = "Clean up the mess";
  public final boolean IS_ACTIVE = true;
  public final Long CUSTOMER_ID = (long) 4242;

  public final UserTestData userTestData;
  public final AddressTestData addressTestData;

  public WorkRequestTestData(
      final UserTestData userTestData, final AddressTestData addressTestData
  ) {

    this.userTestData = userTestData;
    this.addressTestData = addressTestData;

    WORK_REQUEST_ENTITY = createWORK_REQUEST_ENTITY();
    WORK_REQUEST_DTO = createWORK_REQUEST_DTO();
    WORK_REQUEST_LIST_DTO = createWORK_REQUEST_LIST_DTO();
    WORK_REQUEST_ENTITY_LIST = List.of(WORK_REQUEST_ENTITY);

  }

  private WorkRequestListDTO createWORK_REQUEST_LIST_DTO() {
    final WorkRequestListDTO dto = new WorkRequestListDTO();
    dto.setRequests(List.of(WORK_REQUEST_DTO));

    return dto;
  }

  private WorkRequestDTO createWORK_REQUEST_DTO() {
    final WorkRequestDTO workRequestDTO = new WorkRequestDTO();
    workRequestDTO.setWorkRequestId(WORK_REQUEST_ID);
    workRequestDTO.setWorkType(WORK_TYPE);
    workRequestDTO.setAddress(addressTestData.ADDRESS_DTO);

    workRequestDTO.setDescription(DESCRIPTION);
    return workRequestDTO;

  }

  private WorkRequestEntity createWORK_REQUEST_ENTITY() {
    final WorkRequestEntity workRequestEntity = new WorkRequestEntity();
    workRequestEntity.setCustomer(userTestData.USER);
    workRequestEntity.setWorkType(WORK_TYPE);
    workRequestEntity.setId(WORK_REQUEST_ID);
    workRequestEntity.setDescription(DESCRIPTION);
    workRequestEntity.setAddress(addressTestData.ADDRESS_ENTITY);
    return workRequestEntity;
  }

}
