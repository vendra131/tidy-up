package com.kodekonveyor.authentication;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class AuthenticatedUserServiceTestBase {
	@InjectMocks
	protected AuthenticatedUserService authenticatedUserService;
	@Mock
	protected UserEntityRepository userEntityRepository;

	protected UserTestData userTestData;

	@BeforeEach
	protected void setUp() {
		userTestData = new UserTestData();
		UserEntityRepositoryStubs.behaviour(userEntityRepository, userTestData);
	}

}
