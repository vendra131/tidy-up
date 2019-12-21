package com.kodekonveyor.webapp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Handles NotLoggedInException")
@TestedService("RestResponseEntityExceptionHandler")

public class RestResponseEntityExceptionHandlerTest
    extends RestResponseEntityExceptionHandlerTestBase {

  @DisplayName("logs 'not logged in'")
  @Test
  public void test() {
    verify(loggerService).call(HttpServletRequestTestData.NOT_LOGGED_IN);
  }

  @DisplayName(
    "returns a header with the location set based on configuration parameter"
  )
  @Test
  public void test2() {
    assertEquals(
        List.of(HttpServletRequestTestData.LOGIN_URL), response.getHeaders().get(HttpServletRequestTestData.LOCATION_HEADER_NAME)
    );
  }

}
