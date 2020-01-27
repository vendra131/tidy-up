package com.kodekonveyor.work_request.offer;

import lombok.Data;

@Data
public class OfferDTO {

  private long id;
  private long price;
  private long workRequestId;
}
