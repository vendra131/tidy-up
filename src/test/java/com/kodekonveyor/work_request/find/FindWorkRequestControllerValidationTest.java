package com.kodekonveyor.work_request.find;

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
import com.kodekonveyor.work_request.AddressDTOTestData;
import com.kodekonveyor.work_request.WorkRequestDTOTestData;
import com.kodekonveyor.work_request.create.WorkRequestValidationUtilTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("input validation")
@TestedService("findWorkRequestController")

public class FindWorkRequestControllerValidationTest
    extends FindWorkRequestControllerTestBase {

  @Test
  @DisplayName(
    "When the work type is null, an exception is thrown."
  )
  public void testWorktypeIsNotNull() {

    ThrowableTester.assertThrows(
        () -> findWorkRequestController.call(
            AddressDTOTestData.get().getCountry(),
            AddressDTOTestData.get().getCity(), null

        )
    )
        .assertMessageIs(
            WorkRequestValidationUtilTestData.NULL_WORKTYPE
        );

  }

  @Test
  @DisplayName(
    "When the country is null, an exception is thrown."
  )
  public void testCountryIsNotNull() {

    ThrowableTester.assertThrows(
        () -> findWorkRequestController.call(
            null, AddressDTOTestData.get().getCity(),
            WorkRequestDTOTestData.get().getWorkType()
        )
    )
        .assertMessageIs(
            WorkRequestValidationUtilTestData.COUNTRY_CANNOT_BE_EMPTY
        );

  }

  @Test
  @DisplayName(
    "When the city is null, an exception is thrown."
  )
  public void testCityIsNotNull() {

    ThrowableTester.assertThrows(
        () -> findWorkRequestController.call(
            AddressDTOTestData.get().getCountry(),
            null, WorkRequestDTOTestData.get().getWorkType()
        )
    )
        .assertMessageIs(
            WorkRequestValidationUtilTestData.CITY_CANNOT_BE_EMPTY
        );

  }

  @Test
  @DisplayName("Country cannot be more or less than 2 letter")
  public void testtCountryCodeLenght() {

    ThrowableTester.assertThrows(
        () -> findWorkRequestController.call(
            AddressDTOTestData.COUNTRY_OF_INVALID_LENGTH,
            AddressDTOTestData.get().getCity(),
            WorkRequestDTOTestData.get().getWorkType()
        )

    )
        .assertMessageIs(
            WorkRequestValidationUtilTestData.COUNTRY_LENGTH_ERROR_MESSAGE
        );

  }

  @Test
  @DisplayName("Country can contain only alphahet")
  public void testCountryCode() {

    ThrowableTester.assertThrows(
        () -> findWorkRequestController.call(
            AddressDTOTestData.COUNTRY_WITH_INVALID_CHARACTER,
            AddressDTOTestData.get().getCity(),
            WorkRequestDTOTestData.get().getWorkType()
        )

    )
        .assertMessageIs(
            WorkRequestValidationUtilTestData.COUNTRY_CODE_NON_ALPHABETIC_CHARACTER_ERROR_MESSAGE
        );
  }

  @Test
  @DisplayName("City can contain only alphabet")
  public void testCity() {

    ThrowableTester.assertThrows(
        () -> findWorkRequestController.call(
            AddressDTOTestData.get().getCountry(),
            AddressDTOTestData.CITY_WITH_INVALID_CHARACTER,
            WorkRequestDTOTestData.get().getWorkType()
        )

    )
        .assertMessageIs(
            WorkRequestValidationUtilTestData.CITY_CODE_NON_ALPHABETIC_CHARACTER_ERROR_MESSAGE
        );
  }

}
