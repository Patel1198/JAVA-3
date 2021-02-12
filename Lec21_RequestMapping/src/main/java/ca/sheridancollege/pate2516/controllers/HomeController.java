package ca.sheridancollege.pate2516.controllers;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.pate2516.beans.Student;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index() 
	{
		return "index";
	}
@PostMapping("/formPost")
	public String formPost(@RequestParam String fName,@RequestParam String lName,
			@RequestParam String email,@RequestParam Long SID,@DateTimeFormat(iso=DateTimeFormat.ISO.DATE) @RequestParam LocalDate DOB) {
	Student std = new Student();
	std.setfName(fName);
	std.setlName(lName);
	std.setSID(SID);
	std.setDOB(DOB);
	std.setEmail(email);
	System.out.print(std);
	
		return "working";
	}
}
