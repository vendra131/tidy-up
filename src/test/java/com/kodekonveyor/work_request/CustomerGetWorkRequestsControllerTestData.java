package com.kodekonveyor.work_request;

public class CustomerGetWorkRequestsControllerTestData {

  public static final String INVALID_OWNERID = "Invalid OwnerId";

  public static final String NEGATIVE_OWNERID = "Negative Owner Id";
  public static final String NEGATIVE_OWNERID_ID = "-4536";
  public static final String INVALID_OWNERID_ID = "4245";

  public static final String ALPHACHAR_OWNERID =
      "Contains Alphabet or Special Character";
  public static final String ALPHACHAR_OWNERID_ID = "34g&";
  public static final String LENGTHEXCEED_OWNERID =
      "Contains more than 4 digits";
  public static final String LENGTHEXCEED_OWNERID_ID = "4356734";
  public static final String NULL_OWNERID = "No OwnerId";
}
