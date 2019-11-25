package com.kodekonveyor.work_request;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.authentication.UserEntityRepository;
import com.kodekonveyor.authentication.UserEntityRepositoryStubs;
import com.kodekonveyor.authentication.UserTestData;

public class CustomerWorkRequestControllerTestBase { // NOPMD

  @InjectMocks
  CustomerGetWorkRequestsController customerGetWorkRequestsController;
  @Mock
  WorkRequestRepository workRequestRepository;
  @Mock
  UserEntityRepository userEntityRepository;
  UserTestData userTestData;
  WorkRequestTestData workRequestTestData;

  AddressTestData addressTestData;

  @BeforeEach
  void setUp() {
    userTestData = new UserTestData();
    addressTestData = new AddressTestData();
    workRequestTestData =
        new WorkRequestTestData(userTestData, addressTestData);

    WorkRequestRepositoryStub
        .behaviour(workRequestRepository, workRequestTestData);
    UserEntityRepositoryStubs.behaviour(userEntityRepository, userTestData);
  }

}
