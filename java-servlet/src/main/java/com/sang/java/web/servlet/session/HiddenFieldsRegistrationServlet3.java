package com.sang.java.web.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiddenFieldsRegistrationServlet3 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fn = request.getParameter("firstName");
		String ln = request.getParameter("lastName");
		String age = request.getParameter("age");
		System.out.println("First Name: " + fn + " :: " + "Last Name: " + ln);
		
		response.setContentType("text/html");  
		PrintWriter pw = response.getWriter();
		pw.println("First Name: " + fn + "<br>");
		pw.println("Last Name: " + ln + "<br>");
		pw.println("Age: " + age + "<br>");
		
		pw.println("<center>");
		pw.println("<h1>Step 4</h1> <hr>");
		pw.println("<form action = \"hiddenRegistrationServlet4\">");
		pw.println("First Name: <input type = \"hidden\" name = \"firstName\" value = \""+ fn +"\"> <br>");
		pw.println("Last Name: <input type = \"hidden\" name = \"lastName\" value = \""+ ln +"\"> <br>");
		pw.println("Age: <input type = \"hidden\" name = \"age\" value = \""+ age +"\"> <br>");
		pw.println("Address: <input type = \"text\" name = \"address\"> <br>");
		pw.println("Contact No: <input type = \"text\" name = \"contact\"> <br>");
		pw.println("Email: <input type = \"text\" name = \"email\"> <br>");
		pw.println("<input type = \"submit\" name = \"Submit\">");
		pw.println("</form>");
		pw.println("</center>");
		pw.close();
		System.out.println("First Name: " + fn + " :: " + "Last Name: " + ln);
	}
}
