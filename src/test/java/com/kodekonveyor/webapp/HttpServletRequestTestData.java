package com.kodekonveyor.webapp;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.WebRequest;

import com.kodekonveyor.authentication.UserEntityTestData;

public class HttpServletRequestTestData {

  public static final String NOT_LOGGED_IN = "not logged in";
  public static final String LOGIN_URL = "/some/url";
  public static final NotLoggedInException NOT_LOGGED_IN_EXCEPTION =
      mock(NotLoggedInException.class);
  public static final String AUTHENTICATED = "authenticated";

  public static final String LOCATION_HEADER_NAME = "Location";

  public static WebRequest getWebRequest() {
    return mock(WebRequest.class);

  }

  public static HttpServletRequest get() {
    final HttpServletRequest response = mock(HttpServletRequest.class);
    doReturn(UserEntityTestData.AUTH0ID).when(response).getRemoteUser();
    return response;
  }

  public static ServletRequest getRemoteUserUnknown() {
    final HttpServletRequest response = mock(HttpServletRequest.class);
    doReturn(UserEntityTestData.BAD_AUTH0ID).when(response).getRemoteUser();
    return response;
  }

}
