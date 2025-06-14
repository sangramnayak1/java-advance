package com.sang.java.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void service (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException {
		
		String uid = request.getParameter("username");
		String pwd = request.getParameter("password");
		boolean loginStatus = false;
		
		if ("admin".equals(uid) && "adminpass".equals(pwd)) {
			loginStatus = true;
		}
		
		PrintWriter pw = response.getWriter();
		
		if (loginStatus) {
			pw.println("login success");
		} else {
			pw.println("login failed");
		}
		pw.close();
	}
}
