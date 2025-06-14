package com.sang.java.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoPostLoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		System.out.println("Username: " + user + " :: " + "Password: " + pass);
		PrintWriter pw = response.getWriter();
		pw.println("<b> Username: </b> " + user);
		pw.println("<br> <b> Password: </b> " + pass);
		pw.close();
	}
}
