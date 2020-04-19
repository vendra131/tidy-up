package com.kodekonveyor.work_request.open;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.exception.ThrowableTester;
import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("statuses")
@TestedService("OpenWorkRequestController")
public class OpenWorkRequestControllerStatusesTest
    extends OpenWorkRequestControllerTestBase {

  @Test
  @DisplayName("Work requests not posted will raise a validation exception")
  void testOne() {

    ThrowableTester.assertThrows(
        () -> openWorkRequestController
            .call(WorkRequestEntityTestData.WORK_REQUEST_ID_NOT_POSTED)
    ).assertException(ValidationException.class);

  }

  @Test
  @DisplayName(
    "For work request not posted, the error message would be 'Work request is not posted'"
  )
  void testTwo() {

    ThrowableTester.assertThrows(
        () -> openWorkRequestController
            .call(WorkRequestEntityTestData.WORK_REQUEST_ID_NOT_POSTED)
    ).assertMessageIs(
        WorkRequestEntityTestData.WORK_REQUEST_IS_NOT_POSTED_MESSAGE
    );

  }

  @Test
  @DisplayName(
    "Not posted work request for which the user is a customer, we don't throw exception"
  )
  void testThree() {

    ThrowableTester.assertNoException(
        () -> openWorkRequestController
            .call(
                WorkRequestEntityTestData.WORK_REQUEST_ID_NOT_POSTED_WITH_CUSTOMER
            )
    );

  }

  @Test
  @DisplayName(
    "Not posted work request for which the user is a provider, we don't throw exception"
  )
  void testFour() {

    ThrowableTester.assertNoException(
        () -> openWorkRequestController
            .call(
                WorkRequestEntityTestData.WORK_REQUEST_ID_NOT_POSTED_WITH_PROVIDER
            )
    );

  }
}
