package com.kodekonveyor.work_request.find;

import static org.junit.Assert.assertEquals;

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
import com.kodekonveyor.work_request.AddressEntityTestData;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Data access")
@TestedService("FindWorkRequestController")
public class FindWorkRequestControllerDataAccessTest
    extends FindWorkRequestControllerTestBase {

  @Test
  @DisplayName("Description of work request is correctly filled in")
  public void test1() {
    assertEquals(
        WorkRequestEntityTestData.DESCRIPTION,
        findWorkRequestController
            .call(
                AddressEntityTestData.COUNTRY, AddressEntityTestData.CITY,
                WorkRequestEntityTestData.WORK_TYPE
            )
            .getRequests().get(0).getDescription()
    );
  }

  @Test
  @DisplayName("ID of work request is correctly filled in")
  public void test2() {
    assertEquals(
        WorkRequestEntityTestData.WORK_REQUEST_ID,
        findWorkRequestController
            .call(
                AddressEntityTestData.COUNTRY, AddressEntityTestData.CITY,
                WorkRequestEntityTestData.WORK_TYPE
            )
            .getRequests().get(0).getWorkRequestId()
    );
  }

  @Test
  @DisplayName("Worktype of work request is correctly filled in")
  public void test3() {
    assertEquals(
        WorkRequestEntityTestData.WORK_TYPE,
        findWorkRequestController
            .call(
                AddressEntityTestData.COUNTRY, AddressEntityTestData.CITY,
                WorkRequestEntityTestData.WORK_TYPE
            )
            .getRequests().get(0).getWorkType()
    );
  }
}
