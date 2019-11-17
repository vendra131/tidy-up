package com.kodekonveyor.work_request;

import com.kodekonveyor.work_request.open.WorkRequestEntity;

public class WorkRequestTestData {

	public final long WORK_REQUEST_ID = 42;
	public final String WORK_TYPE = "CLEANING";
	public final WorkRequestDTO WORK_REQUEST_DTO = createWORK_REQUEST_DTO();
	public WorkRequestEntity WORK_REQUEST_ENTITY = createWORK_REQUEST_ENTITY();

	private WorkRequestDTO createWORK_REQUEST_DTO() {

		final WorkRequestDTO workRequestDto = new WorkRequestDTO();
		workRequestDto.setWorkType(WORK_TYPE);
		return workRequestDto;
	}

	private WorkRequestEntity createWORK_REQUEST_ENTITY() {

		final WorkRequestEntity workRequestEntity = new WorkRequestEntity();
		workRequestEntity.setWorkType(WORK_TYPE);
		return workRequestEntity;
	}
}