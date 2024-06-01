package org.jsp.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsp.dao.AdminDao;
import org.jsp.dao.AdminDaoImpl;
import org.jsp.entity.Admin;
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	
	private AdminDao adminDao=new AdminDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Admin admin = adminDao.login(email, password);
		System.out.println(admin);
		if(admin!=null) {
			
			//if details are valid
//			String fullname= admin.getFirstName()+" "+admin.getLastName();
//			req.setAttribute("admin", admin);
//			req.setAttribute("fullName",fullname );
			
//			RequestDispatcher dispatcher=req.getRequestDispatcher("/admin/Home1.jsp");
//			dispatcher.forward(req, resp);
			
			HttpSession session=req.getSession();
			session.setAttribute("adminObj", admin);
			resp.sendRedirect("/Hotel-Managment/admin/Home1.jsp?msg=login");
			
		}else {
			//if details are not valid
			req.setAttribute("message", "Please Enter valid Email or Password");
			RequestDispatcher dispatcher=req.getRequestDispatcher("/admin/Login.jsp");
			dispatcher.forward(req, resp);
		}
		
	}

}
