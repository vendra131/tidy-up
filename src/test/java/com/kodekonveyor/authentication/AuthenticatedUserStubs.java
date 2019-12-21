package com.kodekonveyor.authentication;

import static org.mockito.Mockito.doReturn;

public class AuthenticatedUserStubs {

  public static void behaviour(
      final AuthenticatedUserService authenticatedUserService
  ) {

    doReturn(UserEntityTestData.get()).when(authenticatedUserService).call();

  }
}
