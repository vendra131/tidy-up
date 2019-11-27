package com.kodekonveyor.work_request;

import lombok.Data;

@Data
public class AddressDTO {

  private long id;
  private String address;
  private String city;
  private String country;
}
