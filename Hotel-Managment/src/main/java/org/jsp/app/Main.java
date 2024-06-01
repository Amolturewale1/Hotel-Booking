package org.jsp.app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.entity.Admin;
import org.jsp.entity.BookingDetails;
import org.jsp.entity.Customer;
import org.jsp.entity.Hotel;

public class Main {
	
	public static void main(String[] args) {
		EntityManagerFactory factory =Persistence.createEntityManagerFactory("hotel_booking");
		EntityManager manager=factory.createEntityManager();
//		EntityTransaction transaction =manager.getTransaction();
//		
//		Admin admin =new Admin();
//		admin.setFirstName("Ramesh");
//		admin.setLastName("Patil");
//		admin.setEmail("ramesh21@gmail.com");
//		admin.setMobile(9898989888l);
//		admin.setPassword("ramesh#123");
//		
//		Customer customer=new Customer();
//		customer.setFirstName("Sam");
//		customer.setLastName("johnson");
//		customer.setGender("Male");
//		customer.setEmail("sam45@gmail.com");
//		customer.setMobile(8554459874l);
//		customer.setPassword("1234");
//		
//		Hotel hotel =new Hotel();
//		hotel.setHotelName("ITC");
//		hotel.setMobile(2345896578l);
//		hotel.setCity("pune");
//		hotel.setAddress("Hadapsar");
//		hotel.setPrice(3000);
//		hotel.setTotalNoOfRoom(40);
//		hotel.setNoOfBookedRoom(1);
//		
//		
//		BookingDetails details=new BookingDetails();
//		details.setCustomer(customer);
//		details.setHotel(hotel);
//		details.setNoOfDays(1);
//		details.setNoOfPerson(1);
//		details.setNoOfRoom(1);
//		details.setTotalPrice(3000);
//		details.setStatus("Booked");
//		details.setStartDate(LocalDate.parse("2024-03-13"));
//		details.setEndDate(LocalDate.parse("2024-03-14"));
//		
//		transaction.begin();
//		
//		manager.persist(admin);
//		manager.persist(details);
//		transaction.commit();
	}


}
