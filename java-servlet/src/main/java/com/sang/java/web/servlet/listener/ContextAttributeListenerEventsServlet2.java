package com.sang.java.web.servlet.listener;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextAttributeListenerEventsServlet2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		context.setAttribute("name", "Sangram");
		System.out.println("--- ContextAttributeListenerEventsServlet# check its listener event life cycle -> " + request.getAttribute("name"));
		PrintWriter pw = response.getWriter();
		pw.println("--- ContextAttributeListenerEventsServlet# check its listener event life cycle -> " + request.getAttribute("name"));
		pw.close();
	}
}
