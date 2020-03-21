package com.kodekonveyor.work_request.offer;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.work_request.WorkRequestEntityRepositoryStubs;
import com.kodekonveyor.work_request.WorkRequestRepository;

public class GiveofferControllerTestBase {

  @InjectMocks
  GiveofferController giveofferController;

  @Mock
  WorkRequestRepository workRequestRepository;

  @Mock
  OfferEntityRepository offerEntityRepository;
  @Mock
  AuthenticatedUserService authenticatedUserService;

  GiveofferControllerTestData giveofferControllerTestData;

  @BeforeEach
  void setUp() {
    WorkRequestEntityRepositoryStubs
        .behaviour(workRequestRepository);
  }
}
