
package com.kodekonveyor.authentication;

import static org.mockito.Mockito.doReturn;

class AuthenticatedUserStubs {

	public void behaviour(final AuthenticatedUserService authenticatedUserService, final UserTestData userTestData) {

		doReturn(userTestData.USER).when(authenticatedUserService).call();

	}
}
