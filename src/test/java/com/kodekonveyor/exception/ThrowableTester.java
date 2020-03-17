package com.kodekonveyor.exception;

import static com.kodekonveyor.exception.ThrowableTesterConstants.CONTAIN;
import static com.kodekonveyor.exception.ThrowableTesterConstants.EXPECTED_S_BUT_GOT_S;
import static com.kodekonveyor.exception.ThrowableTesterConstants.MATCH;
import static com.kodekonveyor.exception.ThrowableTesterConstants.MESSAGE_DOES_NOT_TEMPLATE;
import static com.kodekonveyor.exception.ThrowableTesterConstants.NO_EXCEPTION_THROWN;
import static com.kodekonveyor.exception.ThrowableTesterConstants.NO_MESSAGE_OF_THE_EXCEPTION;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.platform.commons.util.ExceptionUtils;
import org.springframework.stereotype.Service;

import com.kodekonveyor.webapp.ExcludeFromCodeCoverage;
import com.kodekonveyor.webapp.InterfaceClass;

@Service
@InterfaceClass
@ExcludeFromCodeCoverage("temporarily")
public class ThrowableTester { //NOPMD

  public Throwable thrown;
  private static ThrowableTester tester = new ThrowableTester();

  private ThrowableTester() {
  }

  public ThrowableTester assertMessageIs(final String message) {
    assertEquals(message, thrown.getMessage());
    return this;
  }

  public ThrowableTester assertMessageMatches(final String string) {
    assertNotNull(NO_MESSAGE_OF_THE_EXCEPTION, thrown.getMessage());
    assertTrue(
        String.format(
            MESSAGE_DOES_NOT_TEMPLATE, MATCH, string, thrown.getMessage()
        ),
        thrown.getMessage().matches(string)
    );
    return this;
  }

  public ThrowableTester assertMessageContains(final String string) {
    assertTrue(
        String.format(
            MESSAGE_DOES_NOT_TEMPLATE, CONTAIN, string, thrown.getMessage()
        ),
        thrown.getMessage().contains(string)
    );
    return this;
  }

  public ThrowableTester
      assertStackFileName(final int stackIndex, final String string) {
    final StackTraceElement stackElement = getStackTraceElement(stackIndex);
    assertEquals(string, stackElement.getFileName());
    return this;
  }

  public ThrowableTester
      assertStackClass(final int stackIndex, final String string) {
    final StackTraceElement stackElement = getStackTraceElement(stackIndex);
    assertEquals(string, stackElement.getClassName());
    return this;
  }

  public ThrowableTester
      assertStackLineNumber(final int stackIndex, final int lineNumber) {
    final StackTraceElement stackElement = getStackTraceElement(stackIndex);
    assertEquals(lineNumber, stackElement.getLineNumber());
    return this;
  }

  public ThrowableTester
      assertStackMethod(final int stackIndex, final String string) {
    final StackTraceElement stackElement = getStackTraceElement(stackIndex);
    assertEquals(string, stackElement.getMethodName());
    return this;
  }

  private StackTraceElement getStackTraceElement(final int stackIndex) {
    return thrown.getStackTrace()[stackIndex];
  }

  public ThrowableTester showStackTrace() {
    thrown.printStackTrace(); // NOPMD AvoidPrintStackTrace
    return this;
  }

  public static ThrowableTester assertThrows(final Thrower thrower) {
    return tester.doAssertThrows(thrower);
  }

  public ThrowableTester doAssertThrows(final Thrower thrower) {
    try {
      thrower.throwException();
    } catch (final Throwable exception) { // NOPMD AvoidCatchingThrowable
      thrown = exception;
    }
    if (thrown == null)
      fail(NO_EXCEPTION_THROWN);
    return this;
  }

  public Throwable getException() {
    return thrown;
  }

  public ThrowableTester
      assertException(final Class<? extends Throwable> klass) {
    final String message = String.format(
        EXPECTED_S_BUT_GOT_S, klass, ExceptionUtils.readStackTrace(thrown)
    );
    assertEquals(message, klass, thrown.getClass());
    return this;
  }

  public ThrowableTester assertUnimplemented(final Thrower thrower) {
    assertThrows(thrower).assertException(UnsupportedOperationException.class);
    return this;
  }

}
