package ca.sheridancollege.pate2516.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
	return "index";
	}

	@GetMapping("/secure")
	public String secureIndex() {
	return "/secure/index";
	}

	@GetMapping("/login")
	public String login() {
	return "login";
	}

	@GetMapping("/permission_denied")
	public String permissionDenied() {
	return "/error/permission_denied";
	}

	@GetMapping("/secure/check")
	public String check() {
	return "/secure/check";	
	}
	
}
