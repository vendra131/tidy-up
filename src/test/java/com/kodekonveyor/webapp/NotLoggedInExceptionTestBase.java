package com.kodekonveyor.webapp;

import org.junit.jupiter.api.BeforeEach;

public class NotLoggedInExceptionTestBase {

  public static final String MESSAGE = "message";
  NotLoggedInException exception;

  @BeforeEach
  void setUp() {
    exception = new NotLoggedInException(MESSAGE);
  }

}
