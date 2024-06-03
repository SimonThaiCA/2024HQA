package com.rentcar.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentcar.entity.Vehicle;
import com.rentcar.repository.VehicleRepository;

@Service
public class VehicleService {
	@Autowired
	VehicleRepository vehicleRepository;
	 
	
	public void addVehicle(String model, int capacity, double ratePerDay, String licensePlate) {
		vehicleRepository.save(new Vehicle(model, capacity, ratePerDay, licensePlate)); 
	}

	public ArrayList<Vehicle> findAllVehicle() {
        return vehicleRepository.findAll();
    }
	public void deleteVehicleById(int id) {
		vehicleRepository.deleteById(id);
	}

	public Vehicle findVehicleUsingId(int id) {
		Vehicle vehicle = vehicleRepository.findById(id).get();
		return vehicle;
	}

	
	public void UpdateVehicleDetail(int id, String model, int capacity, double ratePerDay, String licensePlate) {
        Vehicle existingVehicle = vehicleRepository.findById(id).orElse(null);
        if (existingVehicle != null) {
            existingVehicle.setModel(model);
            existingVehicle.setCapacity(capacity);
            existingVehicle.setRatePerDay(ratePerDay);
            existingVehicle.setLicensePlate(licensePlate);
            vehicleRepository.save(existingVehicle);
        }
    }
}
