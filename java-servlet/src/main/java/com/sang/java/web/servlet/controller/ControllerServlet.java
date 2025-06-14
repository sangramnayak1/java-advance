package com.sang.java.web.servlet.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ConnectionPool pool;
	
	public ControllerServlet() {
		System.out.println("--- 1: ControllerServlet#ControllerServlet() life started. ---");
	}
	
	/*public void init() throws ServletException {
		System.out.println("--- 2: ControllerServlet#init() called. ---");
		pool = new ConnectionPool(0, "com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/SANGRAM", "root", "welcome1");
		pool.init();
	}*/
	
	public void init(ServletConfig config) throws ServletException {
		//calling init() of HttpServlet
		super.init(config);
		System.out.println("--- 2: ControllerServlet#init() called. ---");
		System.out.println("ServletConfig config object initialized.");
		
		String driver = config.getInitParameter("driver");
		String url = config.getInitParameter("url");
		String poolSize = config.getInitParameter("poolSize");
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		
		pool = new ConnectionPool(Integer.parseInt(poolSize), driver, url, username, password);
		pool.init();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException {
		
		System.out.println("--- 3: ControllerServlet#service() called. ---");
		String decider = request.getParameter("decider");
		RequestDispatcher dispatcher = null;
		Connection con = null;
		
		if("login".equals(decider)) {
			//getting connection object
			con = pool.checkOut();
			//storing connection object in request object
			request.setAttribute("con", con);
			//forward this url pattern request to login servlet
			dispatcher = request.getRequestDispatcher("login");
			//calling straight to login servlet
			dispatcher.forward(request, response);
			pool.checkIn(con);
		} else if("registration".equals(decider)) {
			//getting connection object
			con = pool.checkOut();
			//storing connection object in request object
			request.setAttribute("con", con);
			//forward this url pattern request to login servlet
			dispatcher = request.getRequestDispatcher("registration");
			//calling straight to login servlet
			dispatcher.forward(request, response);
			pool.checkIn(con);
		}
		
		String appConstant = getServletContext().getInitParameter("testParam");
		System.out.println("ControllerServlet works " + appConstant);
	}
	
	public void destroy() {
		System.out.println("--- 2: ControllerServlet#destroy() called. ---");
		pool.release();
	}
}
