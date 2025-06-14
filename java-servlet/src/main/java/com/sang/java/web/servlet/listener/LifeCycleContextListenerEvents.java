package com.sang.java.web.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LifeCycleContextListenerEvents implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		String contextMsg = event.getServletContext().getInitParameter("testMsg");
		System.out.println("LifeCycleContextListenerEvents# ServletContextListener listener events initialized. -> " + contextMsg);	
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		String contextMsg = event.getServletContext().getInitParameter("testMsg");
		System.out.println("LifeCycleContextListenerEvents# ServletContextListener listener events destroyed. -> " + contextMsg);		
	}
}
