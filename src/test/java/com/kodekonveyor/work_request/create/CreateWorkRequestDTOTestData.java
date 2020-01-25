package com.kodekonveyor.work_request.create;

import com.kodekonveyor.work_request.AddressDTOTestData;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

public class CreateWorkRequestDTOTestData {

  public final static Long NEGATIVE_CUSTOMER_ID = (long) -4242;

  public final static String WORK_TYPE_INVALID_CHARACTER = "456$%$";
  public final static String INVALID_WORKTYPE = "CARPENTRY";

  public static CreateWorkRequestDTO getAddressMaxLength() {
    final CreateWorkRequestDTO dto = get();
    dto.setCustomerId((long) 4242);
    dto.getAddress().setAddress(AddressDTOTestData.ADDRESS_OF_120_LENGTH);
    return dto;
  }

  public static CreateWorkRequestDTO getAddressZeroLength() {
    final CreateWorkRequestDTO dto = get();
    dto.getAddress().setAddress("");
    return dto;
  }

  public static CreateWorkRequestDTO getCustomerIdZero() {
    final CreateWorkRequestDTO dto = get();
    dto.setCustomerId((long) 0);
    return dto;
  }

  public static CreateWorkRequestDTO getCountryNull() {
    final CreateWorkRequestDTO dto = get();
    dto.getAddress().setCountry(null);
    return dto;
  }

  public static CreateWorkRequestDTO get() {
    final CreateWorkRequestDTO createWorkRequest = new CreateWorkRequestDTO();
    createWorkRequest.setCustomerId(WorkRequestEntityTestData.CUSTOMER_ID);
    createWorkRequest.setWorkType(WorkRequestEntityTestData.WORK_TYPE);
    createWorkRequest.setDescription(WorkRequestEntityTestData.DESCRIPTION);
    createWorkRequest.setAddress(AddressDTOTestData.get());
    return createWorkRequest;
  }

  public static CreateWorkRequestDTO getAddressNull() {
    final CreateWorkRequestDTO dto = get();
    dto.getAddress().setAddress(null);
    return dto;
  }

  public static CreateWorkRequestDTO getCustomerIdNegative() {
    final CreateWorkRequestDTO dto = get();
    dto.setCustomerId(NEGATIVE_CUSTOMER_ID);
    return dto;
  }

  public static CreateWorkRequestDTO getWorkTypeInvalidCharacter() {
    final CreateWorkRequestDTO dto = get();
    dto.setWorkType(WORK_TYPE_INVALID_CHARACTER);
    return dto;
  }

  public static CreateWorkRequestDTO getWorkTypeInvalid() {
    final CreateWorkRequestDTO dto = get();
    dto.setWorkType(INVALID_WORKTYPE);
    return dto;
  }

  public static CreateWorkRequestDTO getCountryInvalidCharacter() {
    final CreateWorkRequestDTO dto = get();
    dto.getAddress()
        .setCountry(AddressDTOTestData.COUNTRY_WITH_INVALID_CHARACTER);
    return dto;
  }

  public static CreateWorkRequestDTO getAddressLongerThanMaxLength() {
    final CreateWorkRequestDTO dto = get();
    dto.getAddress().setAddress(AddressDTOTestData.ADDRESS_OF_121_LENGTH);
    return dto;
  }

  public static CreateWorkRequestDTO getWorkTypeNull() {
    final CreateWorkRequestDTO dto = get();
    dto.setWorkType(null);
    return dto;
  }

  public static CreateWorkRequestDTO getDescriptionNull() {
    final CreateWorkRequestDTO dto = get();
    dto.setDescription(null);
    return dto;
  }

  public static CreateWorkRequestDTO getCustomerIdNull() {
    final CreateWorkRequestDTO dto = get();
    dto.setCustomerId(null);
    return dto;
  }

  public static CreateWorkRequestDTO getCityNull() {
    final CreateWorkRequestDTO dto = get();
    dto.getAddress().setCity(null);
    return dto;
  }

  public static CreateWorkRequestDTO getCountryInvalidLength() {
    final CreateWorkRequestDTO dto = get();
    dto.getAddress().setCountry(AddressDTOTestData.COUNTRY_OF_INVALID_LENGTH);
    return dto;
  }
}
