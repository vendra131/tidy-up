package com.kodekonveyor.work_request;

import java.util.List;

import com.kodekonveyor.authentication.UserEntityTestData;

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
    workRequestDTO.setStatus(WorkRequestStatusEnum.POSTED);
    workRequestDTO.setDescription(WorkRequestEntityTestData.DESCRIPTION);
    return workRequestDTO;

  }

  public static WorkRequestDTO getStatusPosted() {
    final WorkRequestDTO workRequestDTO = get();
    workRequestDTO.setStatus(WorkRequestStatusEnum.POSTED);

    return workRequestDTO;
  }

  public static WorkRequestDTO getStatusAgreedAndProvider() {
    final WorkRequestDTO workRequestDTO = get();
    workRequestDTO.setStatus(WorkRequestStatusEnum.AGREED);
    workRequestDTO.setProvider(UserEntityTestData.get());

    return workRequestDTO;
  }

}
