package com.kodekonveyor.work_request.create;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.AuthenticatedUserStubs;
import com.kodekonveyor.authentication.UserTestData;
import com.kodekonveyor.work_request.AddressTestData;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkRequestTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Data access")
@TestedService("CreateWorkRequestController")
public class CreateWorkRequestControllerTest {

  @InjectMocks
  private CreateWorkRequestController createWorkRequestController;
  @Mock
  private WorkRequestRepository workRequestRepository;
  @Mock
  private AuthenticatedUserService authenticatedUserService;
  private WorkRequestTestData workRequestTestData;

  @BeforeEach
  public void setUp() {
    final UserTestData userTestData = new UserTestData();
    final AddressTestData addressTestData = new AddressTestData();
    workRequestTestData =
        new WorkRequestTestData(userTestData, addressTestData);
    AuthenticatedUserStubs.behaviour(authenticatedUserService, userTestData);
    createWorkRequestController.call(workRequestTestData.CREATE_WORK_REQUEST);
    verify(workRequestRepository).save(workRequestTestData.WORK_REQUEST_ENTITY);
  }

  @Test
  @DisplayName(
    "Controller files WorkType of WorkRequestEntity based on request"
  )
  public void test() {
    assertEquals(
        workRequestTestData.WORK_TYPE,
        workRequestTestData.WORK_REQUEST_ENTITY.getWorkType()
    );
  }

  @Test
  @DisplayName("Controller files Id of WorkRequestEntity based on request")
  public void test1() {
    assertEquals(
        workRequestTestData.WORK_REQUEST_ID,
        workRequestTestData.WORK_REQUEST_ENTITY.getId()
    );
  }

  @Test
  @DisplayName(
    "Controller files Description of WorkRequestEntity based on request"
  )
  public void test2() {
    assertEquals(
        workRequestTestData.DESCRIPTION,
        workRequestTestData.WORK_REQUEST_ENTITY.getDescription()
    );
  }

  @Test
  @DisplayName(
    "Controller files customer of WorkRequestEntity based on request"
  )
  public void test3() {
    assertEquals(
        workRequestTestData.userTestData.USER,
        workRequestTestData.WORK_REQUEST_ENTITY.getCustomer()
    );
  }

  @Test
  @DisplayName("Controller files address of WorkRequestEntity based on request")
  public void test4() {
    assertEquals(
        workRequestTestData.addressTestData.ADDRESS_ENTITY,
        workRequestTestData.WORK_REQUEST_ENTITY.getAddress()
    );
  }

}
