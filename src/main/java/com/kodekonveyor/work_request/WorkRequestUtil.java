package com.kodekonveyor.work_request;

public class WorkRequestUtil {

  public static WorkRequestDTO convertWorkRequestEntityToDTO(
      final WorkRequestEntity workRequestEntity
  ) {
    final WorkRequestDTO workRequestDTO = new WorkRequestDTO();
    workRequestDTO.setWorkRequestId(workRequestEntity.getId());
    workRequestDTO.setWorkType(workRequestEntity.getWorkType());
    workRequestDTO.setDescription(workRequestEntity.getDescription());
    final AddressDTO address = new AddressDTO();
    address.setId(workRequestEntity.getAddress().getId());
    address.setAddress(workRequestEntity.getAddress().getAddress());
    address.setCity(workRequestEntity.getAddress().getCity());
    address.setCountry(workRequestEntity.getAddress().getCountry());
    workRequestDTO.setAddress(address);
    return workRequestDTO;
  }
}
