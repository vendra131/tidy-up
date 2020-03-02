package com.kodekonveyor.work_request.revoke;

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

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("access control")
@TestedService("RevokeWorkRequestController")

public class RevokeWorkRequestControllerAccessControlTest
    extends RevokeWorkRequestControllerTestBase {

  RevokeWorkRequestControllerAccessControlTest() {
    super();
  }

  @Test
  @DisplayName(
    "When a user try to revoke Work Request of another user, an exception is thrown."
  )

  public void testRevokeWorkRequestOfOtherOwner() {

    ThrowableTester.assertThrows(
        () -> revokeWorkRequestController
            .call(WorkRequestEntityTestData.REVOKE_WORK_REQUEST_ID)
    )
        .assertMessageIs(
            RevokeWorkRequestControllerTestData.WORK_REQUEST_ACCESS_EXCEPTION
        );

  }

}
