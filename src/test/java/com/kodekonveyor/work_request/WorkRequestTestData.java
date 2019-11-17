package com.kodekonveyor.work_request;

import java.util.List;

import com.kodekonveyor.authentication.UserTestData;

public class WorkRequestTestData {
	public final String OWNER_ID = "4242";
	public final String WORK_TYPE = "CLEANING";
	public final Long WORK_REQUEST_ID = (long) 42;
	public final WorkRequestDTO WORK_REQUEST_DTO;
	public final WorkRequestListDTO WORK_REQUEST_LIST_DTO;
	public final String DESCRIPTION = "Clean up the mess";
	public final boolean IS_ACTIVE = true;
	public final WorkRequestEntity WORK_REQUEST_ENTITY;
	public List<WorkRequestEntity> WORK_REQUEST_ENTITY_LIST;
	public final String NULL_OWNERID = "No OwnerId";
	public final UserTestData userTestData;

	public WorkRequestTestData(final UserTestData userTestData) {
		this.userTestData = userTestData;
		WORK_REQUEST_ENTITY = new WorkRequestEntity();
		WORK_REQUEST_ENTITY.setCustomer(userTestData.USER);
		WORK_REQUEST_ENTITY.setWorkType(WORK_TYPE);
		WORK_REQUEST_ENTITY.setId(WORK_REQUEST_ID);
		WORK_REQUEST_DTO = new WorkRequestDTO();
		WORK_REQUEST_DTO.setWorkRequestId(WORK_REQUEST_ID);
		WORK_REQUEST_DTO.setWorkType(WORK_TYPE);
		WORK_REQUEST_LIST_DTO = new WorkRequestListDTO();
		WORK_REQUEST_LIST_DTO.setRequests(List.of(WORK_REQUEST_DTO));
		WORK_REQUEST_ENTITY_LIST = List.of(WORK_REQUEST_ENTITY);
	}

}
