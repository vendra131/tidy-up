package com.kodekonveyor.work_request;

import java.util.List;

import com.kodekonveyor.authentication.UserTestData;
import com.kodekonveyor.work_request.create.CreateWorkRequestDTO;

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
	public final AddressTestData addressTestData;
	public final CreateWorkRequestDTO CREATE_WORK_REQUEST;

	public WorkRequestTestData(final UserTestData userTestData, final AddressTestData addressTestData) {
		this.userTestData = userTestData;
		this.addressTestData = addressTestData;
		WORK_REQUEST_ENTITY = createWORK_REQUEST_ENTITY();
		WORK_REQUEST_DTO = createWORK_REQUEST_DTO();
		WORK_REQUEST_LIST_DTO = new WorkRequestListDTO();
		WORK_REQUEST_LIST_DTO.setRequests(List.of(WORK_REQUEST_DTO));
		WORK_REQUEST_ENTITY_LIST = List.of(WORK_REQUEST_ENTITY);
		CREATE_WORK_REQUEST = createCREATE_WORK_REQUEST();
	}

	private CreateWorkRequestDTO createCREATE_WORK_REQUEST() {
		final CreateWorkRequestDTO createWorkRequest = new CreateWorkRequestDTO();
		createWorkRequest.setCustomerId(WORK_REQUEST_ID);
		createWorkRequest.setWorkType(WORK_TYPE);
		createWorkRequest.setDescription(DESCRIPTION);
		createWorkRequest.setAddress(addressTestData.ADDRESS_DTO);
		return createWorkRequest;
	}

	private WorkRequestEntity createWORK_REQUEST_ENTITY() {
		final WorkRequestEntity workRequestEntity = new WorkRequestEntity();
		workRequestEntity.setCustomer(userTestData.USER);
		workRequestEntity.setWorkType(WORK_TYPE);
		workRequestEntity.setId(WORK_REQUEST_ID);
		workRequestEntity.setDescription(DESCRIPTION);
		workRequestEntity.setAddress(addressTestData.ADDRESS_ENTITY);
		return workRequestEntity;
	}

	private WorkRequestDTO createWORK_REQUEST_DTO() {
		final WorkRequestDTO workRequestDTO = new WorkRequestDTO();
		workRequestDTO.setWorkRequestId(WORK_REQUEST_ID);
		workRequestDTO.setWorkType(WORK_TYPE);
		return workRequestDTO;
	}
}
