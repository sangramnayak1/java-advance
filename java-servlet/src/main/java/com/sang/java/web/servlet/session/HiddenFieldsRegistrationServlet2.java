package com.sang.java.web.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiddenFieldsRegistrationServlet2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fn = request.getParameter("firstName");
		String ln = request.getParameter("lastName");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		System.out.println("First Name: " + fn + " :: " + "Last Name: " + ln);
		
		PrintWriter pw = response.getWriter();
		pw.println("First Name : " + fn);
		pw.println("Last Name : " + ln);
		pw.println("Age : " + age);
		pw.println("Address : " + address);
		pw.println("Contact No : " + contact);
		pw.println("Email : " + email);
		pw.close();
	}
}
