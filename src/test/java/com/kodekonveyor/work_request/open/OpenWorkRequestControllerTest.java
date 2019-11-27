package com.kodekonveyor.work_request.open;

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

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Data access")
@TestedService("OpenWorkRequestController")
public class OpenWorkRequestControllerTest
    extends OpenWorkRequestControllerTestBase {

  @Test
  @DisplayName("Controller returns right DTO based on requestId")
  public void test() {
    assertEquals(
        workRequestTestData.WORK_REQUEST_DTO,
        openWorkRequestController
            .call(workRequestTestData.WORK_REQUEST_ID)
    );

  }

}
