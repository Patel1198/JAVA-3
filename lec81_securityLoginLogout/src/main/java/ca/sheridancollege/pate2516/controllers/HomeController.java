package ca.sheridancollege.pate2516.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
	return "index";	
	}

	@GetMapping("/check")
	public String check() {
	return "check";	
	}
}
