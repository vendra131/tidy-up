package com.kodekonveyor.authentication;

import static org.mockito.Mockito.doReturn;

public class AuthenticatedUserStubs {

  public static void behaviour(
      final AuthenticatedUserService authenticatedUserService,
      final UserTestData userTestData
  ) {

    doReturn(userTestData.USER).when(authenticatedUserService).call();

  }
}
