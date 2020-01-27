package com.kodekonveyor.authentication;

import java.util.List;

public class UserEntityTestData {

  public static final String AUTH0ID =
      "github|424242@kode-konveyor.eu.auth0.com/";
  public static final String BAD_AUTH0ID =
      "github|424241@kode-konveyor.eu.auth0.com/";
  public static final String LOGIN = "424242";
  public static final String BAD_LOGIN = "424241";
  public static final long USER_ID = 4242;
  public static final long BAD_USER_ID = 4241;
  public static final String NO_WORKREQUESTS_ID = "4243";
  public static final String OWNER_ID = "4242";
  public static final String NEGATIVE_OWNERID_ID = "-4536";
  public static final Long NO_WORKREQUESTS_ID_ASLONG =
      Long.parseLong(NO_WORKREQUESTS_ID);

  public static List<UserEntity> list() {
    return List.of(get());
  }

  public static UserEntity get() {
    final UserEntity userEntity = new UserEntity();
    userEntity.setAuth0id(AUTH0ID);
    userEntity.setLogin(LOGIN);
    userEntity.setId(USER_ID);
    return userEntity;
  }

  public static UserEntity getIdForBadUser() {
    final UserEntity userEntity = getIdForBadUserBeforeSave();
    userEntity.setId(BAD_USER_ID);
    return userEntity;
  }

  public static UserEntity getIdForNOWorkRequests() {
    final UserEntity userEntity = get();
    userEntity.setId(NO_WORKREQUESTS_ID_ASLONG);
    return userEntity;

  }

  public static UserEntity getIdForBadUserBeforeSave() {
    final UserEntity userEntity = new UserEntity();
    userEntity.setAuth0id(BAD_AUTH0ID);
    userEntity.setLogin(BAD_LOGIN);
    return userEntity;
  }

}
