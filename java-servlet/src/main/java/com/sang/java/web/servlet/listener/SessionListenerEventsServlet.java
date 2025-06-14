package com.sang.java.web.servlet.listener;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionListenerEventsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		session.setAttribute("testSession", "TEST_SESSION_ATTRIBUTE");
		System.out.println("--- SessionListenerEventsServlet# check its listener events life cycle.");
		PrintWriter pw = response.getWriter();
		pw.println("--- SessionListenerEventsServlet# check its listener events life cycle - " + session.getAttribute("testSession"));
		pw.close();
	}

}
