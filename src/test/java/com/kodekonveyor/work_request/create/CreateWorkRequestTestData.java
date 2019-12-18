package com.kodekonveyor.work_request.create;

import com.kodekonveyor.work_request.AddressTestData;
import com.kodekonveyor.work_request.WorkRequestTestData;

public class CreateWorkRequestTestData { // NOPMD

  public final CreateWorkRequestDTO CREATE_WORK_REQUEST;
  public final CreateWorkRequestDTO CREATE_WORK_REQUEST_NULL_WORKTYPE;
  public final CreateWorkRequestDTO CREATE_WORK_REQUEST_NULL_DESCRIPTION;

  public final CreateWorkRequestDTO CREATE_WORK_REQUEST_NULL_CUSTOMERID;
  public final CreateWorkRequestDTO CREATE_WORK_REQUEST_NULL_ADDRESS_STRING;
  public final CreateWorkRequestDTO CREATE_WORK_REQUEST_NULL_COUNTRY;
  public final CreateWorkRequestDTO CREATE_WORK_REQUEST_NULL_CITY;
  public final CreateWorkRequestDTO CREATE_WORK_REQUEST_NEGATIVE_CUSTOMERID;
  public final CreateWorkRequestDTO CREATE_WORK_REQUEST_DIGIT_SPECIAL_CHARACTER_WORKTYPE;
  public final CreateWorkRequestDTO CREATE_WORK_REQUEST_INVALID_WORKTYPE;
  public final CreateWorkRequestDTO CREATE_WORK_REQUEST_COUNTRY_LENGTH;
  public final CreateWorkRequestDTO CREATE_WORK_REQUEST_COUNTRY_ALPHABET;
  public final CreateWorkRequestDTO CREATE_WORK_REQUEST_ADDRESS_LENGTH;

  public final String NULL_DESCRIPTION = "Blank Description";

  public final Long NEGATIVE_CUSTOMER_ID = (long) -4242;
  public final Long LENGTH_CUSTOMER_ID = (long) 42_425;

  public final String NULL_ADDRESS = "Blank Address";
  public final String NULL_CUSTOMERID = "Blank Customer Id";
  public final String NULL_ADDRESS_STRING = "Blank Address Field";
  public final String NEGATIVE_CUSTOMERID_ERROR_MESSAGE =
      "Negative Customer Id";
  public final String LENGTH_CUSTOMERID =
      "Length of Customer Id cannot be more be 4 digit";
  public final String DIGIT_SPECIAL_CHARACTER_WORKTYPE_ERROR =
      "Work Type contains digits or special characters";
  public final String WORK_TYPE_DIGIT_SPECIAL = "456$%$";
  public final String INVALID_WORKTYPE = "CARPENTRY";
  public final String INVALID_WORKTYPE_ERROR_MESSAGE = "Invalid Work Type";
  public final long NEGATIVE_WORK_REQUEST_ID = -42;
  public final String NEGATIVE_WORK_REQUEST_ID_EXCEPTION =
      "Work Request Id cannot be negative";
  public final long DECIMAL_WORK_REQUEST_ID = (long) 47.55;
  public final String DECIMAL_WORK_REQUEST_ID_EXCEPTION =
      "Work Request Id should be an integer";
  public final String NULL_WORKTYPE = "Blank Work Type";
  public final CreateWorkRequestDTO CREATE_WORK_REQUEST_CUSTOMER_ID_LENGTH;

  public final AddressTestData addressTestData;
  public final WorkRequestTestData workRequestTestData; // NOPMD
  public final String CUSTOMER_ID_LENGTH_ERROR =
      "Customer ID should not be longer than 4 digit";
  public final CreateWorkRequestDTO CREATE_WORK_REQUEST_ZERO_CUSTOMERID;
  public String ZERO_CUSTOMERID_ERROR_MESSAGE = "Customer Id cannot be zero";
  public CreateWorkRequestDTO CREATE_WORK_REQUEST_ZERO_ADDRESS_LENGTH;
  public CreateWorkRequestDTO CREATE_WORK_REQUEST_MAX_ADDRESS_LENGTH;

  public CreateWorkRequestTestData(
      final WorkRequestTestData workRequestTestData,
      final AddressTestData addressTestData
  ) {
    this.workRequestTestData = workRequestTestData;
    this.addressTestData = addressTestData;

    CREATE_WORK_REQUEST = createCREATE_WORK_REQUEST();
    CREATE_WORK_REQUEST_NULL_CITY = createCREATE_WORK_REQUEST_NULL_CITY();
    CREATE_WORK_REQUEST_COUNTRY_LENGTH =
        createCREATE_WORK_REQUEST_COUNTRY_LENGTH();

    CREATE_WORK_REQUEST_NULL_CUSTOMERID =
        createCREATE_WORK_REQUEST_NULL_CUSTOMERID();
    CREATE_WORK_REQUEST_NULL_DESCRIPTION =
        createCREATE_WORK_REQUEST_NULL_DESCRIPTION();
    CREATE_WORK_REQUEST_NULL_WORKTYPE =
        createCREATE_WORK_REQUEST_NULL_WORKTYPE();
    CREATE_WORK_REQUEST_ADDRESS_LENGTH =
        createCREATE_WORK_REQUEST_ADDRESS_LENGTH();
    CREATE_WORK_REQUEST_COUNTRY_ALPHABET =
        createCREATE_WORK_REQUEST_COUNTRY_ALPHABET();
    CREATE_WORK_REQUEST_INVALID_WORKTYPE =
        createCREATE_WORK_REQUEST_INVALID_WORKTYPE();
    CREATE_WORK_REQUEST_DIGIT_SPECIAL_CHARACTER_WORKTYPE =
        createCREATE_WORK_REQUEST_DIGIT_SPECIAL_CHARACTER_WORKTYPE();
    CREATE_WORK_REQUEST_NEGATIVE_CUSTOMERID =
        createCREATE_WORK_REQUEST_NEGATIVE_CUSTOMERID();
    CREATE_WORK_REQUEST_NULL_ADDRESS_STRING =
        createCREATE_WORK_REQUEST_NULL_ADDRESS_STRING();
    CREATE_WORK_REQUEST_NULL_COUNTRY = createCREATE_WORK_REQUEST_NULL_COUNTRY();
    CREATE_WORK_REQUEST_CUSTOMER_ID_LENGTH =
        createCREATE_WORK_REQUEST_CUSTOMER_ID_LENGTH();
    CREATE_WORK_REQUEST_ZERO_CUSTOMERID =
        createCREATE_WORK_REQUEST_ZERO_CUSTOMERID();
    CREATE_WORK_REQUEST_ZERO_ADDRESS_LENGTH =
        createCREATE_WORK_REQUEST_ZERO_ADDRESS_LENGTH();
    CREATE_WORK_REQUEST_MAX_ADDRESS_LENGTH =
        createCREATE_WORK_REQUEST_MAX_ADDRESS_LENGTH();
  }

