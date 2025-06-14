package com.sang.java.web.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter1 implements Filter{

	@Override
	public void destroy() {
		System.out.println("I am in destroy() of HelloFilter1.");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Entry of doFilter() in HelloFilter1");
		/*
		 * If you comment the chain.doFilter then the url will show blank page.
		 * HelloFilter1 will be called first as 1st resource,
		 * then HelloFilter1's chain.doFilter() will call helloFilter.html as 2nd resource.
		 */	
		chain.doFilter(request, response);
		System.out.println("Exit of doFilter() in HelloFilter1");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("I am in init() of HelloFilter1.");
	}

}
