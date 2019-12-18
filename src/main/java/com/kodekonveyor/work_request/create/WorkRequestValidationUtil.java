package com.kodekonveyor.work_request.create;

import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.WorkRequestConstants;

public class WorkRequestValidationUtil {

  public static void
      validateWorkRequest(final CreateWorkRequestDTO createWorkRequestDTO) {
    validateWorkType(createWorkRequestDTO);
    validateDescrption(createWorkRequestDTO);
    validateCustomerId(createWorkRequestDTO);
    AddressValidationUtil.validateAddressDetails(createWorkRequestDTO);
    AddressValidationUtil.validateCityAndCountry(createWorkRequestDTO);
  }

  public static void
      validateWorkType(final CreateWorkRequestDTO createWorkRequestDTO) {
    if (null == createWorkRequestDTO.getCustomerId())
      throw new ValidationException(WorkRequestConstants.NULL_CUSTOMERID);

    if (null == createWorkRequestDTO.getWorkType())
      throw new ValidationException(WorkRequestConstants.NULL_WORKTYPE);

    if (!createWorkRequestDTO.getWorkType().matches("^[a-zA-Z]*$"))
      throw new ValidationException(
          WorkRequestConstants.DIGIT_SPECIAL_CHARACTER_WORKTYPE
      );

  }

  public static void
      validateDescrption(final CreateWorkRequestDTO createWorkRequestDTO) {

    if (null == createWorkRequestDTO.getDescription())
      throw new ValidationException(WorkRequestConstants.NULL_DESCRIPTION);

  }

  public static void
      validateCustomerId(final CreateWorkRequestDTO createWorkRequestDTO) {

    if (createWorkRequestDTO.getCustomerId() < 0)
      throw new ValidationException(WorkRequestConstants.NEGATIVE_CUSTOMERID);

    if (createWorkRequestDTO.getCustomerId() == 0)
      throw new ValidationException(WorkRequestConstants.ZERO_CUSTOMERID);

  }

}
