package com.kodekonveyor.work_request.offer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
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
import com.kodekonveyor.work_request.WorkRequestDTO;
import com.kodekonveyor.work_request.WorkRequestDTOTestData;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("statuses")
@TestedService("AcceptOfferController")
public class AcceptOfferControllerStatusesTest
    extends AcceptOfferControllerTestBase {

  private WorkRequestDTO workRequestDTOTestData;
  private WorkRequestDTO workRequestDTO;

  @BeforeEach
  public void setUpTest() {
    workRequestDTOTestData =
        WorkRequestDTOTestData.getStatusAgreedAndProvider();
    workRequestDTO = acceptOfferController.call(OfferDTOTestData.get().getId());
  }

  @Test
  @DisplayName("Work request status AGREED returned successfully")
  public void test1() {

    assertEquals(
        workRequestDTOTestData.getStatus(),
        workRequestDTO.getStatus()
    );
  }

  @Test
  @DisplayName("Work request entity is saved with Status AGREED")
  public void test2() {
    Mockito.verify(workRequestRepository).save(captorEntity.capture());
    assertEquals(
        WorkRequestEntityTestData.getProviderAndStatusAgreed(),
        captorEntity.getValue()
    );

  }

  @Test
  @DisplayName("Provider is set in workRequest and WorkRequestDTO")
  public void test3() {
    Mockito.verify(workRequestRepository).save(captorEntity.capture());
    assertEquals(
        workRequestDTO.getProvider(), captorEntity.getValue().getProvider()
    );

  }

}
