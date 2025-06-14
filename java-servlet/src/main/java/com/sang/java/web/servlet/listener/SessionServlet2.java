package com.sang.java.web.servlet.listener;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("--- SessionServlet2# check its HttpSessionListener life cycle.");
		HttpSession session = request.getSession(false);
		session.invalidate();
		PrintWriter pw = response.getWriter();
		pw.println("--- SessionServlet2# check its HttpSessionListener life cycle.");
		pw.println("--- SessionServlet2# Session object destoyed");
		pw.close();
	}
}
