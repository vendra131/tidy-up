package com.kodekonveyor.work_request.offer;

import com.kodekonveyor.work_request.WorkRequestEntityTestData;

public class OfferDTOTestData {

  public final static long VALID_PRICE = 1;
  public final static long ZERO_PRICE = 0;
  public final static long NEGATIVE_PRICE = -1;

  public static OfferDTO getPriceNegative() {
    final OfferDTO dto = get();
    dto.setPrice(NEGATIVE_PRICE);
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
    dto.setId(1);
    dto.setPrice(VALID_PRICE);
    dto.setWorkRequestId(WorkRequestEntityTestData.WORK_REQUEST_ID);
    return dto;
  }

  public static OfferDTO getPriceZero() {
    final OfferDTO dto = get();
    dto.setPrice(ZERO_PRICE);
    return dto;
  }
}
