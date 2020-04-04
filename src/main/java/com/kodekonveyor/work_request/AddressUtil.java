package com.kodekonveyor.work_request;

public class AddressUtil {

  public static AddressEntity
      createAddressEntityFromDTO(final AddressDTO address, final Long customerId) {
    final AddressEntity addressEntity = new AddressEntity();
    addressEntity.setId(customerId);
    addressEntity.setAddress(address.getAddress());
    addressEntity.setCity(address.getCity());
    addressEntity.setCountry(address.getCountry());
    return addressEntity;
  }
}
