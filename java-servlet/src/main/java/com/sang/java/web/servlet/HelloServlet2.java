package com.sang.java.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet2 extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException {

		response.setContentType("text/html");
		/*
		 * Access the URL 
		 * http://localhost:8080/test-java-servlet/helloPage
		 */
		PrintWriter pw=response.getWriter();
		pw.println("<html><body>");  
		pw.println("Hello All, Welcome to Servlet!");  
		pw.println("</body></html>"); 
		pw.close();
	}
}
