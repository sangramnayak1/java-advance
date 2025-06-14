package com.sang.java.web.servlet.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class LifeCycleSessionListenerEvents implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		Object obj = event.getSession().getAttribute("testSession");
		System.out.println("LifeCycleSessionListenerEvents# HttpSessionListener listener events created. -> " + obj.toString());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		Object obj = event.getSession().getAttribute("testSession");
		System.out.println("LifeCycleSessionListenerEvents# HttpSessionListener listener events destroyed. -> " + obj.toString());
	}
}
