package com.kodekonveyor.webapp;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@ExcludeFromCodeCoverage("Configuration")
@InterfaceClass
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {// NOPMD
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { SpringConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
