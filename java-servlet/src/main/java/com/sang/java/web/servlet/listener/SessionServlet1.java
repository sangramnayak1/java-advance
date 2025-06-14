package com.sang.java.web.servlet.listener;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet1 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		System.out.println("--- SessionServlet1# check its HttpSessionListener life cycle.");
		session.setAttribute("testSession", "TEST_SESSION_ATTR");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("--- SessionServlet1# check its HttpSessionListener life cycle.");
		pw.println("<br> --- SessionServlet1# A new session object created - " + session.getAttribute("testSession"));
		pw.println("<br> <a href=\"callSessionServlet2\"> Do you want to kill the session? </a>");
		pw.close();
	}

}
