package com.kodekonveyor.work_request.offer;

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
import com.kodekonveyor.exception.ThrowableTester;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("input validation")
@TestedService("GiveofferController")
public class GiveofferControllerInputValidationTest
    extends GiveofferControllerTestBase {

  @Test
  @DisplayName(
    "When the price is non-positive, an exception is thrown."
  )
  public void testPriceInvalidValue() {

    ThrowableTester.assertThrows(
        () -> giveofferController
            .call(OfferDTOTestData.getPriceNegative())
    )
        .assertMessageIs(
            GiveofferControllerTestData.INVALID_PRICE_EXCEPTION
        );

  }

  @Test
  @DisplayName(
    "When the price is zero, an exception is thrown."
  )
  public void testPriceZeroValue() {

    ThrowableTester.assertThrows(
        () -> giveofferController
            .call(OfferDTOTestData.getPriceZero())
    )
        .assertMessageIs(
            GiveofferControllerTestData.INVALID_PRICE_EXCEPTION
        );

  }

  @Test
  @DisplayName(
    "When the work request id is non-positive, an exception is thrown."
  )
  public void testWorkRequestNegativeId() {

    ThrowableTester.assertThrows(
        () -> giveofferController
            .call(
                OfferDTOTestData.getWorkRequestIdNonPositive()
            )
    )
        .assertMessageIs(
            GiveofferControllerTestData.NON_POSITIVE_WORK_REQUEST_ID_EXCEPTION
        );

  }

  @Test
  @DisplayName(
    "When the work request id is not present in repository, an exception is thrown."
  )
  public void testWorkRequestInvalidId() {
    ThrowableTester.assertThrows(
        () -> giveofferController
            .call(
                OfferDTOTestData
                    .getWorkrequestIdInvalid()
            )
    )
        .assertMessageIs(
            GiveofferControllerTestData.INVALID_WORK_REQUEST_ID_EXCEPTION
        );

  }

  @Test
  @DisplayName(
    "Validation is successful when the work request id is present in repository."
  )
  public void testWorkRequestValidId() {
    giveofferController
        .call(
            OfferDTOTestData.get()
        );
    assertEquals(
        WorkRequestEntityTestData.WORK_REQUEST_ID.longValue(),
        OfferDTOTestData.get().getWorkRequestId()
    );

  }

  @Test
  @DisplayName(
    "Validation is successful when the price is valid."
  )
  public void testPriceValidValue() {

    giveofferController
        .call(
            OfferDTOTestData.get()
        );
    assertEquals(
        OfferEntityTestData.VALID_PRICE,
        OfferDTOTestData.get().getPrice()
    );

  }
}
