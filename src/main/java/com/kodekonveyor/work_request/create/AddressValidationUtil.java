package com.kodekonveyor.work_request.create;

import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.WorkRequestConstants;

public class AddressValidationUtil {

  public static void
      validateAddressDetails(final CreateWorkRequestDTO createWorkRequestDTO) {

    if (null == createWorkRequestDTO.getAddress().getAddress())
      throw new ValidationException(WorkRequestConstants.NULL_ADDRESS_STRING);

    final int charLimit = 120;

    if (createWorkRequestDTO.getAddress().getAddress().length() > charLimit)
      throw new ValidationException(WorkRequestConstants.ADDRESS_LENGTH);

    final int charLimit1 = 0;
    if (createWorkRequestDTO.getAddress().getAddress().length() == charLimit1)
      throw new ValidationException(WorkRequestConstants.ZERO_ADDRESS_LENGTH);

  }

  public static void
      validateCityAndCountry(final CreateWorkRequestDTO createWorkRequestDTO) {

    if (null == createWorkRequestDTO.getAddress().getCity())
      throw new ValidationException(WorkRequestConstants.NULL_CITY);

    if (null == createWorkRequestDTO.getAddress().getCountry())
      throw new ValidationException(WorkRequestConstants.NULL_COUNTRY);

    final int length = 2;
    if (createWorkRequestDTO.getAddress().getCountry().length() != length)
      throw new ValidationException(WorkRequestConstants.COUNTRY_LENGTH);

    if (!createWorkRequestDTO.getAddress().getCountry().matches("^[a-z]*$"))
      throw new ValidationException(WorkRequestConstants.COUNTRY_ALPHABET);

  }
}
