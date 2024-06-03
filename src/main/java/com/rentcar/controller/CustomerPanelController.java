package com.rentcar.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rentcar.entity.Booking;
import com.rentcar.entity.Vehicle;
import com.rentcar.service.BookingService;
import com.rentcar.service.VehicleService;

@Controller
public class CustomerPanelController {
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	BookingService bookingService;
	
	
	@RequestMapping("home")
	public String customerHomePage() {
		return "home";
	}
	@RequestMapping("bookingVehicle")
	public String bookingVehiclePage(ModelMap modelMap) {
		ArrayList<Vehicle> vehicleList = vehicleService.findAllVehicle();
		modelMap.put("vehicleList", vehicleList);
		return "bookingVehicle";
	}
	
	@RequestMapping(value = "bookingVehicleNextPage", method= RequestMethod.GET)
	public String bookingVehicleNextPage(@RequestParam int id,ModelMap modelMap) {
		Vehicle vehicle = vehicleService.findVehicleUsingId(id);
		modelMap.put("vehicle", vehicle);
		return "bookingVehicleNextPage";
	}
	
	@RequestMapping(value = "bookingVehicleNextPage", method= RequestMethod.POST)
	public String bookingVehicleNextPagePost(@RequestParam int id,@RequestParam LocalDate startDate,@RequestParam LocalDate endDate,ModelMap modelMap) {
		Vehicle vehicle = vehicleService.findVehicleUsingId(id);
		double totalCost = bookingService.addBookingDetail(1,id,startDate,endDate,vehicle.getRatePerDay());
		modelMap.put("totalCost", totalCost);
		return "bookingDone";
	}
	
	@RequestMapping("bookings")
	public String displayBookingDetails(ModelMap modelMap) {
		ArrayList<Booking> bookingList = bookingService.findAllBookingByCustomerId(1);
		
		modelMap.put("bookingList", bookingList);
		return "displayBooking";
	}
	
	@RequestMapping("userAccount")
	public String displayCustomerAccount() {
		return "customerDetail";
	}
}
