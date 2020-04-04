package com.kodekonveyor.completion;

import static org.junit.Assert.assertEquals;

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
import com.kodekonveyor.work_request.WorkRequestDTOTestData;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@TestedBehaviour("compile output")
@TestedService("MarkCompletionController")

public class MarkCompletionControllerCompileOutputTest
    extends MarkCompletionControllerTestBase {

  @Test
  @DisplayName("A work request is returned")
  void test1() {
    assertEquals(
        WorkRequestDTOTestData.get().getClass(),
        markCompletionController.call(WorkRequestEntityTestData.WORK_REQUEST_ID).getClass()
    );
  }

  @Test
  @DisplayName("The Work Request contains the right description")
  void test2() {
    assertEquals(
        WorkRequestDTOTestData.get().getDescription(),
        markCompletionController.call(WorkRequestEntityTestData.WORK_REQUEST_ID).getDescription()
    );
  }

  @Test
  @DisplayName("The Work Request ID is correct")
  void test3() {
    assertEquals(
        WorkRequestDTOTestData.get().getWorkRequestId(),
        markCompletionController.call(WorkRequestEntityTestData.WORK_REQUEST_ID).getWorkRequestId()
    );
  }

  @Test
  @DisplayName("The Work Request contains the correct work type")
  void test4() {
    assertEquals(
        WorkRequestDTOTestData.get().getWorkType(),
        markCompletionController.call(WorkRequestEntityTestData.WORK_REQUEST_ID).getWorkType()
    );
  }

  @Test
  @DisplayName("The Work Request contains the correct Address")
  void test5() {
    assertEquals(
        WorkRequestDTOTestData.get().getAddress(),
        markCompletionController.call(WorkRequestEntityTestData.WORK_REQUEST_ID).getAddress()
    );
  }
}
