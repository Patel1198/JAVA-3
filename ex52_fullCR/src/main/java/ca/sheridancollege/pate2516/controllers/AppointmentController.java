package ca.sheridancollege.pate2516.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.pate2516.beans.Appointment;
import ca.sheridancollege.pate2516.database.DatabaseAccess;

@Controller
public class AppointmentController {

	@Autowired
	private DatabaseAccess da;

	@GetMapping("/")
	public String processIndex(Model model) {	
		model.addAttribute("appointment", new Appointment());
		model.addAttribute("appointmentList", da.getAppointment());
		
		return "index";
		
	}
	
	@PostMapping("/insertAppointment")
	public String insertAppointment(Model model, @ModelAttribute Appointment appointment) {  //ModelAttribute
		da.insertAppointment(appointment.getFirstName(),appointment.getEmail(),appointment.getAppointmentDate(),appointment.getAppointmentTime());
		model.addAttribute("appointment", new Appointment());
		model.addAttribute("appointmentList", da.getAppointment());
		return "index";
		
	}
	
	@GetMapping("/deleteAppointmentById/{id}")
	public String deleteAppointmentById(Model model,@PathVariable Long id) {  //ModelAttribute
	 	da.deleteAppointmentById(id);
		model.addAttribute("appointment", new Appointment());
		model.addAttribute("appointmentList", da.getAppointment());
		return "index";
		
	}
	
	
	@GetMapping("/editAppointmentById/{id}")
	public String editAppointmentById(Model model,@PathVariable Long id) {  //ModelAttribute
		Appointment appointment = da.getAppointmentListById(id).get(0);
		model.addAttribute("appointment", appointment);
		model.addAttribute("appointmentList", da.getAppointment());
		return "appointment";
		
	}
	@PostMapping("/modifyAppointment")
	public String modifyAppointment(Model model, @ModelAttribute Appointment appointment) {  //ModelAttribute
	  	da.updateStudent (appointment);
		model.addAttribute("appointment", new Appointment());
		model.addAttribute("appointmentList", da.getAppointment());
		return "index";
		
	}
}
