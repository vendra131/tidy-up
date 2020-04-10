package com.kodekonveyor.work_request.find;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.stream.Collectors;

import com.kodekonveyor.work_request.WorkRequestDTO;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

public class FindTestHelper {

  public static void
      assertContains(final List<WorkRequestDTO> container) {
    final List<Long> ids = container.stream()
        .mapToLong(WorkRequestDTO::getWorkRequestId)
        .boxed()
        .collect(Collectors.toList());
    assertFalse(ids.contains(WorkRequestEntityTestData.NON_OWNER_ID));
  }
}
