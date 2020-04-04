package com.kodekonveyor.webapp;

public class ValidationException extends RuntimeException {

  private static final long serialVersionUID = 8099048825122345809L;

  public ValidationException(final String nullOwnerId) {
    super(nullOwnerId);
  }

}
