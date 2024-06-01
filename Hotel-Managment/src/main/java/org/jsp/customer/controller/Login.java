package org.jsp.customer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsp.dao.CustomerDao;
import org.jsp.dao.CustomerDaoImpl;
import org.jsp.entity.Customer;

import com.google.protobuf.DiscardUnknownFieldsParser;

@WebServlet("/login")
public class Login extends HttpServlet{
	private CustomerDao customerDao=new CustomerDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Customer customer=customerDao.login(email, password);
		if(customer!=null) {
//			req.setAttribute("message", "Login Successful!!!");
//			RequestDispatcher dispatcher=req.getRequestDispatcher("/user/Home2.jsp");
//			dispatcher.forward(req, resp);
			
			HttpSession session=req.getSession();
			session.setAttribute("customerObj", customer);
			resp.sendRedirect("/Hotel-Managment/user/Home2.jsp?msg=login");
		}else {
			resp.sendRedirect("/Hotel-Managment/user/Login.jsp?msg=login");
		}
	}

}
