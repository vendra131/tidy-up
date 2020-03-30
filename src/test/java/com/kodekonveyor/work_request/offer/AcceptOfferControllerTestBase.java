package com.kodekonveyor.work_request.offer;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.work_request.WorkRequestEntityRepositoryStubs;
import com.kodekonveyor.work_request.WorkRequestRepository;

public class AcceptOfferControllerTestBase {

  @InjectMocks
  AcceptOfferController acceptOfferController;
  @Mock
  OfferEntityRepository offerEntityRepository;
  @Mock
  WorkRequestRepository workRequestRepository;

  @BeforeEach
  void setUp() {
    OfferEntityRepositoryStubs.behaviour(offerEntityRepository);
    WorkRequestEntityRepositoryStubs.behaviour2(workRequestRepository);
  }
}
