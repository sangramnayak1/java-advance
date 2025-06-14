package com.sang.java.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloParameterServlet3 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		/*
		 * pass the name at end of the URL 
		 * http://localhost:8080/test-java-servlet/hello2?myName=Sangram
		 * 
		 */
		String name = request.getParameter("myName");
		pw.println("Hello, " + name);
		pw.close();
	}
}
