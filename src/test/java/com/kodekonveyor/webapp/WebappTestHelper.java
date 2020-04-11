package com.kodekonveyor.webapp;

import static org.assertj.core.api.Assertions.fail;

import java.text.MessageFormat;

@InterfaceClass
public class WebappTestHelper {

  private static final String NO_0_IN_1 = "no {0} in {1}";

  public static void
      assertContains(final String contained, final String container) {
    if (!container.contains(contained))
      fail(MessageFormat.format(NO_0_IN_1, contained, container));
  }

}
