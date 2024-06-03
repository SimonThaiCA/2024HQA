package com.rentcar.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rentcar.entity.Vehicle;
import com.rentcar.service.VehicleService;

@Controller
public class VehicleController {

	@Autowired
	VehicleService vehicleService;

	@RequestMapping("index")
	public String gotoHomePage() {
		return "index";
	}

	@RequestMapping("manageVehicle")
	public String gotoManageVehiclePage(ModelMap modelMap) {
		ArrayList<Vehicle> vehicleList = vehicleService.findAllVehicle();
		modelMap.put("vehicles", vehicleList);
		return "manageVehicle";
	}

	@RequestMapping(value = "addVehicle", method = RequestMethod.GET)
	public String addNewVehicle() {
		return "addVehicle";
	}

	@RequestMapping(value = "/addVehicle", method = RequestMethod.POST)
	public String addNewVehiclePost(@RequestParam String model, @RequestParam int capacity,
			@RequestParam double ratePerDay, @RequestParam String licensePlate, ModelMap modelMap) {
		vehicleService.addVehicle(model, capacity, ratePerDay, licensePlate);
		return "redirect:manageVehicle";
	}

	@RequestMapping(value = "/deleteVehicle")
	public String deleteVehicle(@RequestParam int id) {
		vehicleService.deleteVehicleById(id);
		return "redirect:manageVehicle";
	}
	
	@RequestMapping(value = "updateVehicle",method = RequestMethod.GET)
	public String UpdateVehicle(@RequestParam int id,ModelMap modelMap) {
		Vehicle vehicle = vehicleService.findVehicleUsingId(id);
		modelMap.put("vehicle", vehicle);
		return "updateVehicle";
	}
	@RequestMapping(value = "updateVehicle",method = RequestMethod.POST)
	public String UpdateVehiclePost(@RequestParam int id, @RequestParam String model, @RequestParam int capacity,
			@RequestParam double ratePerDay, @RequestParam String licensePlate, ModelMap modelMap) {
		vehicleService.UpdateVehicleDetail(id, model, capacity, ratePerDay, licensePlate);
		return "redirect:manageVehicle";
	}
}
