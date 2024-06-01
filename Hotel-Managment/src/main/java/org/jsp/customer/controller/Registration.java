package org.jsp.customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.dao.CustomerDao;
import org.jsp.dao.CustomerDaoImpl;
import org.jsp.entity.Customer;

@WebServlet("/register")
public class Registration extends HttpServlet{
	 
	private CustomerDao customerDao=new CustomerDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Customer customer = new Customer();
		customer.setFirstName(req.getParameter("fName"));
		customer.setLastName(req.getParameter("lName"));
		customer.setEmail(req.getParameter("email"));
		customer.setMobile(Long.parseLong(req.getParameter("contact")));
		customer.setGender(req.getParameter("gender"));
		customer.setPassword(req.getParameter("password"));
		
		customerDao.registration(customer);
		
		resp.sendRedirect("/Hotel-Managment/user/Login.jsp?msg=added");
	}

}
