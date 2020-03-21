package com.kodekonveyor.work_request.offer;

import com.kodekonveyor.authentication.UserEntityTestData;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

public class OfferEntityTestData {

  public static OfferEntity get() {
    final OfferEntity offerEntity = new OfferEntity();
    offerEntity.setId(OfferDTOTestData.get().getId());
    offerEntity.setPrice(OfferDTOTestData.get().getPrice());
    offerEntity.setProvider(UserEntityTestData.get());
    offerEntity.setWorkRequest(WorkRequestEntityTestData.get());
    return offerEntity;
  }

}
