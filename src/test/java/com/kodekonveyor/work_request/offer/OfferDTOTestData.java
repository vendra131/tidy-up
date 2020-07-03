package com.kodekonveyor.work_request.offer;

import com.kodekonveyor.work_request.WorkRequestEntityTestData;

public class OfferDTOTestData {

  public static OfferDTO getPriceNegative() {
    final OfferDTO dto = get();
    dto.setPrice(OfferEntityTestData.NEGATIVE_PRICE);
    return dto;
  }

  public static OfferDTO getWorkrequestIdInvalid() {
    final OfferDTO dto = get();
    dto.setWorkRequestId(WorkRequestEntityTestData.INVALID_WORK_REQUEST_ID);
    return dto;
  }

  public static OfferDTO getWorkRequestIdNonPositive() {
    final OfferDTO dto = get();
    dto.setWorkRequestId(
        WorkRequestEntityTestData.NON_POSITIVE_WORK_REQUEST_ID
    );
    return dto;
  }

  public static OfferDTO get() {
    final OfferDTO dto = new OfferDTO();
    dto.setId(OfferEntityTestData.ID);
    dto.setPrice(OfferEntityTestData.VALID_PRICE);
    dto.setWorkRequestId(WorkRequestEntityTestData.WORK_REQUEST_ID);
    return dto;
  }

  public static OfferDTO getPriceZero() {
    final OfferDTO dto = get();
    dto.setPrice(OfferEntityTestData.ZERO_PRICE);
    return dto;
  }
}
