package com.kodekonveyor.webapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
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
import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.authentication.UserEntityTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Uses the userEntity to return various data")
@TestedService("RemoteAuthentication")
public class RemoteAuthenticationTest extends RemoteAuthenticationTestBase {

  @DisplayName("getAuthorities returns an empty list")
  @Test
  public void test() {
    assertEquals(new ArrayList<UserEntity>(), auth.getAuthorities());
  }

  @DisplayName("getCredentials returns the auth0 id")
  @Test
  public void test1() {
    assertEquals(UserEntityTestData.AUTH0ID, auth.getCredentials());
  }

  @DisplayName("getDetails returns the user")
  @Test
  public void test2() {
    assertEquals(UserEntityTestData.get(), auth.getDetails());
  }

  @DisplayName("the returned user has the correct id")
  @Test
  public void test21() {
    assertEquals(
        UserEntityTestData.USER_ID, ((UserEntity) auth.getDetails()).getId()
    );
  }

  @DisplayName("getPrincipal returns the login name")
  @Test
  public void test3() {
    assertEquals(UserEntityTestData.LOGIN, auth.getPrincipal());
  }

  @DisplayName("getName returns the login name")
  @Test
  public void test31() {
    assertEquals(UserEntityTestData.LOGIN, auth.getName());
  }

  @DisplayName("isAuthenticated returns true")
  @Test
  public void test4() {
    assertThat(auth.isAuthenticated()).isTrue();
  }

  @DisplayName("use of setAuthenticated throws IllegalArgumentException")
  @Test
  public void test5() {
    Assertions.assertThrows(
        IllegalArgumentException.class, () -> auth.setAuthenticated(true)
    );
  }

}
