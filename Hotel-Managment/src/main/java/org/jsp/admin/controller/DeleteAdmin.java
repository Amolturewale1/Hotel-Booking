package org.jsp.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.dao.AdminDao;
import org.jsp.dao.AdminDaoImpl;
@WebServlet("/DeleteAdmin")
public class DeleteAdmin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int adminId=Integer.parseInt(req.getParameter("adminId"));
		
		AdminDao adminDao =new AdminDaoImpl();
		boolean status= adminDao.deleteAdminById(adminId);
		if(status) {
			req.setAttribute("message", "Admin Deleted Successfully");
			RequestDispatcher dispatcher=req.getRequestDispatcher("/admin/Login.jsp");
			dispatcher.forward(req, resp);
		}else {
			resp.sendRedirect("/Hotel-Managment/admin/UserLists.jsp?msg=adminDelete&adminId="+adminId);
			
		}
	}

}
