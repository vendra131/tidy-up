package com.kodekonveyor.work_request.offer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("logging")
@TestedService("GiveOfferController")

public class GiveOfferControllerLoggingTest
    extends GiveofferControllerTestBase {

  @BeforeEach
  public void setUpTest() {
    giveofferController.call(OfferDTOTestData.get());
  }

  @Test
  @DisplayName(
    "The call of GiveOfferController is Logged"
  )
  public void test1() {
    Mockito.verify(loggerService)
        .info(
            Mockito.eq(GiveofferControllerTestData.SERVICE_CALL_NAME), captorString.capture()
        );
    assertEquals(
        GiveofferController.class.getName(),
        captorString.getValue()
    );
  }

  @Test
  @DisplayName(
    "The call of GiveOfferController input validation is Logged"
  )
  public void test2() {
    Mockito.verify(loggerService)
        .info(
            Mockito.eq(GiveofferControllerTestData.INPUT_VALIDATION), captorString.capture()
        );
    assertEquals(
        OfferDTOTestData.get().getId(),
        captorString.getValue()
    );
  }

  @Test
  @DisplayName(
    "The call of GiveOfferController find work request is Logged"
  )
  public void test4() {
    Mockito.verify(loggerService)
        .info(
            Mockito.eq(GiveofferControllerTestData.FIND_WORK_REQUEST), captorString.capture()
        );
    assertEquals(
        OfferDTOTestData.get().getWorkRequestId(),
        captorString.getValue()
    );
  }

  @Test
  @DisplayName(
    "The call of GiveOfferController find work request SUCCESS is Logged with work request"
  )
  public void test5() {
    Mockito.verify(loggerService)
        .debug(
            Mockito.eq(GiveofferControllerTestData.FIND_WORK_REQUEST_STATUS), captorString.capture(), Mockito.eq(GiveofferControllerTestData.SUCCESS)
        );
    assertEquals(
        OfferEntityTestData.get().getWorkRequest(),
        captorString.getValue()
    );
  }

  @Test
  @DisplayName(
    "The call of GiveOfferController save work request is Logged"
  )
  public void test6() {
    Mockito.verify(loggerService)
        .info(
            Mockito.eq(GiveofferControllerTestData.SAVE_OFFER), captorString.capture()
        );
    assertEquals(
        OfferEntityTestData.get().getId(),
        captorString.getValue()
    );
  }

  @Test
  @DisplayName(
    "The call of GiveOfferController save work request SUCCESS is Logged"
  )
  public void test7() {
    Mockito.verify(loggerService)
        .debug(
            Mockito.eq(GiveofferControllerTestData.SAVE_OFFER_STATUS), captorString.capture(), Mockito.eq(GiveofferControllerTestData.SUCCESS)
        );
    assertEquals(
        OfferEntityTestData.get().getId(),
        captorString.getValue()
    );
  }
}
