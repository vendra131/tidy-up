package com.kodekonveyor.work_request;

import java.util.List;

public class WorkRequestDTOTestData {

  public static WorkRequestListDTO list() {
    final WorkRequestListDTO dto = new WorkRequestListDTO();
    dto.setRequests(List.of(get()));

    return dto;
  }

  public static WorkRequestDTO get() {
    final WorkRequestDTO workRequestDTO = new WorkRequestDTO();
    workRequestDTO.setWorkRequestId(WorkRequestEntityTestData.WORK_REQUEST_ID);
    workRequestDTO.setWorkType(WorkRequestEntityTestData.WORK_TYPE);
    workRequestDTO.setAddress(AddressDTOTestData.get());
    workRequestDTO.setDescription(WorkRequestEntityTestData.DESCRIPTION);
    return workRequestDTO;

  }

}
