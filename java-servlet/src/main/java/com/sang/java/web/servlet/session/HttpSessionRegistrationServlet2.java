package com.sang.java.web.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpSessionRegistrationServlet2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		//String fn = (String) session.getAttribute("firstName");
		//String ln = (String) session.getAttribute("lastName");
		//String age = (String) session.getAttribute("age");
		
		String fn = request.getParameter("firstName");
		String ln = request.getParameter("lastName");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		System.out.println("First Name: " + fn + " :: " + "Last Name: " + ln);
		
		session.setAttribute("address", address);
		session.setAttribute("contact", contact);
		session.setAttribute("email", email);
		
		response.setContentType("text/html"); 
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Step 3</h1> <hr>");
		pw.println("First Name : " + fn + "<br>");
		pw.println("Last Name : " + ln + "<br>");
		pw.println("Age : " + age + "<br>");
		pw.println("Address : " + address + "<br>");
		pw.println("Contact No : " + contact + "<br>");
		pw.println("Email : " + email + "<br>");
		pw.println("<center>");
		pw.println("<h1>Step 4</h1> <hr>");
		pw.println("<form action = \"sessionRegistrationServlet3\" method = \"post\">");
		pw.println("<input type = \"submit\" name = \"Get All Parameters\">");
		pw.println("</form>");
		pw.println("</center>");
		pw.close();
		System.out.println("First Name: " + fn + " :: " + "Last Name: " + ln);
	}
}
