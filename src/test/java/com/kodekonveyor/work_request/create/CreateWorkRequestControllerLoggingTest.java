package com.kodekonveyor.work_request.create;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.webapp.LoggingConstants;
import com.kodekonveyor.work_request.WorkRequestConstants;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("logging")
@TestedService("CreateWorkRequestController")
public class CreateWorkRequestControllerLoggingTest
    extends CreateWorkRequestControllerTestBase {

  @Test
  @DisplayName("The call of the service is logged with INFO level")
  public void test() {
    createWorkRequestController
        .call(CreateWorkRequestDTOTestData.get());
    Mockito.verify(loggerService).info(
        WorkRequestConstants.WORK_REQUEST_RECEIVED
    );

  }

  @Test
  @DisplayName("Creation of work request entity logged with FINE level")
  public void test1() {
    createWorkRequestController
        .call(CreateWorkRequestDTOTestData.get());
    Mockito.verify(loggerService).debug(
        LoggingConstants.SUCCESS, LoggingConstants.WORK_REQUEST_ENTITY_CREATED,
        WorkRequestEntityTestData.WORK_REQUEST_ID
    );
  }

  @Test
  @DisplayName("Sucessful Input validation is logged FINE level")
  public void test2() {
    createWorkRequestController
        .call(CreateWorkRequestDTOTestData.get());
    Mockito.verify(loggerService).debug(
        LoggingConstants.SUCCESS, LoggingConstants.INPUT_VALIDATION,
        LoggingConstants.UNKNOWN
    );
  }
}
