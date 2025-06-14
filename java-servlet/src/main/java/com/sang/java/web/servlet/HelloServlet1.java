package com.sang.java.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet1 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*
		 * Access the URL 
		 * http://localhost:8080/test-java-servlet/hello1
		 */
		PrintWriter pw = response.getWriter();
		pw.println("Hello Web World!");
		pw.close();
	}
}
