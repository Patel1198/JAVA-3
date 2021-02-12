package ca.sheridancollege.pate2516.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.pate2516.beans.Contact;
import ca.sheridancollege.pate2516.database.DatabaseAccess;

@Controller
public class ContactController {

	@Autowired
	protected DatabaseAccess da;
	
	@GetMapping("/")
	public String processIndex(Model model) {	
		model.addAttribute("contact", new Contact());
		model.addAttribute("contactList", da.getContact());
		
		return "index";
		
	}
	
	@PostMapping("/insertContact")
	public String insertContact(Model model, @ModelAttribute Contact contact) {  //ModelAttribute
		da.insertContact(contact.getFirstName(),contact.getLastName(),contact.getPhoneNumber(),contact.getAppointmentDate(),contact.getBirthday());
		model.addAttribute("contact", new Contact());
		model.addAttribute("contactList", da.getContact());
		return "index";
		
	}
	
	@GetMapping("/deleteContactById/{id}")
	public String deleteContactById(Model model,@PathVariable Long id) {  //ModelAttribute
	 	da.deleteContactById(id);
		model.addAttribute("contact", new Contact());
		model.addAttribute("contactList", da.getContact());
		return "index";
		
	}
	
	
	@GetMapping("/editContactById/{id}")
	public String editContactById(Model model,@PathVariable Long id) {  //ModelAttribute
		Contact contact = da.getContactListById(id).get(0);
		model.addAttribute("contact", contact);
		model.addAttribute("contactList", da.getContact());
		return "contact";
		
	}
	@PostMapping("/modifyContact")
	public String modifyContact(Model model, @ModelAttribute Contact contact) {  //ModelAttribute
	  	da.updateContact (contact);
		model.addAttribute("contact", new Contact());
		model.addAttribute("contactList", da.getContact());
		return "index";
		
	}
}
