package com.kodekonveyor.work_request.create;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.AuthenticatedUserStubs;
import com.kodekonveyor.authentication.UserEntityRepository;
import com.kodekonveyor.authentication.UserEntityRepositoryStubs;
import com.kodekonveyor.authentication.UserTestData;
import com.kodekonveyor.work_request.AddressEntity;
import com.kodekonveyor.work_request.AddressTestData;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkRequestRepositoryStubs;
import com.kodekonveyor.work_request.WorkRequestTestData;

public class CreateWorkRequestControllerTestBase {

  @InjectMocks
  CreateWorkRequestController createWorkRequestController;

  @Mock
  WorkRequestRepository workRequestRepository;
  @Mock
  UserEntityRepository userEntityRepository;
  @Mock
  AddressEntity addressEntity;
  @Mock
  AuthenticatedUserService authenticatedUserService;

  UserTestData userTestData;
  WorkRequestTestData workRequestTestData;
  AddressTestData addressTestData;
  CreateWorkRequestTestData createWorkRequestTestData;

  @BeforeEach
  void setUp() {
    userTestData = new UserTestData();

    addressTestData = new AddressTestData();
    workRequestTestData =
        new WorkRequestTestData(userTestData, addressTestData);
    createWorkRequestTestData =
        new CreateWorkRequestTestData(workRequestTestData, addressTestData);

    WorkRequestRepositoryStubs
        .behaviour(workRequestRepository, workRequestTestData);
    UserEntityRepositoryStubs.behaviour(userEntityRepository, userTestData);

    AuthenticatedUserStubs.behaviour(authenticatedUserService, userTestData);
  }

}
