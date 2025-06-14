package com.sang.java.web.servlet.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class LifeCycleRequestListenerEvents implements ServletRequestListener {

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		//ServletRequest sr = event.getServletRequest();
		//HttpServletRequest hsr = (HttpServletRequest) sr;
		//String requestMsg = hsr.getParameter("requestParam");
		String requestMsg = event.getServletRequest().getParameter("requestParam");
		System.out.println("LifeCycleRequestListenerEvents# ServletRequestListener listener events initialized. -> " + requestMsg);
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		//ServletRequest sr = event.getServletRequest();
		//HttpServletRequest hsr = (HttpServletRequest) sr;
		//String requestMsg = hsr.getParameter("requestParam");
		String requestMsg = event.getServletRequest().getParameter("requestParam");
		System.out.println("LifeCycleRequestListenerEvents# ServletRequestListener listener events destroyed. -> " + requestMsg);
	}
}
