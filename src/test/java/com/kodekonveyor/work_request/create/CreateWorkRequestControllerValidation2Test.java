package com.kodekonveyor.work_request.create;

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
import com.kodekonveyor.exception.ThrowableTester;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("input validation")
@TestedService("CreateWorkRequestController")

public class CreateWorkRequestControllerValidation2Test
    extends CreateWorkRequestControllerTestBase {

  @Test
  @DisplayName("Country cannot be more or less than 2 letter")
  public void testCreateWorkRequestCountryCodeLenght() {

    ThrowableTester.assertThrows(
        () -> createWorkRequestController
            .call(CreateWorkRequestDTOTestData.getCountryInvalidLength())
    )
        .assertMessageIs(
            WorkRequestValidationUtilTestData.COUNTRY_LENGTH_ERROR_MESSAGE
        );

  }

  @Test
  @DisplayName("Country can contains only alphahets")
  public void testCreateWorkRequestCountryCodeDigit() {

    ThrowableTester.assertThrows(
        () -> createWorkRequestController.call(
            CreateWorkRequestDTOTestData.getCountryInvalidCharacter()
        )
    )
        .assertMessageIs(
            WorkRequestValidationUtilTestData.COUNTRY_CODE_NON_ALPHABETIC_CHARACTER_ERROR_MESSAGE
        );

  }

  @Test
  @DisplayName(
    "When the address length is 121, we get an exception with the message 'Max characters for 'Address can contains only 120 characters"
  )
  public void testCreateWorkRequestAddressLength() {

    ThrowableTester.assertThrows(
        () -> createWorkRequestController
            .call(CreateWorkRequestDTOTestData.getAddressLongerThanMaxLength())
    )
        .assertMessageIs(
            WorkRequestValidationUtilTestData.ADDRESS_LENGTH_EXCEEDED
        );

  }

  @Test
  @DisplayName("Address cannot contain zero characters")
  public void testCreateWorkRequestZeroAddressLength() {

    ThrowableTester.assertThrows(
        () -> createWorkRequestController
            .call(
                CreateWorkRequestDTOTestData.getAddressZeroLength()
            )
    )
        .assertMessageIs(
            WorkRequestValidationUtilTestData.ADDRESS_CANNOT_BE_BLANK
        );

  }

  @Test
  @DisplayName("when Addrss has 120 characters, we do not throw exception")
  public void testCreateWorkRequestMaxAddressLength1() {//NOPMD

    createWorkRequestController
        .call(
            CreateWorkRequestDTOTestData.getAddressMaxLength()
        );

  }

  @Test
  @DisplayName("Customer Id cannot be negative")
  public void testCreateWorkRequestCustomerId1() {
    ThrowableTester
        .assertThrows(
            () -> createWorkRequestController
                .call(
                    CreateWorkRequestDTOTestData.getCustomerIdNegative()
                )
        )
        .assertMessageIs(
            WorkRequestValidationUtilTestData.NEGATIVE_CUSTOMERID_ERROR_MESSAGE
        );
  }

  @Test
  @DisplayName("Customer Id cannot be zero")
  public void testCreateWorkRequestZeroCustomerId() {
    ThrowableTester
        .assertThrows(
            () -> createWorkRequestController
                .call(
                    CreateWorkRequestDTOTestData.getCustomerIdZero()
                )
        )
        .assertMessageIs(
            WorkRequestValidationUtilTestData.ZERO_CUSTOMERID_ERROR_MESSAGE
        );
  }

  @Test
  @DisplayName("Work type cannot contain digits")
  public void testCreateWorkRequestWorkType1() {

    ThrowableTester
        .assertThrows(
            () -> createWorkRequestController
                .call(
                    CreateWorkRequestDTOTestData.getWorkTypeInvalidCharacter()
                )
        )
        .assertMessageIs(
            WorkRequestValidationUtilTestData.DIGIT_SPECIAL_CHARACTER_WORKTYPE_ERROR
        );

  }

}
