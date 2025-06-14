package com.sang.java.web.servlet.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class LifeCycleRequestListener implements ServletRequestListener {

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		System.out.println("LifeCycleRequestListener# ServletRequestListener listener initialized.");
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		System.out.println("LifeCycleRequestListener# ServletRequestListener listener destroyed.");
	}
}
