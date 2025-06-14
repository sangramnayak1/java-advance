package com.sang.java.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormValidationServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void service (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException {

		String uid = request.getParameter("username");
		String pwd = request.getParameter("password");
		boolean loginStatus = authenticateUser(uid, pwd);
		
		//if ("admin".equals(uid) && "tuna".equals(pwd)) {
		//	loginStatus = true;
		//}

		PrintWriter pw = response.getWriter();
		
		if (loginStatus) {
			pw.println("login success");
		} else {
			pw.println("login failed");
		}
		pw.close();
	}

	private boolean authenticateUser(String uid, String pwd) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SANGRAM","root","welcome1");
			stmt = con.createStatement();
			System.out.println("select * from users where username='" + uid + "' and password ='" + pwd + "'");
			rs = stmt.executeQuery("select * from users where username='" + uid + "' and password ='" + pwd + "'");
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
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
