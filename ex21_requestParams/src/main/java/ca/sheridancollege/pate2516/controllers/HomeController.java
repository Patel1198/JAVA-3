package ca.sheridancollege.pate2516.controllers;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ca.sheridancollege.pate2516.beans.Appointment;

@Controller
public class HomeController {
@GetMapping("/")
	public String index() {
	return "index"; 
}
@PostMapping("/formPost")
public String formPost(@RequestParam String firstName,@RequestParam String email,
		@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
@RequestParam LocalDate appointmentDate,@DateTimeFormat(iso=DateTimeFormat.ISO.TIME)
@RequestParam LocalTime appointmentTime) {
	
	Appointment appointment = new Appointment();
	appointment.setFirstName(firstName);
	appointment.setEmail(email);
	appointment.setAppointmentDate(appointmentDate);
	appointment.setAppointmentTime(appointmentTime);
	System.out.print(appointment);
	return "working";
} 
}
