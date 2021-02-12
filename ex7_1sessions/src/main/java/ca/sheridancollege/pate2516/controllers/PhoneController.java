package ca.sheridancollege.pate2516.controllers;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.pate2516.beans.Phone;

@Controller
public class PhoneController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("phone", new Phone());
		return "index";
	}
	
	@PostMapping("/insertPhone")
	public String insertPhone(HttpSession session, Model model, @ModelAttribute Phone phone) {
		List<Phone> phoneList;
		if (session.isNew()) 
			phoneList= new ArrayList<Phone>();
		else 
			phoneList= 
			(ArrayList<Phone>)session.getAttribute("phoneList");
		phoneList.add(phone);
		session.setAttribute("phoneList", phoneList);
		model.addAttribute("phone", new Phone());
		return "index";
	}
}
