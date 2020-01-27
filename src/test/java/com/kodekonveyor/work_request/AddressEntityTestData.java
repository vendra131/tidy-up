package com.kodekonveyor.work_request;

public class AddressEntityTestData {

  public final static String ADDRESS_ID = "4242";
  public final static String ADDRESS = "Männimäe, 74626";

  public final static String CITY = "Pudisoo";
  public final static String COUNTRY = "ee";

  public static AddressEntity get() {
    final AddressEntity entity = new AddressEntity();
    entity.setId(Long.parseLong(ADDRESS_ID));
    entity.setAddress(ADDRESS);
    entity.setCity(CITY);
    entity.setCountry(COUNTRY);
    return entity;
  }
}
