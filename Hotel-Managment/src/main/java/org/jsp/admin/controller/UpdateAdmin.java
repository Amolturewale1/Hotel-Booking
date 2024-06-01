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
@WebServlet("/UpdateAdmin")
public class UpdateAdmin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Admin admin=new Admin();
		String fName=req.getParameter("fName");
		String lName=req.getParameter("lName");
		long mobile=Long.parseLong(req.getParameter("contact"));
		String email=req.getParameter("email");
		String password =req.getParameter("password");
		int adminId=Integer.parseInt(req.getParameter("adminId"));
		
		System.out.println(fName+" "+lName+" "+mobile+" "+email+" "+password+" "+adminId);
		
		admin.setFirstName(fName);
		admin.setLastName(lName);
		admin.setEmail(email);
		admin.setMobile(mobile);
		admin.setPassword(password);
		admin.setId(adminId);
		
		AdminDao adminDao=new AdminDaoImpl();
	    Admin updatedAdmin =  adminDao.updateAdmin(admin);
	    
	    resp.sendRedirect("/Hotel-Managment/admin/UserLists.jsp?msg=admin_update&adminId="+adminId);
		
		
	}

}
