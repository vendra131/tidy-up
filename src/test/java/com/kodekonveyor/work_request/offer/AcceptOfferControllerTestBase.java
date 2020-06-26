package com.kodekonveyor.work_request.offer;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.AuthenticatedUserStubs;
import com.kodekonveyor.webapp.LoggerService;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestEntityRepositoryStubs;
import com.kodekonveyor.work_request.WorkRequestRepository;

public class AcceptOfferControllerTestBase {

  @InjectMocks
  AcceptOfferController acceptOfferController;
  @Mock
  OfferEntityRepository offerEntityRepository;
  @Mock
  WorkRequestRepository workRequestRepository;
  @Mock
  AuthenticatedUserService authenticatedUserService;
  @Mock
  LoggerService loggerService;
  @Captor
  ArgumentCaptor<WorkRequestEntity> captorEntity;

  @BeforeEach
  void setUp() {
    OfferEntityRepositoryStubs.behaviour(offerEntityRepository);
    WorkRequestEntityRepositoryStubs.behaviour2(workRequestRepository);
    AuthenticatedUserStubs.behaviour(authenticatedUserService);
  }
}
