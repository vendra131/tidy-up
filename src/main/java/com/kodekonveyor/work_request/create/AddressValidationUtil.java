package com.kodekonveyor.work_request.create;

import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.WorkRequestConstants;

public class AddressValidationUtil {

  private static final int ADDRESS_LENGTH_LIMIT = 120;

  public static void
      validateCityAndCountry(final CreateWorkRequestDTO createWorkRequestDTO) {

    final String city = createWorkRequestDTO.getAddress().getCity();
    CountryAndCityValidationUtil.validateCity(city);

    final String country = createWorkRequestDTO.getAddress().getCountry();
    CountryAndCityValidationUtil.validateCountry(country);

  }

  public static void
      validateAddressDetails(final CreateWorkRequestDTO createWorkRequestDTO) {

    if (null == createWorkRequestDTO.getAddress().getAddress())
      throw new ValidationException(WorkRequestConstants.NULL_ADDRESS_STRING);

    final int charLimit = ADDRESS_LENGTH_LIMIT;

    if (createWorkRequestDTO.getAddress().getAddress().length() > charLimit)
      throw new ValidationException(WorkRequestConstants.ADDRESS_LENGTH);

    final int charLimit1 = 0;
    if (createWorkRequestDTO.getAddress().getAddress().length() == charLimit1)
      throw new ValidationException(WorkRequestConstants.ZERO_ADDRESS_LENGTH);

  }
}
