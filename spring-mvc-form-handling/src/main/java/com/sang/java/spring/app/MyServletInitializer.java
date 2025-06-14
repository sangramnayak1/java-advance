package com.sang.java.spring.app;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.sang.java.spring.app.config.SpringCoreConfig;
import com.sang.java.spring.app.config.SpringWebConfig;

public class MyServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// services and data sources
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SpringCoreConfig.class };
	}

	// controller, view resolver, handler mapping
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringWebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}
