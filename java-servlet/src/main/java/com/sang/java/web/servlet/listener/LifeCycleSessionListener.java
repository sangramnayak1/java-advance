package com.sang.java.web.servlet.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class LifeCycleSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("LifeCycleSessionListener# HttpSessionListener listener created.");	
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("LifeCycleSessionListener# HttpSessionListener listener destroyed.");	
	}
}
