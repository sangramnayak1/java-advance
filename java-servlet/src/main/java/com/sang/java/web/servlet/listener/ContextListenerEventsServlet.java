package com.sang.java.web.servlet.listener;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextListenerEventsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String contextParam = getServletContext().getInitParameter("testMsg");
		System.out.println("--- ContextListenerEventsServlet# check its listener event life cycle -> " + contextParam);
		PrintWriter pw = response.getWriter();
		pw.println("--- ContextListenerEventsServlet# check its listener event life cycle -> " + contextParam);
		pw.close();
	}

}
