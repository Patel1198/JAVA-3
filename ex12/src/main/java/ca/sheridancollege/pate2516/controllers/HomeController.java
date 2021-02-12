package ca.sheridancollege.pate2516.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
@GetMapping("/")
	public String index() {
		return "index";
	}
@GetMapping("/MyInfo")
public String MyInfo() {
	return "MyInfo";
}
@GetMapping("/Quote")
public String Quote() {
	return "Quote";
}
@GetMapping("/FavImg")
public String FavImg() {
	return "FavImg";
}
}
