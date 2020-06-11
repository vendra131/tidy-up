package com.kodekonveyor.completion;

public class CompletionConstants {

  public static final String MARK_AS_PAID_PATH = "/paid/{workRequestId}";
  public static final String MARK_AS_PAID_WORK_REQUEST_ID = "workRequestId";

  public static final String LOG_API_CALL = "Api execution starts!";
  public static final String LOG_API_CALL_STATUS = "Api call status : {}";
  public static final String LOG_API_CALL_FALURE_STATUS = "Api call status : {}, error : {}";
  public static final String SUCCESS = "SUCCESS";
  public static final String FAILURE = "FAILURE";
  public static final String INVALID_WORK_REQUEST_STATUS = "Invalid work status!";
  public static final String INVALID_WORK_STATE_FOR_MARK_PAID = "Invalid work request status for marking as paid.";
}
