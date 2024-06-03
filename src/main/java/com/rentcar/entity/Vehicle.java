package com.rentcar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicleId;
	private String model;
	private int capacity;
	private double ratePerDay;
	private String licensePlate;
	
	public Vehicle() {
		
	}
	
	public Vehicle(int vehicleId, String model, int capacity, double ratePerDay, String licensePlate) {
		super();
		this.vehicleId = vehicleId;
		this.model = model;
		this.capacity = capacity;
		this.ratePerDay = ratePerDay;
		this.licensePlate = licensePlate;
	}

	public Vehicle(String model, int capacity, double ratePerDay, String licensePlate) {
		super();
		this.model = model;
		this.capacity = capacity;
		this.ratePerDay = ratePerDay;
		this.licensePlate = licensePlate;
	}
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public double getRatePerDay() {
		return ratePerDay;
	}
	public void setRatePerDay(double ratePerDay) {
		this.ratePerDay = ratePerDay;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", model=" + model + ", capacity=" + capacity + ", ratePerDay="
				+ ratePerDay + ", LicensePlate=" + licensePlate + "]";
	}
	
	
}
