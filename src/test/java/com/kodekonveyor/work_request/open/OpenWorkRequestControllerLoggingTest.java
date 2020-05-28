package com.kodekonveyor.work_request.open;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
import com.kodekonveyor.exception.ThrowableTester;
import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;
import com.kodekonveyor.work_request.offer.GiveofferControllerTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Logging")
@TestedService("OpenWorkRequestController")
public class OpenWorkRequestControllerLoggingTest
    extends OpenWorkRequestControllerTestBase {

  @Test
  @DisplayName(
    "The start of Open work request controller is Logged"
  )
  public void test1() {
    openWorkRequestController.call(WorkRequestEntityTestData.WORK_REQUEST_ID);
    Mockito.verify(loggerService)
        .info(
            Mockito.eq(GiveofferControllerTestData.SERVICE_CALL_NAME), captorString.capture()
        );
    assertEquals(
        OpenWorkRequestController.class.getName(),
        captorString.getValue()
    );
  }

  @Test
  @DisplayName(
    "Work requests not posted will raise a validation exception which is logged"
  )
  void test2() {

    ThrowableTester.assertThrows(
        () -> openWorkRequestController
            .call(WorkRequestEntityTestData.WORK_REQUEST_ID_NOT_POSTED)
    ).assertException(ValidationException.class);
    Mockito.verify(loggerService)
        .warn(
            Mockito.eq(
                OpenWorkRequestControllerTestData.WORK_REQUEST_ERROR
            ), captorString.capture(),
            Mockito.eq(OpenWorkRequestControllerTestData.FAILURE)
        );
    assertEquals(
        OpenWorkRequestControllerTestData.WORK_REQUEST_IS_NOT_POSTED,
        captorString.getValue()
    );
  }

  @Test
  @DisplayName(
    "Invalid work request id exception is logged when an invalid work request is sent"
  )
  void test3() {

    ThrowableTester.assertThrows(
        () -> openWorkRequestController
            .call(WorkRequestEntityTestData.INVALID_WORK_REQUEST_ID)
    )
        .assertMessageIs(
            OpenWorkRequestControllerTestData.INVALID_WORK_REQUEST_ID_EXCEPTION
        );
    Mockito.verify(loggerService)
        .warn(
            Mockito.eq(
                OpenWorkRequestControllerTestData.INPUT_VALIDATION_STATUS
            ), captorString.capture(),
            Mockito.eq(OpenWorkRequestControllerTestData.FAILURE)
        );
    assertEquals(
        OpenWorkRequestControllerTestData.INVALID_WORK_REQUEST_ID_EXCEPTION,
        captorString.getValue()
    );
  }

  @Test
  @DisplayName(
    "when a negative work request Id is sent, exception is raised and logged"
  )
  void test4() {

    ThrowableTester.assertThrows(
        () -> openWorkRequestController
            .call(WorkRequestEntityTestData.NON_POSITIVE_WORK_REQUEST_ID)
    )
        .assertMessageIs(
            OpenWorkRequestControllerTestData.NON_POSITIVE_WORK_REQUEST_ID_EXCEPTION
        );
    Mockito.verify(loggerService)
        .warn(
            Mockito.eq(
                OpenWorkRequestControllerTestData.INPUT_VALIDATION_STATUS
            ), captorString.capture(),
            Mockito.eq(OpenWorkRequestControllerTestData.FAILURE)
        );
    assertEquals(
        OpenWorkRequestControllerTestData.NON_POSITIVE_WORK_REQUEST_ID_EXCEPTION,
        captorString.getValue()
    );
  }

  @Test
  @DisplayName(
    "The OpenWorkRequestController service success is Logged when all the required checks are completed"
  )
  public void test5() {
    openWorkRequestController.call(WorkRequestEntityTestData.WORK_REQUEST_ID);
    Mockito.verify(loggerService)
        .debug(
            Mockito.eq(OpenWorkRequestControllerTestData.OPEN_WORK_REQUEST), Mockito.eq(OpenWorkRequestControllerTestData.SUCCESS)
        );
  }

}
