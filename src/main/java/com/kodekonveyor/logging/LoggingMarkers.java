package com.kodekonveyor.logging;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.kodekonveyor.webapp.ExcludeFromCodeCoverage;
import com.kodekonveyor.webapp.InterfaceClass;

@InterfaceClass
@ExcludeFromCodeCoverage("No methods in the class.")
public class LoggingMarkers {

  public static final Marker AUTHENTICATION =
      MarkerFactory.getMarker("authentication");
}
