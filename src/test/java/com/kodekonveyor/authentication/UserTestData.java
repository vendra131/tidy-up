package com.kodekonveyor.authentication;

import java.util.ArrayList;
import java.util.List;

public class UserTestData { // NOPMD

  public final String AUTH0ID = "github|424242@kode-konveyor.eu.auth0.com/";
  public final String BAD_AUTH0ID = "github|424241@kode-konveyor.eu.auth0.com/";
  public final String LOGIN = "424242";
  public final String BAD_LOGIN = "424241";
  public final UserEntity USER = createUSER();
  public final UserEntity BAD_USER_BEFORE_SAVE = createBAD_USER_BEFORE_SAVE();
  public final UserEntity BAD_USER = createBAD_USER();
  public final List<UserEntity> USER_LIST = createUSER_LIST();
  public final long USER_ID = 4242;
  public final long BAD_USER_ID = 4241;
  public final List<Object> EMPTY_LIST = new ArrayList<>();
  public final String NO_AUTHENTICATION = "No Authentication";
  public final String NO_CREDENTIAL = "No Credential";
  public final String NULL_OWNERID = "No OwnerID";
  public final String INVALID_OWNERID = "Invalid OwnerId";
  public final String NO_WORKREQUESTS = "No Work Request";
  public final String NO_WORKREQUESTS_ID = "4243";
  public final String OWNER_ID = "4242";
  public final String NEGATIVE_OWNERID_ID = "-4536";
  public final String INVALID_OWNERID_ID = "4243";
  public final long USER_ID_CREATE_REQUEST = 4242;
  public final Long NO_WORKREQUESTS_ID_ASLONG =
      Long.parseLong(NO_WORKREQUESTS_ID);
  public final String WORKREQUESTS_ID = "4243";
  public final UserEntity USER_WORKREQUESTS = createREQUEST_USER();
  public final UserEntity USER_NO_WORKREQUESTS = createNO_REQUEST_USER();

  private List<UserEntity> createUSER_LIST() {
    return List.of(USER);
  }

  private UserEntity createUSER() {
    final UserEntity userEntity = new UserEntity();
    userEntity.setAuth0id(AUTH0ID);
    userEntity.setLogin(LOGIN);
    userEntity.setId(USER_ID);
    return userEntity;
  }

  private UserEntity createBAD_USER() {
    final UserEntity userEntity = createBAD_USER_BEFORE_SAVE();
    userEntity.setId(BAD_USER_ID);
    return userEntity;
  }

  private UserEntity createNO_REQUEST_USER() {
    final UserEntity userEntity = createUSER();
    userEntity.setId(NO_WORKREQUESTS_ID_ASLONG);
    return userEntity;

  }

  private UserEntity createBAD_USER_BEFORE_SAVE() {
    final UserEntity userEntity = new UserEntity();
    userEntity.setAuth0id(BAD_AUTH0ID);
    userEntity.setLogin(BAD_LOGIN);
    return userEntity;
  }

  private UserEntity createREQUEST_USER() {
    final UserEntity userEntity = createUSER();
    userEntity.setId(Long.parseLong(WORKREQUESTS_ID));
    return userEntity;
  }
}
