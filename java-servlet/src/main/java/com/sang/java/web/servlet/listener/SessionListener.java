package com.sang.java.web.servlet.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	private int counter = 0;
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		counter++;
		Object obj = event.getSession().getAttribute("testSession");
		System.out.println("SessionListener# Session event created. -> " + obj.toString());
		System.out.println("SessionListener# Total active users increased = " + counter);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		counter--;
		Object obj = event.getSession().getAttribute("testSession");
		System.out.println("SessionListener# Session event destroyed. -> " + obj.toString());
		System.out.println("SessionListener# Total active users decreased = " + counter);
	}
}
