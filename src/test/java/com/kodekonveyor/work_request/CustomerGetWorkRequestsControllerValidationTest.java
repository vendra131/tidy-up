package com.kodekonveyor.work_request;

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

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("input validation")
@TestedService("CustomerGetWorkRequestsController")

public class CustomerGetWorkRequestsControllerValidationTest
    extends CustomerWorkRequestsControllerTestBase {

  @Test
  @DisplayName(
    "When owner ID is null, the message is 'No OwnerId'"
  )

  public void testCustomerGetWorkRequestsControllerNullOwnerId() {
    ThrowableTester
        .assertThrows(() -> customerGetWorkRequestsController.call(null))
        .assertMessageIs(CustomerGetWorkRequestsControllerTestData.NULL_OWNERID);
  }

  @Test
  @DisplayName(
    "Owner Id can contain only digits, alphabet and special characters not allowed"
  )
  public void testCustomerGetWorkRequestsControllerCharacterCheck2() {
    ThrowableTester
        .assertThrows(
            () -> customerGetWorkRequestsController
                .call(
                    CustomerGetWorkRequestsControllerTestData.ALPHACHAR_OWNERID_ID
                )
        )
        .assertMessageIs(
            CustomerGetWorkRequestsControllerTestData.ALPHACHAR_OWNERID
        );
  }

  @Test
  @DisplayName("When owner Id is incorrect, the message is 'Invalid OwnerId'")
  public void testCustomerGetWorkRequestsControllerInvalidOwnerId() {
    ThrowableTester
        .assertThrows(
            () -> customerGetWorkRequestsController
                .call(
                    CustomerGetWorkRequestsControllerTestData.INVALID_OWNERID_ID
                )
        )
        .assertMessageIs(
            CustomerGetWorkRequestsControllerTestData.INVALID_OWNERID
        );

  }

}
