package com.kodekonveyor.work_request.create;

public class WorkRequestValidationUtilTestData {

  public static final String CITY_CANNOT_BE_EMPTY = "City cannot be empty";
  public static final String COUNTRY_CANNOT_BE_EMPTY =
      "Country cannot be empty";
  public static final String COUNTRY_LENGTH_ERROR_MESSAGE =
      "Country cannot be more or less than 2 letter";
  public static final String COUNTRY_CODE_NON_ALPHABETIC_CHARACTER_ERROR_MESSAGE =
      "Country can contain alphabetic characters/letters only";
  public static final String ADDRESS_LENGTH_EXCEEDED =
      "Address can contains only 120 characters";
  public static final String ADDRESS_CANNOT_BE_BLANK =
      "Address cannot be blank";
  public final static String NULL_ADDRESS_STRING = "Blank Address Field";
  public final static String NEGATIVE_CUSTOMERID_ERROR_MESSAGE =
      "Negative Customer Id";
  public final static String LENGTH_CUSTOMERID =
      "Length of Customer Id cannot be more than 4 digit";
  public final static String DIGIT_SPECIAL_CHARACTER_WORKTYPE_ERROR =
      "Work Type contains digits or special characters";
  public final static String DECIMAL_WORK_REQUEST_ID_EXCEPTION =
      "Work Request Id should be an integer";
  public final static String NULL_WORKTYPE = "Blank Work Type";
  public final static String INVALID_WORKTYPE_ERROR_MESSAGE =
      "Invalid Work Type";
  public final static String NEGATIVE_WORK_REQUEST_ID_EXCEPTION =
      "Work Request Id cannot be negative";
  public final static String ZERO_CUSTOMERID_ERROR_MESSAGE =
      "Customer Id cannot be zero";
  public final static String NULL_DESCRIPTION = "Blank Description";
  public final static String NULL_ADDRESS = "Blank Address";
  public final static String NULL_CUSTOMERID = "Blank Customer Id";

}
