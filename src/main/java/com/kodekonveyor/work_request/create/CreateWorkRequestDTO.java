package com.kodekonveyor.work_request.create;

import com.kodekonveyor.work_request.AddressDTO;

import lombok.Data;

@Data
public class CreateWorkRequestDTO {
	private Long customerId;
	private AddressDTO address;
	private String workType;
	private String description;

}
