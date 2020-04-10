package com.kodekonveyor.work_request.create;

import static org.junit.Assert.assertEquals;

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
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Data access")
@TestedService("CreateWorkRequestController")
public class CreateWorkRequestControllerStatusesTest
    extends CreateWorkRequestControllerTestBase {

  @Override
  @BeforeEach
  void setUp() {
    super.setUp();
    createWorkRequestController
        .call(CreateWorkRequestDTOTestData.get());
  }

  @Test
  @DisplayName(
    "The status in the entity is saved correctly"
  )
  public void test11() {
    assertEquals(
        WorkRequestEntityTestData.STATUS,
        WorkRequestEntityTestData.get().getStatus()
    );
  }

}
