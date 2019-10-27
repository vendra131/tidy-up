package com.kodekonveyor.webapp;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.kodekonveyor.authentication.UserEntity;

import lombok.Getter;

@Getter
public class WebappTestData {

	public final String AUTH0ID = "github|424242@kode-konveyor.eu.auth0.com/";
	public final String BAD_AUTH0ID = "github|424241@kode-konveyor.eu.auth0.com/";
	public final String LOGIN = "424242";
	public final UserEntity USER = getUSER();
	public final Object USER_LIST = getUSER_LIST();
	public final long USER_ID = 4242;
	public final List<Object> EMPTY_LIST = new ArrayList<>();
	public final HttpServletRequest REQUEST = getREQUEST();
	public final ServletRequest REQUEST_WITH_UNKNOWN_USER = getREQUEST_WITH_UNKNOWN_USER();
	public final String NOT_LOGGED_IN = "not logged in";
	public final String LOGIN_URL = "/some/url";

	public HttpServletRequest getREQUEST() {
		final HttpServletRequest response = mock(HttpServletRequest.class);
		doReturn(AUTH0ID).when(response).getRemoteUser();
		return response;
	}

	public ServletRequest getREQUEST_WITH_UNKNOWN_USER() {
		final HttpServletRequest response = mock(HttpServletRequest.class);
		doReturn(BAD_AUTH0ID).when(response).getRemoteUser();
		return response;
	}

	public Object getUSER_LIST() {
		return List.of(USER);
	}

	public UserEntity getUSER() {
		final UserEntity userEntity = new UserEntity();
		userEntity.setAuth0id(AUTH0ID);
		userEntity.setLogin(LOGIN);
		userEntity.setId(USER_ID);
		return userEntity;
	}

}
