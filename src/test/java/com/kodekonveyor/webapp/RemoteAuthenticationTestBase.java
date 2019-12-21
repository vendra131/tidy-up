package com.kodekonveyor.webapp;

import org.junit.jupiter.api.BeforeEach;

import com.kodekonveyor.authentication.UserEntityTestData;

public class RemoteAuthenticationTestBase {

  RemoteAuthentication auth;

  @BeforeEach
  void setUp() {
    auth = new RemoteAuthentication(UserEntityTestData.get());
  }

}
