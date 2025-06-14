package com.sang.java.web.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpSessionRegistrationServlet3 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String fn = (String) session.getAttribute("firstName");
		String ln = (String) session.getAttribute("lastName");
		String age = (String) session.getAttribute("age");
		String address = (String) session.getAttribute("address");
		String contact = (String) session.getAttribute("contact");
		String email = (String) session.getAttribute("email");
		System.out.println("First Name: " + fn + " :: " + "Last Name: " + ln);
		
		response.setContentType("text/html"); 
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Step 4</h1> <hr>");
		pw.println("First Name : " + fn + "<br>");
		pw.println("Last Name : " + ln + "<br>");
		pw.println("Age : " + age + "<br>");
		pw.println("Address : " + address + "<br>");
		pw.println("Contact No : " + contact + "<br>");
		pw.println("Email : " + email + "<br>");
		pw.close();
	}
}
