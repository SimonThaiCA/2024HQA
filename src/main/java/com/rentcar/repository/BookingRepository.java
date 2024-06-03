package com.rentcar.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentcar.entity.Booking;
import com.rentcar.entity.Customer;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	ArrayList<Booking> findAll();
	

	ArrayList<Booking> findByCustomer(Customer customer);
	
}
