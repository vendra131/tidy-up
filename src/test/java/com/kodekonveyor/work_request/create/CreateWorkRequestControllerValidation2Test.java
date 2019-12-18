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
            .call(createWorkRequestTestData.CREATE_WORK_REQUEST_COUNTRY_LENGTH)
    )
        .assertMessageIs(addressTestData.COUNTRY_LENGTH_ERROR_MESSAGE);

  }

  @Test
  @DisplayName("Country can contains only alphahets")
  public void testCreateWorkRequestCountryCodeDigit() {

    ThrowableTester.assertThrows(
        () -> createWorkRequestController.call(
            createWorkRequestTestData.CREATE_WORK_REQUEST_COUNTRY_ALPHABET
        )
    )
        .assertMessageIs(addressTestData.COUNTRY_CODE_ALPHABET);

  }

  @Test
  @DisplayName(
    "When the address length is 121, we get an exception with the message 'Max characters for 'Address can contains only 120 characters"
  )
  public void testCreateWorkRequestAddressLength() {

    ThrowableTester.assertThrows(
        () -> createWorkRequestController
            .call(createWorkRequestTestData.CREATE_WORK_REQUEST_ADDRESS_LENGTH)
    )
        .assertMessageIs(addressTestData.ADDRESS_LENGTHEXCEED);

  }

  @Test
  @DisplayName("Address cannot contain zero characters")
  public void testCreateWorkRequestZeroAddressLength() {

    ThrowableTester.assertThrows(
        () -> createWorkRequestController
            .call(
                createWorkRequestTestData.CREATE_WORK_REQUEST_ZERO_ADDRESS_LENGTH
            )
    )
        .assertMessageIs(addressTestData.ADDRESS_ZERO_LENGTH);

  }

  @Test
  @DisplayName("when Addrss has 120 characters, we do not throw exception")
  public void testCreateWorkRequestMaxAddressLength1() { //NOPMD

    createWorkRequestController
        .call(
            createWorkRequestTestData.CREATE_WORK_REQUEST_MAX_ADDRESS_LENGTH
        );

  }

  @Test
  @DisplayName("Customer Id cannot be negative")
  public void testCreateWorkRequestCustomerId1() {
    ThrowableTester
        .assertThrows(
            () -> createWorkRequestController
                .call(
                    createWorkRequestTestData.CREATE_WORK_REQUEST_NEGATIVE_CUSTOMERID
                )
        )
        .assertMessageIs(
            createWorkRequestTestData.NEGATIVE_CUSTOMERID_ERROR_MESSAGE
        );
  }

  @Test
  @DisplayName("Customer Id cannot be zero")
  public void testCreateWorkRequestZeroCustomerId() {
    ThrowableTester
        .assertThrows(
            () -> createWorkRequestController
                .call(
                    createWorkRequestTestData.CREATE_WORK_REQUEST_ZERO_CUSTOMERID
                )
        )
        .assertMessageIs(
            createWorkRequestTestData.ZERO_CUSTOMERID_ERROR_MESSAGE
        );
  }

  @Test
  @DisplayName("Work type cannot contain digits")
  public void testCreateWorkRequestWorkType1() {

    ThrowableTester
        .assertThrows(
            () -> createWorkRequestController
                .call(
                    createWorkRequestTestData.CREATE_WORK_REQUEST_DIGIT_SPECIAL_CHARACTER_WORKTYPE
                )
        )
        .assertMessageIs(
            createWorkRequestTestData.DIGIT_SPECIAL_CHARACTER_WORKTYPE_ERROR
        );

  }

}
