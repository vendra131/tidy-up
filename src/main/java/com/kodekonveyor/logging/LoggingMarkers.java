package com.kodekonveyor.logging;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.kodekonveyor.webapp.InterfaceClass;

@InterfaceClass
public class LoggingMarkers {

  public static final Marker AUTHENTICATION =
      MarkerFactory.getMarker("authentication");
}
