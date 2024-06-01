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
import org.jsp.entity.Hotel;
@WebServlet("/AddHotel")
public class AddHotel extends HttpServlet{
	private AdminDao adminDao=new AdminDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String hotelName=req.getParameter("hotelName");
		long contact=Long.parseLong(req.getParameter("contact"));
		double price=Double.parseDouble(req.getParameter("price"));
		String city=req.getParameter("city");
		String address=req.getParameter("address");
		int noOfRooms=Integer.parseInt(req.getParameter("rooms"));
		
		Hotel hotel=new Hotel();
		hotel.setHotelName(hotelName);
		hotel.setMobile(contact);
		hotel.setPrice(price);
		hotel.setCity(city);
		hotel.setAddress(address);
		hotel.setTotalNoOfRoom(noOfRooms);
		
		adminDao.addHotel(hotel);
		
		resp.sendRedirect("/Hotel-Managment/admin/HotelList.jsp?msg=added");
		
		
	}

}
