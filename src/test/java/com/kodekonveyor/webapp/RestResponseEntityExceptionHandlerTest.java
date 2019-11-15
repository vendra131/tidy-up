package com.kodekonveyor.webapp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.List;

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
import org.springframework.http.ResponseEntity;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.authentication.UserTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Handles NotLoggedInException")
@TestedService("RestResponseEntityExceptionHandler")

public class RestResponseEntityExceptionHandlerTest {

	@InjectMocks
	private RestResponseEntityExceptionHandler restResponseEntityExceptionHandler;

	@Mock
	private LoggerService loggerService;

	private WebappTestData webAppTestData;

	private ResponseEntity<Object> response;

	@BeforeEach
	public void setUp() {
		final UserTestData userTestData = new UserTestData();
		webAppTestData = new WebappTestData(userTestData);
		restResponseEntityExceptionHandler.loginUrl = webAppTestData.LOGIN_URL;
		response = restResponseEntityExceptionHandler.handleNotLoggedInException(webAppTestData.NOT_LOGGED_IN_EXCEPTION,
				webAppTestData.WEB_REQUEST);
	}

	@DisplayName("logs 'not logged in'")
	@Test
	public void test() {
		verify(loggerService).call(webAppTestData.NOT_LOGGED_IN);
	}

	@DisplayName("returns a header with the location set based on configuration parameter")
	@Test
	public void test2() {
		assertEquals(List.of(webAppTestData.LOGIN_URL), response.getHeaders().get("Location"));
	}

}
