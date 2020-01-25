package com.kodekonveyor.work_request.create;

import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.WorkRequestConstants;

public class CountryAndCityValidationUtil {

  private static final String CITY_REGEX = "^[A-Z][a-z]*$";
  private static final String COUNTRY_REGEX = "^[a-z]*$";
  private static final int COUNTRY_LENGTH = 2;

  public static void validateCountry(final String country) {

    if (null == country)
      throw new ValidationException(WorkRequestConstants.NULL_COUNTRY);

    final int length = COUNTRY_LENGTH;
    if (country.length() != length)
      throw new ValidationException(WorkRequestConstants.COUNTRY_LENGTH);

    if (!country.matches(COUNTRY_REGEX))
      throw new ValidationException(WorkRequestConstants.COUNTRY_ALPHABET);

  }

  public static void validateCity(final String city) {
    if (null == city)
      throw new ValidationException(WorkRequestConstants.NULL_CITY);

    if (!city.matches(CITY_REGEX))
      throw new ValidationException(WorkRequestConstants.CITY_ALPHABET);

  }

}
