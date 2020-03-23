package com.kodekonveyor.work_request.revoke;

import org.junit.jupiter.api.BeforeEach;
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
import com.kodekonveyor.work_request.WorkRequestEntityTestData;
import com.kodekonveyor.work_request.open.OpenWorkRequestControllerTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("input validation")
@TestedService("RevokeWorkRequestController")
public class RevokeWorkRequestControllerValidationTest
    extends RevokeWorkRequestControllerTestBase {

  @Override
  @BeforeEach
  void setUp() {
    super.setUp();
    revokeWorkRequestController
        .call(WorkRequestEntityTestData.WORK_REQUEST_ID);
  }

  @Test
  @DisplayName(
    "When the work request id is not present in repository, an exception is thrown."
  )
  public void testWorkRequestInvalidId() {
    ThrowableTester.assertThrows(
        () -> revokeWorkRequestController
            .call(WorkRequestEntityTestData.INVALID_WORK_REQUEST_ID)
    )
        .assertMessageIs(
            OpenWorkRequestControllerTestData.INVALID_WORK_REQUEST_ID_EXCEPTION
        );

  }

  @Test
  @DisplayName(
    "When the work request id is non-positive, an exception is thrown."
  )
  public void testWorkRequestNegativeId() {

    ThrowableTester.assertThrows(
        () -> revokeWorkRequestController
            .call(WorkRequestEntityTestData.NON_POSITIVE_WORK_REQUEST_ID)
    )
        .assertMessageIs(
            RevokeWorkRequestControllerTestData.NON_POSITIVE_WORK_REQUEST_ID_EXCEPTION
        );

  }

}
