package com.kodekonveyor.authentication;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.kodekonveyor.webapp.NotLoggedInException;

public class AuthenticatedUserService {

	final static private Pattern AUTH0_ID_EXTRACTION_PATTERN = Pattern.compile("github\\|(.*?)@.*");

	@Autowired
	private UserEntityRepository userEntityRepository;

	public UserEntity call() {
		final String auth0id = getAuth0idForUser();
		checkCredential(auth0id);
		final List<UserEntity> userList = userEntityRepository.findByAuth0id(auth0id);
		if (userList.isEmpty())
			return createNewUserWithCredential(auth0id);
		return userList.get(0);
	}

	private String getAuth0idForUser() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		checkAuthentication(authentication);
		return (String) authentication.getCredentials();
	}

	private void checkCredential(final String auth0id) {
		if (null == auth0id)
			throw new NotLoggedInException(AuthenticationConstants.NO_CREDENTIAL);
	}

	private void checkAuthentication(final Authentication authentication) {
		if (null == authentication)
			throw new NotLoggedInException(AuthenticationConstants.NO_AUTHENTICATION);
	}

	private UserEntity createNewUserWithCredential(final String auth0id) {
		final UserEntity newUser = new UserEntity();
		newUser.setAuth0id(auth0id);
		newUser.setLogin(convertAuth0IdToId(auth0id));
		userEntityRepository.save(newUser);
		return newUser;
	}

	private String convertAuth0IdToId(final String auth0id) {
		final Matcher matcher = AUTH0_ID_EXTRACTION_PATTERN.matcher(auth0id);
		matcher.find();
		return matcher.group(1);
	}

}
