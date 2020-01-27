package com.kodekonveyor.work_request.open;

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
import com.kodekonveyor.work_request.AddressEntityTestData;
import com.kodekonveyor.work_request.WorkRequestDTOTestData;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Data access")
@TestedService("OpenWorkRequestController")

public class OpenWorkRequestControllerTest
    extends OpenWorkRequestControllerTestBase {

  @Test
  @DisplayName("Work request details are returned based on work requestId")
  public void test() {
    assertEquals(
        WorkRequestDTOTestData.get(),
        openWorkRequestController
            .call(WorkRequestEntityTestData.WORK_REQUEST_ID)
    );

  }

  @Test
  @DisplayName("The work request id is returned")
  public void testWorkRequestgetId() {
    assertEquals(
        WorkRequestEntityTestData.WORK_REQUEST_ID,
        WorkRequestEntityTestData.get().getId()
    );
  }

  @Test
  @DisplayName("The work type is returned")
  public void testWorkRequestgetWorkType() {
    assertEquals(
        WorkRequestEntityTestData.WORK_TYPE,
        WorkRequestEntityTestData.get().getWorkType()
    );
  }

  @Test
  @DisplayName("The address is returned ")
  public void testWorkRequestgetAddress() {
    assertEquals(
        AddressEntityTestData.get(),
        WorkRequestEntityTestData.get().getAddress()
    );
  }

  @Test
  @DisplayName("The description is returned")
  public void testWorkRequestgetDescription() {
    assertEquals(
        WorkRequestEntityTestData.DESCRIPTION,
        WorkRequestEntityTestData.get().getDescription()
    );
  }
}
