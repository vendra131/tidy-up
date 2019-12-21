package com.kodekonveyor.work_request.open;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.authentication.UserEntityRepository;
import com.kodekonveyor.authentication.UserEntityRepositoryStubs;
import com.kodekonveyor.work_request.AddressEntity;
import com.kodekonveyor.work_request.WorkRequestEntityRepositoryStubs;
import com.kodekonveyor.work_request.WorkRequestRepository;

public class OpenWorkRequestControllerTestBase {

  @InjectMocks
  OpenWorkRequestController openWorkRequestController;

  @Mock
  WorkRequestRepository workRequestRepository;
  @Mock
  UserEntityRepository userEntityRepository;
  @Mock
  AddressEntity addressEntity;

  @BeforeEach
  void setUp() {
    WorkRequestEntityRepositoryStubs
        .behaviour(workRequestRepository);
    UserEntityRepositoryStubs.behaviour(userEntityRepository);
  }

}
