package com.everis.alicante.becajava.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookingDto {
	
	
	private int idbooking;

	private Date bookingdate;
	
	private String client;
		
	private int parkingplace;

	private String vehicle;

	public int getIdbooking() {
		return idbooking;
	}

	public void setIdbooking(int idbooking) {
		this.idbooking = idbooking;
	}

	public Date getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(Date bookingdate) {
		this.bookingdate = bookingdate;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}
	
	public int getParkingplace() {
		return parkingplace;
	}

	public void setParkingplace(int parkingplace) {
		this.parkingplace = parkingplace;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	
	
	

}
