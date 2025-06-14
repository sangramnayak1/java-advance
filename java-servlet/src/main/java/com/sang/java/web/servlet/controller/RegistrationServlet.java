package com.sang.java.web.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void service (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException {
		
		String fn = request.getParameter("firstName");
		String ln = request.getParameter("lastName");
		String age = request.getParameter("age");
		String addr = request.getParameter("address");
		String cont = request.getParameter("contact");
		String email = request.getParameter("email");
		String un = request.getParameter("username");
		String pwd = request.getParameter("password");
		String[] data = {fn, ln, age, addr, cont, email, un, pwd};
		
		Connection con = (Connection) request.getAttribute("con");
		int insertionStatus = registerNewUser(data, con);
		
		PrintWriter pw = response.getWriter();
		
		String appConstant = getServletContext().getInitParameter("testParam");
		if (insertionStatus == 1) {
			pw.println("registration success " + appConstant);
		} else {
			pw.println("registration failed");
		}
		pw.close();
	}
	
	private int registerNewUser(String[] data, Connection con) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into users(first_name, ");
		sql.append("last_name, age, address, contact, email, username, password)");
		
		sql.append(" values ('" + data[0] + "', ");
		sql.append("'" + data[1] + "', ");
		sql.append("'" + data[2] + "', ");
		sql.append("'" + data[3] + "', ");
		sql.append("'" + data[4] + "', ");
		sql.append("'" + data[5] + "', ");
		sql.append("'" + data[6] + "', ");
		sql.append("'" + data[7] + "');");
		System.out.println("SQL insert query : " + sql);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Connection con = null;
		Statement stmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SANGRAM","root","welcome1");
			stmt = con.createStatement();
			return stmt.executeUpdate(sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
			try {
				if (con != null) {
					con.close();
					con = null;
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}
}
