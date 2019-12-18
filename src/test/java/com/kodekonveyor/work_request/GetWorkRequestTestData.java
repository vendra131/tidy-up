package com.kodekonveyor.work_request;

public class GetWorkRequestTestData {

  public final String INVALID_OWNERID = "Invalid OwnerId";

  public final String NEGATIVE_OWNERID = "Negative Owner Id";
  public final String NEGATIVE_OWNERID_ID = "-4536";
  public final String INVALID_OWNERID_ID = "4245";

  public final String ALPHACHAR_OWNERID =
      "Contains Alphabet or Special Character";
  public final String ALPHACHAR_OWNERID_ID = "34g&";
  public final String LENGTHEXCEED_OWNERID = "Contains more than 4 digits";
  public final String LENGTHEXCEED_OWNERID_ID = "4356734";
  public final String NULL_OWNERID = "No OwnerId";
}
