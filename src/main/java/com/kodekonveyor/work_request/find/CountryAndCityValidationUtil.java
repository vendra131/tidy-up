package com.kodekonveyor.work_request.find;

import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.WorkRequestConstants;

public class CountryAndCityValidationUtil {

  public static void
      validateCountry(final String country) {

    if (null == country)
      throw new ValidationException(WorkRequestConstants.NULL_COUNTRY);

    final int length = 2;
    if (country.length() != length)
      throw new ValidationException(WorkRequestConstants.COUNTRY_LENGTH);

    if (!country.matches("^[a-z]*$"))
      throw new ValidationException(WorkRequestConstants.COUNTRY_ALPHABET);

  }

  public static void
      validateCity(final String city) {
    if (null == city)
      throw new ValidationException(WorkRequestConstants.NULL_CITY);

    if (!city.matches("^[A-Z][a-z]*$"))
      throw new ValidationException(WorkRequestConstants.CITY_ALPHABET);

  }
}
