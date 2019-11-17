package com.kodekonveyor.work_request.open;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.authentication.UserTestData;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkRequestRepositoryStub;
import com.kodekonveyor.work_request.WorkRequestTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Data access")
@TestedService("OpenWorkRequestController")
public class OpenWorkRequestControllerTest {
	@InjectMocks
	private OpenWorkRequestController openWorkRequestController;
	@Mock
	private WorkRequestRepository workRequestRepository;
	private WorkRequestTestData workRequestTestData;

	@BeforeEach
	public void setUp() {
		final UserTestData userTestData = new UserTestData();
		workRequestTestData = new WorkRequestTestData(userTestData);
		WorkRequestRepositoryStub.behaviour(workRequestRepository, workRequestTestData);
	}

	@Test
	@DisplayName("Controller returns right DTO based on requestId")
	public void test() {

		assertEquals(workRequestTestData.WORK_REQUEST_DTO,
				openWorkRequestController.call(workRequestTestData.WORK_REQUEST_ID));

	}

}
