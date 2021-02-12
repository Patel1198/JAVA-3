package ca.sheridancollege.pate2516.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model, HttpSession session) {
		model.addAttribute("myName","Jay");
		session.setAttribute("myName", "Jay");
		session.setAttribute("sessionID", session.getId());
		if (session.isNew())
			session.setAttribute("sessionState", "New Session");
		else
			session.setAttribute("sessionState", "Welcome Back");
		//session.setMaxInactiveInterval(4);
		if(session.getAttribute("counter") == null)
			session.setAttribute("counter",1);
		else {
			int counter= (int) session.getAttribute("counter");
			counter++;
			session.setAttribute("counter",counter);
			}
		return "home";
		
	}
	
	@GetMapping("/test")
	public String test(Model model, HttpSession session) {
		return "home";
	}
}
