package com.kodekonveyor.work_request;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.AuthenticatedUserStubs;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.authentication.UserEntityRepository;
import com.kodekonveyor.authentication.UserEntityRepositoryStubs;
import org.slf4j.Logger;

public class CustomerWorkRequestsControllerTestBase {

  @InjectMocks
  CustomerGetWorkRequestsController customerGetWorkRequestsController;

  @Mock
  WorkRequestRepository workRequestRepository;
  @Mock
  UserEntityRepository userEntityRepository;
  @Mock
  AddressEntity addressEntity;
  @Mock
  AuthenticatedUserService authenticatedUserService;
  @Mock
  Logger loggerService;
  @Captor
  ArgumentCaptor<String> captorString;

  @BeforeEach
  void setUp() {

    WorkRequestEntityRepositoryStubs
        .behaviour(workRequestRepository);
    UserEntityRepositoryStubs.behaviour(userEntityRepository);
    AuthenticatedUserStubs.behaviour(authenticatedUserService);
  }

}
