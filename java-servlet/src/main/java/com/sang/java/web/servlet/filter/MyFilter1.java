package com.sang.java.web.servlet.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class MyFilter1 implements Filter {

	@Override
	public void destroy() {
		System.out.println("I am in destroy() of MyFilter1.");
	}

	// Required when MyFilter1 - MyFilterServlet1 both needs to run together.
	/*@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MyFilter1 starts.");	
		chain.doFilter(request, response);
		System.out.println("MyFilter1 ends.");
		
	}*/
	
	// Required when MyFilter2 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		PrintWriter pw = httpResponse.getWriter();
		System.out.println("MyFilter1 starts.");
		pw.println("MyFilter1 starts.");	
		chain.doFilter(request, response);
		System.out.println("MyFilter1 ends.");
		pw.println("MyFilter1 ends.");
		pw.close();
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("I am in init() of MyFilter1");
	}

}
