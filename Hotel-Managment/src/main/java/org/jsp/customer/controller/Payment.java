package org.jsp.customer.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsp.dao.AdminDao;
import org.jsp.dao.AdminDaoImpl;
import org.jsp.dao.CustomerDao;
import org.jsp.dao.CustomerDaoImpl;
import org.jsp.entity.BookingDetails;
import org.jsp.entity.Card;
import org.jsp.entity.Customer;
import org.jsp.entity.Hotel;

@WebServlet("/payment")
public class Payment extends HttpServlet {
	private CustomerDao customerDao=new CustomerDaoImpl();
	private AdminDao adminDao =new AdminDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// fetch Booking Details from session
		HttpSession session=req.getSession();
		BookingDetails details=(BookingDetails)session.getAttribute("bookingDetails");
		
		//fetch hotel details from session
		Hotel hotel=(Hotel)session.getAttribute("hotelObj");
		Customer customer=(Customer)session.getAttribute("customerObj");
		
		//fetch card details from html
		Card card=new Card();
		card.setCardNumber(req.getParameter("cardNumber"));
		card.setCardHolderName(req.getParameter("cardHolderName"));
		card.setCvv(Integer.parseInt(req.getParameter("cvv")));
		card.setExpiryDate(LocalDate.parse(req.getParameter("expiryDate")));
		
		//add booking Details to list
		List<BookingDetails> bookingDetails=new ArrayList<BookingDetails>();
		bookingDetails.add(details);
		
		card.setBookingDetails(bookingDetails);
		card.setCustomer(customer);
		
		boolean status=customerDao.addCard(card);
		if(status) {
			//update Booking status
			details.setStatus("booked");
			details.setCard(card);
			BookingDetails updateStatus=customerDao.updateBookingStatus(details);
			
			//update hotel no of room booked
			int totalNoOfBookedRooms=hotel.getNoOfBookedRoom()+details.getNoOfRoom();
			hotel.setNoOfBookedRoom(totalNoOfBookedRooms);
			
			Hotel updateHotelDetails=adminDao.updateHotelDetails(hotel);
			
			if(updateHotelDetails!=null && updateStatus != null) {
				resp.sendRedirect("/Hotel-Managment/user/Payment.jsp?msg=payment");
			}else {
				resp.sendRedirect("/Hotel-Managment/user/AfterHotelPayment.jsp?msg=fail");
			}
		}else {
			resp.sendRedirect("/Hotel-Managment/user/AfterHotelPayment.jsp?msg=fail");
		}
		
	}

}
