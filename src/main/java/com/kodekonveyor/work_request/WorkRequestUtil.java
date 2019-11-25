package com.kodekonveyor.work_request;

public class WorkRequestUtil {

  public static WorkRequestDTO convertWorkRequestEntityToDTO(
      final WorkRequestEntity workRequestEntity
  ) {
    final WorkRequestDTO workRequestDTO = new WorkRequestDTO();
    workRequestDTO.setWorkRequestId(workRequestEntity.getId());
    workRequestDTO.setWorkType(workRequestEntity.getWorkType());
    workRequestDTO.setDescription(workRequestEntity.getDescription());
    return workRequestDTO;
  }
}
