package com.sang.java.web.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LifeCycleContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("LifeCycleContextListener# ServletContextListener listener initialized.");	
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("LifeCycleContextListener# ServletContextListener listener destroyed.");		
	}
}
