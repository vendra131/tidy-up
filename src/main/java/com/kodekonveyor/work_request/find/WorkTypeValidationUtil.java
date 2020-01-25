package com.kodekonveyor.work_request.find;

import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.WorkRequestConstants;

public class WorkTypeValidationUtil {

  public static void validateWorkType(final String workType) {
    if (null == workType)
      throw new ValidationException(WorkRequestConstants.NULL_WORKTYPE);
  }

}
