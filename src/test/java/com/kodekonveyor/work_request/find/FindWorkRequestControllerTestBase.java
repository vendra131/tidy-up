package com.kodekonveyor.work_request.find;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.AuthenticatedUserStubs;
import com.kodekonveyor.work_request.WorkRequestEntityRepositoryStubs;
import com.kodekonveyor.work_request.WorkRequestRepository;

public class FindWorkRequestControllerTestBase {

  @InjectMocks
  FindWorkRequestController findWorkRequestController;
  @Mock
  WorkRequestRepository workRequestRepository;

  @Mock
  AuthenticatedUserService authenticatedUserService;

  @BeforeEach
  void setUp() {

    WorkRequestEntityRepositoryStubs.behaviour(
        workRequestRepository
    );

    AuthenticatedUserStubs.behaviour(authenticatedUserService);
  }
}
