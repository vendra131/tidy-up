package com.kodekonveyor.authentication;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class UserEntityRepositoryStubs {

  public static void behaviour(
      final UserEntityRepository userRepository
  ) {
    doReturn(UserEntityTestData.list()).when(userRepository)
        .findByAuth0id(UserEntityTestData.AUTH0ID);
    doReturn(new ArrayList<UserEntity>()).when(userRepository)
        .findByAuth0id(UserEntityTestData.BAD_AUTH0ID);
    doReturn(Optional.of(UserEntityTestData.get())).when(userRepository)
        .findById(UserEntityTestData.USER_ID);
    doReturn(Optional.of(UserEntityTestData.getForUnauthicatedCalls())).when(userRepository)
            .findById(UserEntityTestData.USER_ID_FOR_UNAUTHENTICATED_CALL);
    doReturn(Optional.of(UserEntityTestData.getIdForNOWorkRequests()))
        .when(userRepository)
        .findById(UserEntityTestData.NO_WORKREQUESTS_ID_ASLONG);

    final Answer<UserEntity> answer = new Answer<>() {

      @Override
      public UserEntity answer(final InvocationOnMock invocation) {
        final Object[] args = invocation.getArguments();
        final UserEntity user = (UserEntity) args[0];
        user.setId(UserEntityTestData.BAD_USER_ID);
        return null;
      }
    };
    when(userRepository.save(UserEntityTestData.getIdForBadUserBeforeSave()))
        .then(answer);

  }
}
