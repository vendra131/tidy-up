package com.kodekonveyor.work_request.revoke;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@TestedBehaviour("Data access")
@TestedService("RevokeWorkRequestController")
public class RevokeWorkRequestControllerDataAccessTest
    extends RevokeWorkRequestControllerTestBase {

  @Test
  @DisplayName("Delete the entity successfully")
  public void testDeleteWorkRequest() {
    revokeWorkRequestController.call(WorkRequestEntityTestData.WORK_REQUEST_ID);
    Mockito.verify(workRequestRepository)
        .delete(WorkRequestEntityTestData.get());
  }

}
