package com.kodekonveyor.completion;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.exception.ThrowableTester;
import com.kodekonveyor.work_request.WorkRequestEntityRepositoryStubs;
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

import static com.kodekonveyor.completion.CompletionConstantsTestData.EXPECTED_FAILURE_STATUS;
import static com.kodekonveyor.completion.CompletionConstantsTestData.EXPECTED_LOG_API_CALL;
import static com.kodekonveyor.completion.CompletionConstantsTestData.EXPECTED_LOG_API_FAILURE;
import static com.kodekonveyor.completion.CompletionConstantsTestData.EXPECTED_LOG_API_STATUS;
import static com.kodekonveyor.completion.CompletionConstantsTestData.EXPECTED_SUCCESS_STATUS;
import static com.kodekonveyor.work_request.WorkRequestEntityTestData.VERIFIED_WORK_REQUEST_ID;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Logging")
@TestedService("MarkAsPaidController")

public class MarkAsPaidControllerLoggingTest
        extends MarkAsPaidControllerStatusesTestBase {

    @Captor
    ArgumentCaptor<String> errorCaptor;

    @Test
    @DisplayName("Start of Mark as paid api execution is logged.")
    public void test1() {
        WorkRequestEntityRepositoryStubs.verifiedWorkRequest(workRequestRepository);

        markAsPaidController.call(VERIFIED_WORK_REQUEST_ID);

        Mockito.verify(loggerService)
                .info(eq(EXPECTED_LOG_API_CALL));
    }

    @Test
    @DisplayName("End of Mark as paid api execution is logged.")
    public void test2() {
        WorkRequestEntityRepositoryStubs.verifiedWorkRequest(workRequestRepository);

        markAsPaidController.call(VERIFIED_WORK_REQUEST_ID);

        Mockito.verify(loggerService)
                .debug(eq(EXPECTED_LOG_API_STATUS
                ), eq(EXPECTED_SUCCESS_STATUS));
    }

    @Test
    @DisplayName("Error  is logged when the status of work request is not verified.")
    public void test3() {
        ThrowableTester.assertThrows(() -> markAsPaidController.call(workRequestEntityData.getId()));

        Mockito.verify(loggerService)
                .warn(eq(EXPECTED_LOG_API_FAILURE), eq(EXPECTED_FAILURE_STATUS), errorCaptor.capture());

        Assert.assertEquals(errorCaptor.getValue(), CompletionConstantsTestData.EXPECTED_MARK_PAID_ERROR_INVALID_STATUS);
    }

}
