package com.sang.java.web.servlet.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class LifeCycleContextAttributeListenerEvents implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("LifeCycleContextAttributeListenerEvents# One attribute is added to app-scope");
		System.out.println("Name: " + event.getName());
		System.out.println("Value: " + event.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("LifeCycleContextAttributeListenerEvents# One attribute is replaced from app-scope.");
		System.out.println("Name: " + event.getName());
		System.out.println("Value: " + event.getValue());	
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("LifeCycleContextAttributeListenerEvents# One attribute is removed from app-scope.");
		System.out.println("Name: " + event.getName());
		System.out.println("Value: " + event.getValue());
	}
}
