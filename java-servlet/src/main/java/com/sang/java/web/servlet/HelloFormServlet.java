package com.sang.java.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloFormServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		/*
		 * Access the URL 
		 * http://localhost:8080/test-java-servlet/helloForm.html
		 * and pass the name
		 */
		String name = request.getParameter("myName");
		pw.println("Hello, " + name);
		pw.close();
	}
}
