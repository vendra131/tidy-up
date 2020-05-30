package com.kodekonveyor.work_request;


import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.exception.ThrowableTester;
import com.kodekonveyor.webapp.ValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static com.kodekonveyor.authentication.UserEntityTestData.USER_ID_FOR_UNAUTHENTICATED_CALL;
import static com.kodekonveyor.work_request.WorkRequestConstants.INVALID_OWNERID;
import static com.kodekonveyor.work_request.WorkRequestConstants.NULL_OWNERID;
import static com.kodekonveyor.work_request.WorkRequestConstants.SERVICE_CALL_NAME;
import static com.kodekonveyor.work_request.WorkRequestConstants.SUCCESS;
import static com.kodekonveyor.work_request.WorkRequestConstants.UNAUTHORIZE_GET_WORK_REQUESTS_FOR_USER;
import static com.kodekonveyor.work_request.WorkRequestEntityTestData.OWNER_ID;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Logging")
@TestedService("CustomerGetWorkRequestsController")
public class CustomerGetWorkRequestsControllerLoggingTest extends CustomerWorkRequestsControllerTestBase {

    @Test
    @DisplayName(
            "The start of Get work request controller is Logged"
    )
    public void test1() {
        customerGetWorkRequestsController.call(OWNER_ID);
        Mockito.verify(loggerService)
                .info(
                        Mockito.eq(SERVICE_CALL_NAME), captorString.capture()
                );
        assertEquals(
                CustomerGetWorkRequestsController.class.getName(),
                captorString.getValue()
        );
    }

    @Test
    @DisplayName(
            "Logging of input validation failure when owner id is null."
    )
    public void test2() {
        ThrowableTester.assertThrows(() -> customerGetWorkRequestsController.call(null))
                .assertException(ValidationException.class);

        Mockito.verify(loggerService)
                .warn(
                        Mockito.eq(WorkRequestConstants.WORK_REQUEST_INPUT_VALIDATION_ERROR), Mockito.eq(null), Mockito.eq(WorkRequestConstants.FAILURE), captorString.capture()
                );
        assertEquals(
                NULL_OWNERID,
                captorString.getValue()
        );
    }

    @Test
    @DisplayName(
            "Logging of input validation failure when owner id is null."
    )
    public void test3() {
        ThrowableTester.assertThrows(() -> customerGetWorkRequestsController.call(INVALID_OWNERID))
                .assertException(ValidationException.class);

        Mockito.verify(loggerService)
                .warn(
                        Mockito.eq(WorkRequestConstants.WORK_REQUEST_INPUT_VALIDATION_ERROR), Mockito.eq(INVALID_OWNERID), Mockito.eq(WorkRequestConstants.FAILURE), captorString.capture()
                );
        assertEquals(
                WorkRequestConstants.ALPHACHAR_OWNERID,
                captorString.getValue()
        );
    }

    @Test
    @DisplayName(
            "Logging of unauthorized api call failure."
    )
    public void test4() {
        ThrowableTester.assertThrows(() -> customerGetWorkRequestsController.call(String.valueOf(USER_ID_FOR_UNAUTHENTICATED_CALL)))
                .assertException(ValidationException.class);

        Mockito.verify(loggerService)
                .warn(
                        Mockito.eq(WorkRequestConstants.WORK_REQUEST_ERROR), captorString.capture(), Mockito.eq(WorkRequestConstants.FAILURE)
                );
        assertEquals(
                UNAUTHORIZE_GET_WORK_REQUESTS_FOR_USER,
                captorString.getValue()
        );
    }

    @Test
    @DisplayName(
            "Logging of successful api call."
    )
    public void test5() {
        customerGetWorkRequestsController.call(OWNER_ID);
        Mockito.verify(loggerService)
                .debug(
                        Mockito.eq(WorkRequestConstants.FIND_WORK_REQUEST_BY_CUSTOMER_API_CALL_STATUS), captorString.capture(), Mockito.eq(SUCCESS)
                );
        assertEquals(
                OWNER_ID,
                captorString.getValue()
        );
    }

}
