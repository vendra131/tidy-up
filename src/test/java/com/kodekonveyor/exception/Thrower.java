package com.kodekonveyor.exception;

import com.kodekonveyor.webapp.InterfaceClass;

@FunctionalInterface
@InterfaceClass
public interface Thrower {

  void throwException() throws Throwable;
}
