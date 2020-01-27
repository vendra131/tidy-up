package com.kodekonveyor.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kodekonveyor.tidyup.Application;

@Service
@ExcludeFromCodeCoverage("proxy service")
public class LoggerService {

  private static final Logger LOGGER = //NOPMD
      LoggerFactory.getLogger(Application.class);

  public void call(final String msg) {
    LOGGER.info(msg);
  }

}
