package com.kodekonveyor.webapp;

import javax.servlet.FilterChain;
import javax.servlet.ServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.security.core.Authentication;

import com.kodekonveyor.authentication.UserEntityRepository;
import com.kodekonveyor.authentication.UserEntityRepositoryStubs;

public class RemoteAuthenticationFilterTestBase {

  @InjectMocks
  RemoteAuthenticationFilter remoteAuthenticationFilter;
  @Mock
  UserEntityRepository userRepository;
  @Mock
  Logger loggerService;
  @Mock
  ServletResponse servletResponse;
  @Mock
  FilterChain filterChain;
  @Captor
  ArgumentCaptor<Authentication> newAuthentication;
  @Captor
  ArgumentCaptor<String> stringCaptor;

  @BeforeEach
  void setUp() {
    UserEntityRepositoryStubs.behaviour(userRepository);
  }

}
