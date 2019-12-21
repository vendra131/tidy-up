package com.kodekonveyor.work_request;

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

  @BeforeEach
  void setUp() {

    WorkRequestEntityRepositoryStubs
        .behaviour(workRequestRepository);
    UserEntityRepositoryStubs.behaviour(userEntityRepository);
  }

}
