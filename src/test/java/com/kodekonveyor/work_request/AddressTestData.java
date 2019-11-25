
package com.kodekonveyor.work_request;

public class AddressTestData {

	public final AddressEntity ADDRESS_ENTITY;
	public final String ADDRESS = "Männimäe, 74626";
	public final AddressDTO ADDRESS_DTO;
	public final String CITY = "Pudisoo";
	public final String COUNTRY = "ee";

	public AddressTestData() {
		ADDRESS_ENTITY = new AddressEntity();
		ADDRESS_ENTITY.setAddress(ADDRESS);
		ADDRESS_ENTITY.setCity(CITY);
		ADDRESS_ENTITY.setCountry(COUNTRY);
		ADDRESS_DTO = new AddressDTO();
		ADDRESS_DTO.setAddress(ADDRESS);
		ADDRESS_DTO.setCity(CITY);
		ADDRESS_DTO.setCountry(COUNTRY);
	}
}