  private CreateWorkRequestDTO createCREATE_WORK_REQUEST_MAX_ADDRESS_LENGTH() {
    final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
    dto.setCustomerId((long) 4242);
    dto.setAddress(addressTestData.MAX_ADDRESS_DTO);
    return dto;
  }

  private CreateWorkRequestDTO createCREATE_WORK_REQUEST_ZERO_ADDRESS_LENGTH() {
    final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
    dto.setAddress(addressTestData.ZERO_ADDRESS_DTO);
    return dto;
  }

  private CreateWorkRequestDTO createCREATE_WORK_REQUEST_ZERO_CUSTOMERID() {
    final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
    dto.setCustomerId((long) 0);
    return dto;
  }

  private CreateWorkRequestDTO createCREATE_WORK_REQUEST_NULL_COUNTRY() {
    final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
    dto.setAddress(addressTestData.ADDRESS_DTO_NULL_COUNRTY);
    return dto;
  }

  private CreateWorkRequestDTO createCREATE_WORK_REQUEST_CUSTOMER_ID_LENGTH() {
    final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
    dto.setCustomerId(LENGTH_CUSTOMER_ID);
    return dto;
  }

  private CreateWorkRequestDTO createCREATE_WORK_REQUEST() {
    final CreateWorkRequestDTO createWorkRequest = new CreateWorkRequestDTO();
    createWorkRequest.setCustomerId(workRequestTestData.CUSTOMER_ID);
    createWorkRequest.setWorkType(workRequestTestData.WORK_TYPE);
    createWorkRequest.setDescription(workRequestTestData.DESCRIPTION);
    createWorkRequest.setAddress(addressTestData.ADDRESS_DTO);
    return createWorkRequest;
  }

  private CreateWorkRequestDTO createCREATE_WORK_REQUEST_NULL_ADDRESS_STRING() {
    final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
    dto.setAddress(addressTestData.ADDRESS_DTO_NULL_STRING);
    return dto;
  }

  private CreateWorkRequestDTO createCREATE_WORK_REQUEST_NEGATIVE_CUSTOMERID() {
    final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
    dto.setCustomerId(NEGATIVE_CUSTOMER_ID);
    return dto;
  }

  private CreateWorkRequestDTO
      createCREATE_WORK_REQUEST_DIGIT_SPECIAL_CHARACTER_WORKTYPE() {
    final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
    dto.setWorkType(WORK_TYPE_DIGIT_SPECIAL);
    return dto;
  }

  private CreateWorkRequestDTO createCREATE_WORK_REQUEST_INVALID_WORKTYPE() {
    final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
    dto.setWorkType(INVALID_WORKTYPE);
    return dto;
  }

  private CreateWorkRequestDTO createCREATE_WORK_REQUEST_COUNTRY_ALPHABET() {
    final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
    dto.setAddress(addressTestData.ADDRESS_DTO_COUNRTY_ALPHABET);

    return dto;
  }

  private CreateWorkRequestDTO createCREATE_WORK_REQUEST_ADDRESS_LENGTH() {
    final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
    dto.setAddress(addressTestData.ADDRESS_DTO_ADDRESS_LENGTH);
    return dto;
  }

  private CreateWorkRequestDTO createCREATE_WORK_REQUEST_NULL_WORKTYPE() {
    final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
    dto.setWorkType(null);
    return dto;
  }

  private CreateWorkRequestDTO createCREATE_WORK_REQUEST_NULL_DESCRIPTION() {
    final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
    dto.setDescription(null);
    return dto;
  }

  private CreateWorkRequestDTO createCREATE_WORK_REQUEST_NULL_CUSTOMERID() {
    final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
    dto.setCustomerId(null);
    return dto;
  }

  private CreateWorkRequestDTO createCREATE_WORK_REQUEST_NULL_CITY() {
    final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
    dto.setAddress(addressTestData.ADDRESS_DTO_NULL_CITY);
    return dto;
  }

  private CreateWorkRequestDTO createCREATE_WORK_REQUEST_COUNTRY_LENGTH() {
    final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
    dto.setAddress(addressTestData.ADDRESS_DTO_COUNTRY_LENGTH);
    return dto;
  }
}
