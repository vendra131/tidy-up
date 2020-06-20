package com.kodekonveyor.work_request.find;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.AuthenticatedUserStubs;
import com.kodekonveyor.work_request.WorkRequestEntityRepositoryStubs;
import com.kodekonveyor.work_request.WorkRequestRepository;
import org.slf4j.Logger;

public class FindWorkRequestControllerTestBase {

  @InjectMocks
  FindWorkRequestController findWorkRequestController;
  @Mock
  WorkRequestRepository workRequestRepository;

  @Mock
  AuthenticatedUserService authenticatedUserService;

  @Mock
  Logger loggerService;

  @BeforeEach
  void setUp() {

    WorkRequestEntityRepositoryStubs.behaviour(
        workRequestRepository
    );

    AuthenticatedUserStubs.behaviour(authenticatedUserService);
  }
}
