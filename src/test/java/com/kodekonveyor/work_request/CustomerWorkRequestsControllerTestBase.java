package com.kodekonveyor.work_request;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.AuthenticatedUserStubs;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.authentication.UserEntityRepository;
import com.kodekonveyor.authentication.UserEntityRepositoryStubs;

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

  @BeforeEach
  void setUp() {

    WorkRequestEntityRepositoryStubs
        .behaviour(workRequestRepository);
    UserEntityRepositoryStubs.behaviour(userEntityRepository);
    AuthenticatedUserStubs.behaviour(authenticatedUserService);
  }

}
