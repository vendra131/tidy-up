package com.kodekonveyor.completion;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
import com.kodekonveyor.work_request.WorkRequestDTO;
import com.kodekonveyor.work_request.WorkRequestStatusEnum;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("compile output")
@TestedService("MarkAsPaidController")

public class MarkAsPaidControllerCompileOutputTest
    extends MarkAsPaidControllerStatusesTestBase {

  @Test
  @DisplayName("Work request marked as paid")
  public void markAsPaidStatusTest() {

    workRequestEntityData.setStatus(WorkRequestStatusEnum.VERIFIED);
    final WorkRequestDTO workRequestDTO =
        markAsPaidController.call(workRequestEntityData.getId());
    assertEquals(WorkRequestStatusEnum.PAID, workRequestDTO.getStatus());
  }

}
