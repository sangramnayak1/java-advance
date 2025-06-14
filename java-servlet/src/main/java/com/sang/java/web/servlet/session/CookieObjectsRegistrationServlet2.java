package com.sang.java.web.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieObjectsRegistrationServlet2 extends HttpServlet {
	
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
		
		Cookie[] allCookies = request.getCookies();
		response.setContentType("text/html"); 
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Step 3</h1> <hr>");
		pw.println("First Name : " + fn); //null as there is no parameter
		pw.println("Last Name : " + ln); //null as there is no parameter
		pw.println("Age : " + age); //null as there is no parameter
		pw.println();
		pw.println("First Name = " + allCookies[0].getName() + " : " + allCookies[0].getValue());
		pw.println("Last Name = " + allCookies[1].getName() + " : " + allCookies[1].getValue());
		pw.println("Age = " + allCookies[2].getName() + " : " + allCookies[2].getValue());
		pw.println("Address : " + address);
		pw.println("Contact No : " + contact);
		pw.println("Email : " + email);
		pw.close();
	}
}
