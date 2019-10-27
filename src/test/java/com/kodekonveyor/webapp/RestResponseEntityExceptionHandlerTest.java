package com.kodekonveyor.webapp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
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
import org.springframework.web.context.request.WebRequest;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
public class RestResponseEntityExceptionHandlerTest {

	@InjectMocks
	private RestResponseEntityExceptionHandler restResponseEntityExceptionHandler;

	@Mock
	private LoggerService loggerService;

	private WebappTestData testData;

	private ResponseEntity<Object> response;

	@BeforeEach
	public void setUp() {
		testData = new WebappTestData();
		restResponseEntityExceptionHandler.loginUrl = testData.LOGIN_URL;
		final NotLoggedInException exception = mock(NotLoggedInException.class);
		final WebRequest request = mock(WebRequest.class);
		response = restResponseEntityExceptionHandler.handleNotLoggedInException(exception, request);
	}

	@DisplayName("logs 'not logged in'")
	@Test
	public void test() {
		verify(loggerService).call(testData.NOT_LOGGED_IN);
	}

	@DisplayName("returns a header with the location set based on configuration parameter")
	@Test
	public void test2() {
		assertEquals(List.of(testData.LOGIN_URL), response.getHeaders().get("Location"));
	}

}
