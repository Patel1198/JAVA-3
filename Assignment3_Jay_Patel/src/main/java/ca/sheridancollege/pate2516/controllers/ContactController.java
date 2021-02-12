package ca.sheridancollege.pate2516.controllers;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import ca.sheridancollege.pate2516.beans.Contact;

import ca.sheridancollege.pate2516.database.DatabaseAccess;

@Controller
public class ContactController {

	@Autowired
	@Lazy
	private DatabaseAccess da;

	
	@GetMapping("/")
	public String index() {
	return "home";
	}

	@GetMapping("/secure/AddContact")
	public String secureIndex(Model model, Authentication authentication) {
		String email = authentication.getName();
		List<String> roleList= new ArrayList<String>();
		for (GrantedAuthority ga: authentication.getAuthorities()) {
			roleList.add(ga.getAuthority());
		}
		model.addAttribute("email", email);		

		model.addAttribute("contact", new Contact());
		model.addAttribute("contactList", da.getContact());

	return "/secure/AddContact";
	}
	

	
	@GetMapping("/login")
	public String login() {
	return "/login";
	}
	
	@GetMapping("/permission_denied")
	public String permissionDenied() {
	return "/error/permission_denied";
	}

	@GetMapping("/register")
	public String getRegister(Model model) {
		model.addAttribute("contact", new Contact());
		return "register";
	}
	@PostMapping("/register")
	public String postRegister(@RequestParam String email, @RequestParam String encryptedPassword,@RequestParam String role) {
		da.addUser(email, encryptedPassword,role);
		
		return "redirect:/";
	}
	@GetMapping("/secure/ListContacts")
	public String secureIx(Model model, Authentication authentication) {	
		model.addAttribute("contactList", da.getContact());

	return "/secure/ListContacts";
	}
	
	@GetMapping("/editContactById/{id}")
	public String editContactById(Model model,@PathVariable int id) {
		Contact contact = da.getContactsListById(id).get(0);
		model.addAttribute("contact", contact);
		model.addAttribute("contactList", da.getContact());

	return "/secure/updatedContact";
	}
	
	@GetMapping("/deleteContactById/{id}")
	public String deleteContactById(Model model,@PathVariable int id, Authentication authentication) {
		String email = authentication.getName();
	
		da.deleteContactById(id);
		
		
		model.addAttribute("email", email);
		model.addAttribute("contact", new Contact());
		model.addAttribute("contactList", da.getContact());

	return "/secure/ListContacts";
	}

	@PostMapping("/modifyContact")
	public String modifyContact(Model model, @ModelAttribute Contact contact) {  //ModelAttribute
	  	da.updateConatct (contact);
	  	
	
		model.addAttribute("contact", new Contact());
		
		model.addAttribute("contactList", da.getContact());
		return "/secure/ListContacts";
		
	}
}
