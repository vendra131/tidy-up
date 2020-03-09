package com.kodekonveyor.work_request.offer;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
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
@TestedBehaviour("compile output")
@TestedService("GiveofferController")
public class GiveofferControllerCompileOutputTest
    extends GiveofferControllerTestBase {

  private OfferDTO offerDTO;

  @BeforeEach
  public void setUpTest() {
    offerDTO = giveofferController.call(OfferDTOTestData.get());
  }

  @Test
  @DisplayName("Returns an offer")
  public void testCompileOutput() {

    assertEquals(
        OfferDTOTestData.get(), offerDTO
    );
  }

  @Test
  @DisplayName("The price of the offer is returned")
  public void testPrice() {
    assertEquals(
        OfferDTOTestData.VALID_PRICE,
        offerDTO.getPrice()
    );
  }

  @Test
  @DisplayName("The Offer's unique identifier is returned")
  public void testId() {
    assertEquals(
        OfferDTOTestData.get().getId(),
        offerDTO.getId()
    );
  }

  @Test
  @DisplayName("The right work request identifier is returned.")
  public void testWorkRequest() {
    assertEquals(
        OfferDTOTestData.get().getWorkRequestId(),
        offerDTO.getWorkRequestId()
    );
  }
}
