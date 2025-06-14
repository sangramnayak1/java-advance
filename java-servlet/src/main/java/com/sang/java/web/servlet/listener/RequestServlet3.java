package com.sang.java.web.servlet.listener;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet3 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("--- RequestServlet3: check its ServletRequestListener life cycle.");
		PrintWriter pw = response.getWriter();
		pw.println("--- RequestServlet3: check its ServletRequestListener life cycle.");
		pw.close();
	}
}
