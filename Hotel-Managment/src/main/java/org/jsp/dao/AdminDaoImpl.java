package org.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.entity.Admin;
import org.jsp.entity.BookingDetails;
import org.jsp.entity.Hotel;

import net.bytebuddy.implementation.bind.MethodDelegationBinder.AmbiguityResolver;

public class AdminDaoImpl implements AdminDao {
	EntityManagerFactory factory =Persistence.createEntityManagerFactory("hotel_booking");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=null;

	
	public Admin login(String email, String password) {
		
		String jpqlQuery="Select a from Admin a where a.email=?1 and a.password = ?2";
		
		Query query = manager.createQuery(jpqlQuery);
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		try {
			Admin admin=(Admin) query.getSingleResult();
			return admin;
			
		} catch (Exception e) {
			return null;
		}
	}


	public void addHotel(Hotel hotel) {
		transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(hotel);
		transaction.commit();
		
	}


	public List<Hotel> getAllHotelsDetails() {
		String jpql="Select h from Hotel h";
		Query query=manager.createQuery(jpql);
		
		List<Hotel> hotels= query.getResultList();
		return hotels;
	}


	public boolean deleteHotalById(int id) {
		transaction=manager.getTransaction();
		transaction.begin();
		Hotel hotel= manager.find(Hotel.class, id);
		
		
		if(hotel!=null) {
			manager.remove(hotel);
			transaction.commit();
			return true;
		}
		return false;
	}


	public Hotel updateHotelDetails(Hotel hotel) {
		transaction=manager.getTransaction();
		
		
		Hotel hotelDb =manager.find(Hotel.class,hotel.getId());
		
		if(hotelDb!=null) {
		hotelDb.setHotelName(hotel.getHotelName());
		hotelDb.setMobile(hotel.getMobile());
		hotelDb.setAddress(hotel.getAddress());
		hotelDb.setCity(hotel.getCity());
		hotelDb.setNoOfBookedRoom(hotel.getNoOfBookedRoom());
		hotelDb.setTotalNoOfRoom(hotel.getTotalNoOfRoom());
		hotelDb.setPrice(hotel.getPrice());
		
		transaction.begin();
	 	Hotel updateHotel1 = manager.merge(hotelDb);
	 	transaction.commit();
	 	return updateHotel1;
		
		}
		
		return null;
		
	}


	public Hotel getHotelById(int id) {
		
		Hotel hotel = manager.find(Hotel.class, id);
		if(hotel!=null) {
			return hotel;
		}
		return null;
	
	}


	public void addAdmin(Admin admin) {
		transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(admin);
		transaction.commit();
	}


	public List<Admin> getAllAdminsDetails() {
		String jpql="select a from Admin a";
		Query query=manager.createQuery(jpql);
		List<Admin> admins= query.getResultList();
		return admins;
	}


	public Admin getAdminById(int id) {
		Admin admin = manager.find(Admin.class, id);
		if(admin!=null) {
			return admin;
		}
		return null;
	}


	public Admin updateAdmin(Admin admin) {
		transaction=manager.getTransaction();
		
		
		Admin adminDb=manager.find(Admin.class,admin.getId());
		
		if(adminDb!=null) {
		adminDb.setFirstName(admin.getFirstName());
		adminDb.setLastName(admin.getLastName());
		adminDb.setEmail(admin.getEmail());
		adminDb.setMobile(admin.getMobile());
		adminDb.setPassword(admin.getPassword());
		
		transaction.begin();
	 	Admin adminUpdate = manager.merge(adminDb);
	 	transaction.commit();
	 	return adminUpdate;
		}
		return null;
	}


	public boolean deleteAdminById(int id) {
		transaction=manager.getTransaction();
		transaction.begin();
		Admin admin=manager.find(Admin.class, id);
		if(admin!=null) {
		manager.remove(admin);
		transaction.commit();
		return true;
		}
		return false;
	}


	public List<Hotel> getHotelByKeyWord(String keyword) {
		String jpql = "SELECT h FROM Hotel h WHERE CONCAT(h.id,' ', h.hotelName,' ', h.city, ' ', h.address) LIKE CONCAT('%', ?1, '%') ";
				
		
		Query query = manager.createQuery(jpql);
		query.setParameter(1, keyword);
		List<Hotel> hotels = query.getResultList();
		
		return hotels;
	}


	public List<BookingDetails> getAllBookingDetails() {
		String query="select b from BookingDetails b";
		Query selectQuery= manager.createQuery(query);
		List<BookingDetails> details= selectQuery.getResultList();
		System.out.println(details.get(1).getCustomer());
		if(details !=null) {
			return details;
		}
		return null;
	}
	

}
