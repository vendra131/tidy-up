package com.kodekonveyor.work_request.offer;

import static org.junit.Assert.assertEquals;

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
import com.kodekonveyor.authentication.AuthenticatedUserStubs;
import com.kodekonveyor.authentication.UserEntityTestData;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@TestedBehaviour("Save the new/modified entities")
@TestedService("GiveofferController")
public class GiveofferControllerSaveNewModifiedEntitiesTest
    extends GiveofferControllerTestBase {

  @Test
  @DisplayName("The offer is saved successfully")
  public void testSaveNewModifiedEntities() {
    AuthenticatedUserStubs.behaviour(authenticatedUserService);
    giveofferController.call(OfferDTOTestData.get());

    Mockito.verify(offerEntityRepository).save(OfferEntityTestData.get());
  }

  @Test
  @DisplayName("The work request identifier is saved successfully.")
  public void testWorkRequestSavedId() {
    assertEquals(
        WorkRequestEntityTestData.WORK_REQUEST_ID,
        OfferEntityTestData.get().getWorkRequest().getId()
    );

  }

  @Test
  @DisplayName("The provider is saved successfully")
  public void testSavedUserEntity() {
    assertEquals(
        UserEntityTestData.get(),
        OfferEntityTestData.get().getProvider()
    );

  }

  @Test
  @DisplayName("The price of the offer is saved successfully ")
  public void testSavedPrice() {
    assertEquals(
        Long.valueOf(OfferDTOTestData.VALID_PRICE), OfferEntityTestData.get().getPrice()
    );
  }
}
