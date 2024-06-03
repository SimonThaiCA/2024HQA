package com.rentcar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentcar.entity.Customer;
import com.rentcar.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;


	public  int addCustomerDetail(String firstname, String lastname, String phoneNo, String gender,
			String drivingLicenseNo) {
		Customer customer = new Customer(firstname, lastname,  phoneNo,  gender,  drivingLicenseNo);
		customerRepository.save(customer);
		return customer.getCustomerId();
	}

	public boolean isDrivingLicenseNoExists(String drivingLicenseNo) {
		return customerRepository.findByDrivingLicenseNo(drivingLicenseNo).isPresent();
	}

}
