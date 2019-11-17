package com.kodekonveyor.work_request;

import lombok.Data;

@Data
public class WorkRequestDTO {

	private Long workRequestId;
	private String workType;
	private AddressDTO address;
	private String Description;
}
