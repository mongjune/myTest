package org.hanja.domain;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * Servlet Filter implementation class fillter
 */
@Component
public class fillter implements Filter {
int i;
    /**
     * Default constructor. 
     */
    public fillter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		i++; 
		System.out.println(i+"________________________");
		 System.out.println("Filter...........");
	      System.out.println("Filter...........");
	      System.out.println("Filter...........");
	      
	      HttpServletResponse res = (HttpServletResponse)response;
	      
	      //res.setHeader("Access-Control-Allow-Origin", "*");
	      
	      res.addHeader("Access-Control-Allow-Origin", "*");
	      res.setHeader("Access-Control-Allow-Methods", "POST, GET");
	      res.setHeader("Access-Control-Max-Age", "3600");
	         res.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
	      chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		i = 0;
		// TODO Auto-generated method stub
	}

}
