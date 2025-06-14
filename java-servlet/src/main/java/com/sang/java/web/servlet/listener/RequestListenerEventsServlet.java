package com.sang.java.web.servlet.listener;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestListenerEventsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	String initParam = null;
	
	public RequestListenerEventsServlet() {
		System.out.println("  1) --- RequestListenerEventsServlet# default constructor called.");
	}
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("  2) --- RequestListenerEventsServlet# init() called.");
		initParam = config.getInitParameter("initParam");
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("  3) --- RequestListenerEventsServlet# check its listener events life cycle.");
		
		PrintWriter pw = response.getWriter();
		pw.println("--- RequestListenerEventsServlet# check its listener life cycle - " + initParam);
		pw.close();
	}
	
	public void destroy() {
		System.out.println("  4) --- RequestListenerEventsServlet# destroy() called.");
	}
}
