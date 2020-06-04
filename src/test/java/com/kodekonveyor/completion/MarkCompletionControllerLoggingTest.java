package com.kodekonveyor.completion;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.exception.ThrowableTester;
import com.kodekonveyor.work_request.WorkRequestEntityRepositoryStubs;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;
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

import static com.kodekonveyor.completion.CompletionConstants.FAILURE;
import static com.kodekonveyor.completion.CompletionConstants.INVALID_WORK_REQUEST_STATUS;
import static com.kodekonveyor.completion.CompletionConstants.LOG_API_CALL;
import static com.kodekonveyor.completion.CompletionConstants.LOG_API_CALL_FALURE_STATUS;
import static com.kodekonveyor.completion.CompletionConstants.LOG_API_CALL_STATUS;
import static com.kodekonveyor.completion.CompletionConstants.SUCCESS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Logging")
@TestedService("MarkCompletionController")
public class MarkCompletionControllerLoggingTest extends MarkCompletionControllerTestBase {

    @Captor
    ArgumentCaptor<String> captorString;

    @Test
    @DisplayName(
            "The start of MarkCompletionController is Logged"
    )
    public void test1() {
        markCompletionController.call(WorkRequestEntityTestData.WORK_REQUEST_ID);

        Mockito.verify(loggerService)
                .info(
                        eq(LOG_API_CALL)
                );
    }

    @Test
    @DisplayName(
            "The successful call of MarkCompletionController is Logged"
    )
    public void test2() {
        markCompletionController.call(WorkRequestEntityTestData.WORK_REQUEST_ID);

        Mockito.verify(loggerService)
                .debug(
                        eq(LOG_API_CALL_STATUS), captorString.capture()
                );
        assertEquals(
                SUCCESS, captorString.getValue()
        );
    }

    @Test
    @DisplayName(
            "The failure call to MarkCompletionController is logged, when work state in invalid."
    )
    public void test3() {
        WorkRequestEntityRepositoryStubs.behaviour2(workRequestRepository);

        ThrowableTester.assertThrows(() -> markCompletionController.call(WorkRequestEntityTestData.WORK_REQUEST_ID))
                .assertException(IllegalStateException.class);

        Mockito.verify(loggerService)
                .warn(
                        eq(LOG_API_CALL_FALURE_STATUS), eq(FAILURE), captorString.capture()
                );

        assertEquals(
                INVALID_WORK_REQUEST_STATUS, captorString.getValue()
        );
    }

}
