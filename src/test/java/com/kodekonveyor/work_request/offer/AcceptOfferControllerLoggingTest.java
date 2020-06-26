
package com.kodekonveyor.work_request.offer;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Logging")
@TestedService("AcceptOfferController")

public class AcceptOfferControllerLoggingTest extends
    AcceptOfferControllerTestBase {

  @BeforeEach
  public void setUpTest() {
    acceptOfferController.call(OfferEntityTestData.ID);
  }

  @Test
  @DisplayName("Start of the controller is logged")

  void test1() {
    Mockito.verify(loggerService)
        .call(AcceptOfferControllerTestData.ACCEPT_OFFER_CONTROLLER_IS_STARTED);
  }

  @Test
  @DisplayName("Success of the controller is logged")

  void test2() {
    final ArgumentCaptor<String> captorString =
        ArgumentCaptor.forClass(String.class);
    Mockito.verify(
        loggerService,
        Mockito.times(AcceptOfferControllerTestData.NUMBER_OF_LOGS)
    )
        .call(
            captorString.capture()
        );
    assertTrue(
        captorString.getAllValues().get(1).contains(AcceptOfferControllerTestData.SUCCESS)
    );
  }

  @Test
  @DisplayName("WorkRequestID is logged Successfully")

  void test3() {
    final ArgumentCaptor<String> captorString =
        ArgumentCaptor.forClass(String.class);
    Mockito.verify(
        loggerService,
        Mockito.times(AcceptOfferControllerTestData.NUMBER_OF_LOGS)
    )
        .call(
            captorString.capture()
        );
    assertTrue(
        captorString.getAllValues().get(1).contains(WorkRequestEntityTestData.WORK_REQUEST_ID.toString())
    );
  }
}
