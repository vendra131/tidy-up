package com.kodekonveyor.work_request.find;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.exception.ThrowableTester;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static com.kodekonveyor.completion.CompletionConstantsTestData.EXPECTED_FAILURE_STATUS;
import static com.kodekonveyor.completion.CompletionConstantsTestData.EXPECTED_LOG_API_CALL;
import static com.kodekonveyor.completion.CompletionConstantsTestData.EXPECTED_LOG_API_FAILURE;
import static com.kodekonveyor.completion.CompletionConstantsTestData.EXPECTED_LOG_API_STATUS;
import static com.kodekonveyor.completion.CompletionConstantsTestData.EXPECTED_SUCCESS_STATUS;
import static com.kodekonveyor.work_request.AddressEntityTestData.CITY;
import static com.kodekonveyor.work_request.AddressEntityTestData.COUNTRY;
import static com.kodekonveyor.work_request.create.WorkRequestValidationUtilTestData.NULL_WORKTYPE;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Logging")
@TestedService("FindWorkRequestController")

public class FindWorkRequestControllerLoggingTest
        extends FindWorkRequestControllerTestBase {

    @Test
    @DisplayName("Start of FindWorkRequestController execution is logged.")
    public void test1() {
        findWorkRequestController.call(COUNTRY, CITY, WorkRequestEntityTestData.WORK_TYPE);

        Mockito.verify(loggerService)
                .info(eq(EXPECTED_LOG_API_CALL));
    }

    @Test
    @DisplayName("End of FindWorkRequestController execution is logged.")
    public void test2() {
        findWorkRequestController.call(COUNTRY, CITY, WorkRequestEntityTestData.WORK_TYPE);

        Mockito.verify(loggerService)
                .debug(eq(EXPECTED_LOG_API_STATUS
                ), eq(EXPECTED_SUCCESS_STATUS));
    }

    @Test
    @DisplayName("Validation errors are logged with corresponding error message and FAILURE status.")
    public void test3() {
        ThrowableTester.assertThrows(() -> findWorkRequestController.call(COUNTRY, CITY, null));

        Mockito.verify(loggerService)
                .warn(
                        eq(EXPECTED_LOG_API_FAILURE),
                        eq(EXPECTED_FAILURE_STATUS),
                        eq(NULL_WORKTYPE)
                );
    }

}
