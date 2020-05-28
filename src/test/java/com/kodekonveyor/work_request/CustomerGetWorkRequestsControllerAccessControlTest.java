package com.kodekonveyor.work_request;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.exception.ThrowableTester;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static com.kodekonveyor.authentication.UserEntityTestData.USER_ID_FOR_UNAUTHENTICATED_CALL;
import static com.kodekonveyor.work_request.WorkRequestConstants.UNAUTHORIZE_GET_WORK_REQUESTS_FOR_USER;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("access control")
@TestedService("CustomerGetWorkRequestsController")
public class CustomerGetWorkRequestsControllerAccessControlTest extends CustomerWorkRequestsControllerTestBase {

    @Test
    @DisplayName(
            "When a user tries to list others work request, an exception is thrown!"
    )
    public void testCustomerGetWorkRequestsControllerNullOwnerId() {
        ThrowableTester
                .assertThrows(() -> customerGetWorkRequestsController.call(String.valueOf(USER_ID_FOR_UNAUTHENTICATED_CALL)))
                .assertMessageIs(UNAUTHORIZE_GET_WORK_REQUESTS_FOR_USER);
    }
}
