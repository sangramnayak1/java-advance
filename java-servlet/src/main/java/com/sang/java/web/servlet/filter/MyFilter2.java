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

public class MyFilter2 implements Filter {

	private FilterConfig config = null;
	
	@Override
	public void destroy() {
		System.out.println("I am in destroy() of MyFilter2.");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		PrintWriter pw = httpResponse.getWriter();
		System.out.println("MyFilter2 starts.");
		pw.println("MyFilter2 starts.");
		pw.println(config.getInitParameter("testMessage"));
		pw.println(config.getServletContext().getAttribute("testParam"));
		pw.println("Happy!");
		chain.doFilter(request, response);
		System.out.println("MyFilter2 ends.");
		pw.println("MyFilter2 ends.");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		System.out.println("I am in init() of MyFilter2.");
	}

}
