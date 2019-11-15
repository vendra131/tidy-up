package com.kodekonveyor.webapp;

import static org.assertj.core.api.Assertions.fail;

@InterfaceClass
public class WebappTestHelper {

	public static void assertContains(final String contained, final String container) {
		if (!container.contains(contained))
			fail("no " + contained + " in " + container);
	}

}
