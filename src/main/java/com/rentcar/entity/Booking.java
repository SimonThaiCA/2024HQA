package com.rentcar.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;

	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "customerId")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "vehicle_id", referencedColumnName = "vehicleId")
	private Vehicle vehicle;

//	private int customerId;
//	private int vehicleId;
	private LocalDate startDate;
	private LocalDate endDate;
	private double totalCost;

	public Booking() {

	}
//	public Booking(int customerId, int vehicleId, LocalDate startDate, LocalDate endDate, double totalCost) {
//		super();
//		this.customerId = customerId;
//		this.vehicleId = vehicleId;
//		this.startDate = startDate;
//		this.endDate = endDate;
//		this.setTotalCost(totalCost);
//	}

	public Booking(Customer customer, Vehicle vehicle, LocalDate startDate, LocalDate endDate, double totalCost) {
		super();
		this.setCustomer(customer);
		this.setVehicle(vehicle);
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalCost = totalCost;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

//	public int getCustomerId() {
//		return customerId;
//	}
//
//	public void setCustomerId(int customerId) {
//		this.customerId = customerId;
//	}
//
//	public int getVehicleid() {
//		return vehicleId;
//	}
//
//	public void setVehicleid(int vehicleId) {
//		this.vehicleId = vehicleId;
//	}

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

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
