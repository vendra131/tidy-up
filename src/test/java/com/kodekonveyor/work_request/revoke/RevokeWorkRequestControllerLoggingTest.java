package com.kodekonveyor.work_request.revoke;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.exception.ThrowableTester;
import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.WorkRequestConstants;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static com.kodekonveyor.work_request.WorkRequestConstants.FAILURE;
import static com.kodekonveyor.work_request.WorkRequestConstants.LOG_API_CALL_FALURE_STATUS;
import static com.kodekonveyor.work_request.WorkRequestConstants.SUCCESS;
import static com.kodekonveyor.work_request.WorkRequestConstants.UNAUTHORIZE_REVOKE_WORK_REQUEST;
import static com.kodekonveyor.work_request.WorkRequestEntityTestData.INVALID_WORK_REQUEST_ID;
import static com.kodekonveyor.work_request.WorkRequestEntityTestData.NON_POSITIVE_WORK_REQUEST_ID;
import static com.kodekonveyor.work_request.WorkRequestEntityTestData.REVOKE_WORK_REQUEST_ID;
import static com.kodekonveyor.work_request.WorkRequestEntityTestData.WORK_REQUEST_ID;
import static org.mockito.ArgumentMatchers.eq;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@TestedBehaviour("Logging")
@TestedService("RevokeWorkRequestController")
public class RevokeWorkRequestControllerLoggingTest extends RevokeWorkRequestControllerTestBase {

    @Captor
    ArgumentCaptor<String> captor;

    @Test
    @DisplayName("The start of revoke work request controller is logged.")
    public void test1() {
        revokeWorkRequestController.call(WORK_REQUEST_ID);
        Mockito.verify(loggerService)
                .info(WorkRequestConstants.LOG_API_CALL);
    }

    @Test
    @DisplayName("The end of revoke work request controller is logged.")
    public void test2() {
        revokeWorkRequestController.call(WORK_REQUEST_ID);
        Mockito.verify(loggerService)
                .debug(WorkRequestConstants.LOG_API_CALL_STATUS, SUCCESS);
    }

    @Test
    @DisplayName("The access control error for  revoke work request controller is logged.")
    public void test3() {
        ThrowableTester.assertThrows(() -> revokeWorkRequestController.call(REVOKE_WORK_REQUEST_ID))
                .assertException(ValidationException.class);

        Mockito.verify(loggerService)
                .warn(eq(LOG_API_CALL_FALURE_STATUS), eq(FAILURE), captor.capture());

        Assert.assertEquals(captor.getValue(), UNAUTHORIZE_REVOKE_WORK_REQUEST);
    }

    @Test
    @DisplayName("The input validation error for negative id for  revoke work request controller is logged.")
    public void test4() {
        ThrowableTester.assertThrows(() -> revokeWorkRequestController.call(NON_POSITIVE_WORK_REQUEST_ID))
                .assertException(ValidationException.class);

        Mockito.verify(loggerService)
                .warn(eq(LOG_API_CALL_FALURE_STATUS), eq(FAILURE), captor.capture());

        Assert.assertEquals(captor.getValue(), WorkRequestConstants.NON_POSITIVE_WORK_REQUEST_ID_EXCEPTION);
    }

    @Test
    @DisplayName("The input validation error for invalid id for  revoke work request controller is logged.")
    public void test5() {
        ThrowableTester.assertThrows(() -> revokeWorkRequestController.call(INVALID_WORK_REQUEST_ID))
                .assertException(ValidationException.class);

        Mockito.verify(loggerService)
                .warn(eq(LOG_API_CALL_FALURE_STATUS), eq(FAILURE), captor.capture());

        Assert.assertEquals(captor.getValue(), WorkRequestConstants.INVALID_WORK_REQUEST_ID_EXCEPTION);
    }
}
