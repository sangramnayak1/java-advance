package com.sang.java.web.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiddenFieldsRegistrationServlet4 extends HttpServlet {
	
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
		
		response.setContentType("text/html");  
		PrintWriter pw = response.getWriter();
		pw.println("<center>");
		pw.println("<h1>Step 5</h1> <hr>");
		pw.println("<form action = \"hiddenRegistrationServlet5\">");
		pw.println("First Name: <input type = \"hidden\" name = \"firstName\" value = \""+ fn +"\">");
		pw.println("Last Name: <input type = \"hidden\" name = \"lastName\" value = \""+ ln +"\">");
		pw.println("Age: <input type = \"hidden\" name = \"age\" value = \""+ age +"\">");
		pw.println("Address: <input type = \"hidden\" name = \"address\" value = \""+ address +"\">");
		pw.println("Contact: <input type = \"hidden\" name = \"contact\" value = \""+ contact +"\">");
		pw.println("Email: <input type = \"hidden\" name = \"email\" value = \""+ email +"\">");
		pw.println("<input type = \"submit\" name = \"Submit\">");
		pw.println("</form>");
		pw.println("</center>");
		pw.close();
	}
}
