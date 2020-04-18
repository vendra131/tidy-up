package com.kodekonveyor.completion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
import com.kodekonveyor.work_request.WorkRequestEntityRepositoryStubs;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;
import com.kodekonveyor.work_request.WorkRequestStatusEnum;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@TestedBehaviour("statuses")
@TestedService("MarkCompletionController")
public class MarkCompletionControllerStatusesTest
    extends MarkCompletionControllerTestBase {

  @Test
  @DisplayName(
    "if the status of work request is not AGREED,we throw an exception"
  )
  void testNotAgreed() {
    WorkRequestEntityRepositoryStubs.behaviour2(workRequestRepository);
    assertThrows(
        IllegalStateException.class,
        () -> markCompletionController
            .call(WorkRequestEntityTestData.WORK_REQUEST_ID)
    );
  }

  @Test
  @DisplayName(
    "if the status of work request is AGREED,we change it into COMPLETED"
  )

  void testStatusAgreedToCompleted() {
    WorkRequestEntityRepositoryStubs.agreedWorkRequest(workRequestRepository);

    assertEquals(
        WorkRequestStatusEnum.COMPLETED, markCompletionController
            .call(WorkRequestEntityTestData.WORK_REQUEST_ID).getStatus()
    );
  }

}
