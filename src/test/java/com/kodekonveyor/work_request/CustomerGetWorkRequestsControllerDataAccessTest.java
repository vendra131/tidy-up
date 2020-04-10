package com.kodekonveyor.work_request;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
@TestedService("CustomerGetWorkRequestsController")

public class CustomerGetWorkRequestsControllerDataAccessTest
    extends CustomerWorkRequestsControllerTestBase {

  @Test
  @DisplayName("We return the right work request list for the owner ID")
  public void testWorkRequestDetails() {
    assertEquals(
        WorkRequestDTOTestData.list(),
        customerGetWorkRequestsController
            .call(WorkRequestEntityTestData.OWNER_ID)
    );
  }

  @Test
  @DisplayName("We return the right work request Id")
  public void testWorkRequestgetId() {
    assertEquals(
        WorkRequestEntityTestData.WORK_REQUEST_ID,
        WorkRequestEntityTestData.get().getId()
    );
  }

  @Test
  @DisplayName("We return the right work type")
  public void testWorkRequestgetWorkType() {
    assertEquals(
        WorkRequestEntityTestData.WORK_TYPE,
        WorkRequestEntityTestData.get().getWorkType()
    );
  }

  @Test
  @DisplayName("We return the right address")
  public void testWorkRequestgetAddress() {
    assertEquals(
        AddressEntityTestData.get(),
        WorkRequestEntityTestData.get().getAddress()
    );
  }

  @Test
  @DisplayName("We return the right description")
  public void testWorkRequestgetDescription() {
    assertEquals(
        WorkRequestEntityTestData.DESCRIPTION,
        WorkRequestEntityTestData.get().getDescription()
    );
  }

  @Test
  @DisplayName("We return the right status")
  public void testWorkRequestgetStatus() {
    assertEquals(
        WorkRequestStatusEnum.POSTED,
        WorkRequestEntityTestData.get().getStatus()
    );
  }

}
