package org.jsp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/user/Home2.jsp","/user/HotelList1.jsp","/user/BookHotel.jsp","/user/LogOut.jsp"})
public class CustomerFileFilters implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest =(HttpServletRequest) request;
		HttpServletResponse httpRespone =(HttpServletResponse) response;
		
		HttpSession session = httpRequest.getSession(false);
		if(session.getAttribute("customerObj")==null) {
			httpRespone.sendRedirect("/Hotel-Managment/user/Login.jsp");
		}else {
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
