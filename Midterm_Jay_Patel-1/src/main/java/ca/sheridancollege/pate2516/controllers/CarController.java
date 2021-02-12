package ca.sheridancollege.pate2516.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.pate2516.beans.Car;
import ca.sheridancollege.pate2516.database.DatabaseAccess;

@Controller
public class CarController {


	@Autowired
	private DatabaseAccess d;
	
	@GetMapping("/")
	public String processIndex(Model model) {
		
		model.addAttribute("car", new Car());
		model.addAttribute("carList", d.getCars());
		
		return "index";
		
	}
	
	
	
	@PostMapping("/insertCar")
	public String insertCar(Model model, @ModelAttribute Car car) {  
		d.insertCar(car.getManufacturer(),car.getModel(), car.getYear(), car.getColour(),car.getPrice());
		
		model.addAttribute("car", new Car());
		model.addAttribute("carList", d.getCars());
		return "viewCarList";
		
	}
	
	@GetMapping("/deleteCarById/{carId}")
	public String deleteCarById(Model model,@PathVariable int carId) { 
	 	d.deleteCarById(carId);
		model.addAttribute("car", new Car());
		model.addAttribute("carList", d.getCars());
		return "addCar";
		
	}
	
	@GetMapping("/editCarById/{carId}")
	public String editCarById(Model model,@PathVariable int carId) {  
	  	Car car = d.getCarById(carId).get(0);
		model.addAttribute("car", car);
		model.addAttribute("carList", d.getCars());
		return "addCar";
		
	}
	
	@PostMapping("/modifyCar")
	public String modifyCar(Model model, @ModelAttribute Car car) { 
	  	d.updateCar(car);
		model.addAttribute("car", new Car());
		model.addAttribute("carList", d.getCars());
		return "viewCarList";
		
	}	
}
