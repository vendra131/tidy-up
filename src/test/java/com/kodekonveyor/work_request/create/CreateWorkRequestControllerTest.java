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

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Data access")
@TestedService("CreateWorkRequestController")
public class CreateWorkRequestControllerTest
    extends CreateWorkRequestControllerTestBase {

  @Override
  @BeforeEach
  void setUp() {
    super.setUp();
    createWorkRequestController
        .call(createWorkRequestTestData.CREATE_WORK_REQUEST);
  }

  @Test
  @DisplayName("The address in the entity is saved correctly")
  public void test4() {
    assertEquals(
        workRequestTestData.addressTestData.ADDRESS_ENTITY,
        workRequestTestData.WORK_REQUEST_ENTITY.getAddress()
    );
  }

  @Test
  @DisplayName(
    "The user in the entity is saved correctly"
  )
  public void test3() {
    assertEquals(
        workRequestTestData.userTestData.USER,
        workRequestTestData.WORK_REQUEST_ENTITY.getCustomer()
    );

  }

  @Test
  @DisplayName(
    "The work type in the entity is saved correctly"
  )
  public void test6() {
    assertEquals(
        workRequestTestData.WORK_TYPE,
        workRequestTestData.WORK_REQUEST_ENTITY.getWorkType()
    );
  }

  @Test
  @DisplayName(
    "The city in the entity is saved correctly"
  )
  public void test7() {
    assertEquals(
        workRequestTestData.addressTestData.ADDRESS_DTO.getCity(),
        workRequestTestData.WORK_REQUEST_ENTITY.getAddress().getCity()
    );
  }

  @Test
  @DisplayName(
    "The country in the entity is saved correctly"
  )
  public void test8() {
    assertEquals(
        workRequestTestData.addressTestData.ADDRESS_DTO.getCountry(),
        workRequestTestData.WORK_REQUEST_ENTITY.getAddress().getCountry()
    );
  }

  @Test
  @DisplayName(
    "The address string in the entity is saved correctly"
  )
  public void test9() {
    assertEquals(
        workRequestTestData.addressTestData.ADDRESS_DTO.getAddress(),
        workRequestTestData.WORK_REQUEST_ENTITY.getAddress().getAddress()
    );
  }

  @Test
  @DisplayName(
    "The description in the entity is saved correctly"
  )
  public void test10() {
    assertEquals(
        workRequestTestData.DESCRIPTION,
        workRequestTestData.WORK_REQUEST_ENTITY.getDescription()
    );
  }

  @Test
  @DisplayName("Work request entity is saved")
  public void test5() {

    verify(workRequestRepository).save(workRequestTestData.WORK_REQUEST_ENTITY);
  }

}
