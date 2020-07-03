package com.kodekonveyor.work_request.offer;

import com.kodekonveyor.authentication.UserEntityTestData;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

public class OfferEntityTestData {

  public final static long VALID_PRICE = 1;
  public final static long ZERO_PRICE = 0;
  public final static long NEGATIVE_PRICE = -1;
  public final static long ID = 0;

  public static OfferEntity get() {
    final OfferEntity offerEntity = new OfferEntity();
    offerEntity.setId(OfferDTOTestData.get().getId());
    offerEntity.setPrice(OfferDTOTestData.get().getPrice());
    offerEntity.setProvider(UserEntityTestData.get());
    offerEntity.setWorkRequest(WorkRequestEntityTestData.get());
    return offerEntity;
  }

  public static OfferEntity getWorkRequestPosted() {
    final OfferEntity offerEntity = get();
    offerEntity.setWorkRequest(WorkRequestEntityTestData.getStatusPosted());
    return offerEntity;
  }
}
