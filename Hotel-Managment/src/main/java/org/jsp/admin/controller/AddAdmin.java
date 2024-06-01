package org.jsp.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.dao.AdminDao;
import org.jsp.dao.AdminDaoImpl;
import org.jsp.entity.Admin;
@WebServlet("/AddAdmin")
public class AddAdmin extends HttpServlet {
	private AdminDao adminDao =new AdminDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fName=req.getParameter("fName");
		String lName=req.getParameter("lName");
		String email=req.getParameter("email");
		long mobile=Long.parseLong(req.getParameter("contact"));
		String password=req.getParameter("password");
		
		Admin admin=new Admin();
		admin.setFirstName(fName);
		admin.setLastName(lName);
		admin.setEmail(email);
		admin.setMobile(mobile);
		admin.setPassword(password);
		
		adminDao.addAdmin(admin);
		
		resp.sendRedirect("/Hotel-Managment/admin/Login.jsp?msg=adminAdded");
	}

}
