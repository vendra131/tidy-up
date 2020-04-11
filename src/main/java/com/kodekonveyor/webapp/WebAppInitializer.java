package com.kodekonveyor.webapp;

import javax.servlet.ServletContext;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

@InterfaceClass
@ExcludeFromCodeCoverage("boilerplate")
public class WebAppInitializer implements WebApplicationInitializer {

  public static XmlWebApplicationContext context;

  @Override
  public void onStartup(final ServletContext servletContext) {

    final WebApplicationContext context = getContext();
    servletContext.addListener(new ContextLoaderListener(context));

    final CharacterEncodingFilter characterEncodingFilter =
        new CharacterEncodingFilter();
    characterEncodingFilter.setEncoding(WebappConstants.UTF_8);
    characterEncodingFilter.setForceEncoding(true);
    servletContext.addFilter(
        WebappConstants.CHARACTER_ENCODING_FILTER, characterEncodingFilter
    )
        .addMappingForUrlPatterns(
            null,
            false, WebappConstants.SLASH_STAR
        );
  }

  private XmlWebApplicationContext getContext() {
    context = new XmlWebApplicationContext();
    context.setConfigLocations(WebappConstants.WEB_INF_APPLICATION_CONTEXT_XML);
    return context;
  }

}
