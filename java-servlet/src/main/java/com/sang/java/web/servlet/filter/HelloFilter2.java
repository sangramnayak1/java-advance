package com.sang.java.web.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter2 implements Filter {

	@Override
	public void destroy() {
		System.out.println("I am in destroy() of HelloFilter2.");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Entry of doFilter() in HelloFilter2");
		/*
		 * When both filter classes HelloFilter1 and HelloFilter2 points to same html page, then
		 * HelloFilter1 will be called first as 1st resource,
		 * then HelloFilter1's doFilter will call HelloFilter2 as 2nd resource,
		 * finally HelloFilter2's chain.doFilter() will call helloFilter.html as 3rd resource
		 */	
		chain.doFilter(request, response);
		System.out.println("Exit of doFilter() in HelloFilter2");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("I am in init() of HelloFilter2.");
	}

}
