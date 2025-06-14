package com.sang.java.web.servlet.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilterServlet1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("I am in MyFilterServlet1.");
		PrintWriter pw = response.getWriter();
		pw.println("I am in MyFilterServlet1.");
		pw.close();
	}

}
