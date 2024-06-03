package com.rentcar.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentcar.entity.Booking;
import com.rentcar.entity.Customer;
import com.rentcar.entity.Vehicle;
import com.rentcar.repository.BookingRepository;
import com.rentcar.repository.CustomerRepository;
import com.rentcar.repository.VehicleRepository;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	public double addBookingDetail(int customerId, int vehicleId, LocalDate startDate, LocalDate endDate, double ratePerDay) {
		double totalCost = calculateTotalCost(startDate,endDate,ratePerDay);
		Customer customer = customerRepository.findById(customerId).get();
		Vehicle vehicle = vehicleRepository.findById(vehicleId).get();
		Booking booking = new Booking(customer, vehicle, startDate, endDate, totalCost);
		bookingRepository.save(booking);
		return totalCost;
	}
	
	public ArrayList<Booking> findAllBookingByCustomerId(int customerId) {
		Customer customer = customerRepository.findById(customerId).get();
        ArrayList<Booking> bookingList = bookingRepository.findByCustomer(customer);
        return bookingList;
    }
	
	private double calculateTotalCost(LocalDate startDate, LocalDate endDate, double ratePerDay) {
		long numberOfDays = startDate.until(endDate).getDays();
		return ratePerDay*numberOfDays;
	}


	
}
