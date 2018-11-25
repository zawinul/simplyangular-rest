package it.eng.sa.web;

import it.eng.sa.util.Log;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class SAWebFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
		try {
			
			HttpServletRequest r = (HttpServletRequest) req;
			//String uri = r.getRequestURI();
			// my logic....
			Log.web.debug(">>> "+r.getMethod()+" "+r.getRequestURI());
			filterChain.doFilter(req, resp);
		} 
		catch(Exception e) {
			Log.web.debug("", e);
			throw new RuntimeException(e);
		}
	}
	
	public void init(FilterConfig arg0) throws ServletException {
	}

}
