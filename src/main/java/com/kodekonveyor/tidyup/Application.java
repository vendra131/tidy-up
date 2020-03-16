package com.kodekonveyor.tidyup;

import java.lang.reflect.Field;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.MethodParameter;

import com.kodekonveyor.webapp.ExcludeFromCodeCoverage;
import com.kodekonveyor.webapp.InterfaceClass;

@SpringBootApplication
@ExcludeFromCodeCoverage("empty")
@InterfaceClass
public class Application {

  @Bean
  @Scope("prototype")
  public Logger logger(final InjectionPoint injectionPoint) {
    return LoggerFactory.getLogger(getContainingClass(injectionPoint));
  }

  private Class<?> getContainingClass(final InjectionPoint injectionPoint) {
    return getClassInCaseOfParameterInjection(injectionPoint)
        .orElseGet(() -> getClassInCaseOfFieldInjection(injectionPoint)
            .orElseThrow(IllegalArgumentException::new)
        );
  }

  private Optional<Class<?>>
      getClassInCaseOfParameterInjection(final InjectionPoint injectionPoint) {
    return Optional.ofNullable(injectionPoint.getMethodParameter())
        .<Class<?>>map(MethodParameter::getContainingClass);
  }

  private Optional<Class<?>>
      getClassInCaseOfFieldInjection(final InjectionPoint injectionPoint) {
    return Optional.ofNullable(injectionPoint.getField())
        .map(Field::getDeclaringClass);
  }
}
