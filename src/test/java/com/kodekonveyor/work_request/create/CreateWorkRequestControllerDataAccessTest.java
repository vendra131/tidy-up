package com.kodekonveyor.work_request.create;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
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
import com.kodekonveyor.authentication.UserEntityTestData;
import com.kodekonveyor.work_request.AddressEntityTestData;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Data access")
@TestedService("CreateWorkRequestController")
public class CreateWorkRequestControllerDataAccessTest
    extends CreateWorkRequestControllerTestBase {

  @Override
  @BeforeEach
  void setUp() {
    super.setUp();
    createWorkRequestController
        .call(CreateWorkRequestDTOTestData.get());
  }

  @Test
  @DisplayName("Work request entity is saved")
  public void test5() {

    verify(workRequestRepository).save(WorkRequestEntityTestData.get());
  }

  @Test
  @DisplayName("The address in the entity is saved correctly")
  public void test4() {
    assertEquals(
        AddressEntityTestData.get(),
        WorkRequestEntityTestData.get().getAddress()
    );
  }

  @Test
  @DisplayName(
    "The user in the entity is saved correctly"
  )
  public void test3() {
    assertEquals(
        UserEntityTestData.get(),
        WorkRequestEntityTestData.get().getCustomer()
    );

  }

  @Test
  @DisplayName(
    "The work type in the entity is saved correctly"
  )
  public void test6() {
    assertEquals(
        WorkRequestEntityTestData.WORK_TYPE,
        WorkRequestEntityTestData.get().getWorkType()
    );
  }

  @Test
  @DisplayName(
    "The city in the entity is saved correctly"
  )
  public void test7() {
    assertEquals(
        AddressEntityTestData.CITY,
        WorkRequestEntityTestData.get().getAddress().getCity()
    );
  }

  @Test
  @DisplayName(
    "The country in the entity is saved correctly"
  )
  public void test8() {
    assertEquals(
        AddressEntityTestData.COUNTRY,
        WorkRequestEntityTestData.get().getAddress().getCountry()
    );
  }

  @Test
  @DisplayName(
    "The address string in the entity is saved correctly"
  )
  public void test9() {
    assertEquals(
        AddressEntityTestData.ADDRESS,
        WorkRequestEntityTestData.get().getAddress().getAddress()
    );
  }

  @Test
  @DisplayName(
    "The description in the entity is saved correctly"
  )
  public void test10() {
    assertEquals(
        WorkRequestEntityTestData.DESCRIPTION,
        WorkRequestEntityTestData.get().getDescription()
    );
  }

  @Test
  @DisplayName(
    "The provider in the entity is saved correctly"
  )
  public void test11() {
    assertEquals(
        UserEntityTestData.get(),
        WorkRequestEntityTestData.get().getProvider()
    );

  }
}
