package com.kodekonveyor.work_request.offer;

import java.util.Optional;

import org.mockito.Mockito;

public class OfferEntityRepositoryStubs {

  public static void
      behaviour(final OfferEntityRepository offerEntityRepository) {
    Mockito.doReturn(Optional.of(OfferEntityTestData.getWorkRequestPosted()))
        .when(offerEntityRepository).findById(OfferDTOTestData.get().getId());
  }

}
