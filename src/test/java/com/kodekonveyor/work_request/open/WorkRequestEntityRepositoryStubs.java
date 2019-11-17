package com.kodekonveyor.work_request.open;

import static org.mockito.Mockito.doReturn;

import com.kodekonveyor.work_request.WorkRequestTestData;

public class WorkRequestEntityRepositoryStubs {
	public static void behaviour(final WorkRequestRepository workRequestRepository,
			final WorkRequestTestData workRequestTestData) {
		doReturn(workRequestTestData.WORK_REQUEST_ENTITY).when(workRequestRepository)
				.findByWorkRequestId(workRequestTestData.WORK_REQUEST_ID);
	}
}
