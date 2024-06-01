package org.jsp.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Cacheable
public class BookingDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bookingId")
	@SequenceGenerator(name = "bookingId" , sequenceName = "bookingIdsequence" ,
								initialValue = 1001, allocationSize = 2)
	private int id;
	
	//save to current time
	@CreationTimestamp
	@Column(name = "booking_date_time")
	private LocalDateTime bookingDateTime;
	
	@Column(name = "no_of_days")
	private int noOfDays;
	
	@Column(name = "no_of_persons")
	private int noOfPerson;
	
	@Column(name = "no_of_roomsS")
	private int noOfRoom;
	
	@Column(name = "total_price")
	private double totalPrice;

	private String status;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;
	
	@ManyToOne
	@JoinColumn(name = "card_id")
	private Card card;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getBookingDateTime() {
		return bookingDateTime;
	}

	public void setBookingDateTime(LocalDateTime bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public int getNoOfPerson() {
		return noOfPerson;
	}

	public void setNoOfPerson(int noOfPerson) {
		this.noOfPerson = noOfPerson;
	}

	public int getNoOfRoom() {
		return noOfRoom;
	}

	public void setNoOfRoom(int noOfRoom) {
		this.noOfRoom = noOfRoom;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
	
	
	
}
