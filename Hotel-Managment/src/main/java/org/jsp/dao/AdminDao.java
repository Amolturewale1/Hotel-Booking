package org.jsp.dao;

import java.util.List;

import org.jsp.entity.Admin;
import org.jsp.entity.BookingDetails;
import org.jsp.entity.Hotel;

public interface AdminDao {
	
	Admin login(String email,String password);
	
	void addHotel(Hotel hotel);
	
	List<Hotel> getAllHotelsDetails();
	
	boolean deleteHotalById(int id);
	
	Hotel updateHotelDetails(Hotel hotel);
	
	Hotel getHotelById(int id);
	
	void addAdmin(Admin admin);
	
	List<Admin> getAllAdminsDetails();
	
	Admin getAdminById(int id);
	
	
	Admin updateAdmin(Admin admin);
	
	boolean deleteAdminById(int id);
	
	List<Hotel> getHotelByKeyWord(String keyword);
	List<BookingDetails>  getAllBookingDetails();

}
