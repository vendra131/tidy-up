
package com.kodekonveyor.work_request;

public class AddressTestData { // NOPMD

  public final AddressEntity ADDRESS_ENTITY;

  public final AddressDTO ADDRESS_DTO;
  public final AddressDTO ADDRESS_DTO_NULL_STRING;
  public final AddressDTO ADDRESS_DTO_NULL_COUNRTY;
  public final AddressDTO ADDRESS_DTO_NULL_CITY;
  public final AddressDTO ADDRESS_DTO_COUNTRY_LENGTH;
  public final AddressDTO ADDRESS_DTO_COUNRTY_ALPHABET;
  public final AddressDTO ADDRESS_DTO_ADDRESS_LENGTH;

  public final String COUNTRY_LENGHT = "eefg";
  public final String COUNTRY_ALPHABET = "3e";
  public final String ADDRESS_LENGTH =
      "123sdfgokwerwttigfgldsgdfgeryytusdfghrethewrwergtweryfdgb45wertwertwehgfdgsdgertgdfgerygjgxgfhghjfyuert456ghfdgu79ukgytut";
  public final String ADDRESS_ID = "4242";
  public final String ADDRESS = "Männimäe, 74626";

  public final String CITY = "Pudisoo";
  public final String COUNTRY = "ee";

  public final String NULL_CITY = "City cannot be empty";
  public final String NULL_COUNTRY = "Country cannot be empty";
  public String COUNTRY_LENGTH_ERROR_MESSAGE =
      "Country cannot be more or less than 2 letter";
  public String COUNTRY_CODE_ALPHABET = "Country can contains only alphahets";
  public final String ADDRESS_LENGTHEXCEED =
      "Address can contains only 120 characters";

  public AddressDTO ZERO_ADDRESS_DTO;

  public String ADDRESS_ZERO_LENGTH = "Address cannot be blank";

  //  public String ADDRESS_MAX_LENGTH = "Address reached max limit";

  public AddressDTO MAX_ADDRESS_DTO;

  private final String MAX_ADDRESS_LENGTH =
      "123sdfgokwerwttigfgldsgdfgeryytusdfghrethewrwergtweryfdgb45wertwertwehgfdgsdgertgdfgerygjgxgfhghjfyuert456ghfdgu79ukgyte";

  public AddressTestData() {

    ADDRESS_ENTITY = createADDRESS_ENTITY();

    ADDRESS_DTO = createADDRESS_DTO();
    ADDRESS_DTO_NULL_STRING = createADDRESS_DTO_NULL_STRING();
    ADDRESS_DTO_NULL_COUNRTY = createADDRESS_DTO_NULL_COUNRTY();
    ADDRESS_DTO_NULL_CITY = createADDRESS_DTO_NULL_CITY();
    ADDRESS_DTO_COUNTRY_LENGTH = createADDRESS_DTO_COUNTRY_LENGTH();
    ADDRESS_DTO_COUNRTY_ALPHABET = createADDRESS_DTO_COUNRTY_ALPHABET();
    ADDRESS_DTO_ADDRESS_LENGTH = createADDRESS_DTO_ADDRESS_LENGTH();
    ZERO_ADDRESS_DTO = createZERO_ADDRESS_DTO();
    MAX_ADDRESS_DTO = createMAX_ADDRESS_DTO9();

  }

  private AddressDTO createMAX_ADDRESS_DTO9() {
    final AddressDTO dto = createADDRESS_DTO();
    dto.setAddress(MAX_ADDRESS_LENGTH);
    return dto;
  }

  private AddressDTO createZERO_ADDRESS_DTO() {
    final AddressDTO dto = createADDRESS_DTO();
    dto.setAddress("");
    return dto;
  }

  private AddressDTO createADDRESS_DTO_ADDRESS_LENGTH() {
    final AddressDTO dto = createADDRESS_DTO();
    dto.setAddress(ADDRESS_LENGTH);
    return dto;
  }

  private AddressDTO createADDRESS_DTO_COUNRTY_ALPHABET() {
    final AddressDTO dto = createADDRESS_DTO();
    dto.setCountry(COUNTRY_ALPHABET);
    return dto;
  }

  private AddressDTO createADDRESS_DTO_COUNTRY_LENGTH() {
    final AddressDTO dto = createADDRESS_DTO();
    dto.setCountry(COUNTRY_LENGHT);

    return dto;
  }

  private AddressDTO createADDRESS_DTO_NULL_CITY() {
    final AddressDTO dto = createADDRESS_DTO();
    dto.setCity(null);
    return dto;
  }

  private AddressDTO createADDRESS_DTO_NULL_COUNRTY() {
    final AddressDTO dto = createADDRESS_DTO();
    dto.setCountry(null);
    return dto;
  }

  private AddressDTO createADDRESS_DTO_NULL_STRING() {
    final AddressDTO dto = createADDRESS_DTO();
    dto.setAddress(null);
    return dto;
  }

  private AddressDTO createADDRESS_DTO() {
    final AddressDTO dto = new AddressDTO();
    dto.setId(Long.parseLong(ADDRESS_ID));
    dto.setAddress(ADDRESS);
    dto.setCity(CITY);
    dto.setCountry(COUNTRY);
    return dto;
  }

  private AddressEntity createADDRESS_ENTITY() {
    final AddressEntity entity = new AddressEntity();
    entity.setId(Long.parseLong(ADDRESS_ID));
    entity.setAddress(ADDRESS);
    entity.setCity(CITY);
    entity.setCountry(COUNTRY);
    return entity;
  }

}
