package com.kodekonveyor.work_request;

public class AddressDTOTestData {

  public final static String ADDRESS_OF_120_LENGTH =
      "123sdfgokwerwttigfgldsgdfgeryytusdfghrethewrwergtweryfdgb45wertwertwehgfdgsdgertgdfgerygjgxgfhghjfyuert456ghfdgu79ukgyte";
  public final static String ADDRESS_OF_121_LENGTH =
      ADDRESS_OF_120_LENGTH + "t";

  public final static String COUNTRY_WITH_INVALID_CHARACTER = "3e";
  public final static String COUNTRY_OF_INVALID_LENGTH = "eefg";
  public final static String CITY_WITH_INVALID_CHARACTER = "Mu3bai";

  public static AddressDTO get() {
    final AddressDTO dto = new AddressDTO();
    dto.setId(Long.parseLong(AddressEntityTestData.ADDRESS_ID));
    dto.setAddress(AddressEntityTestData.ADDRESS);
    dto.setCity(AddressEntityTestData.CITY);
    dto.setCountry(AddressEntityTestData.COUNTRY);
    return dto;
  }

}
