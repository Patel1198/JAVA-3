package ca.sheridancollege.pate2516.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ca.sheridancollege.pate2516.beans.Contact;
import ca.sheridancollege.pate2516.database.DatabaseAccess;


@RequestMapping("/contacts")
public class RestController {

	@Autowired
	private DatabaseAccess da;
	
	@GetMapping
	public List<Contact> getStudentCollection() {
	return da.findAll();
	}
	
	@GetMapping("/{id}")
	public Contact getIndividualContact(@PathVariable int id) {
	return da.findById(id).get(0);
	}

	@PostMapping(consumes="application/json")
	public Long postContact(@RequestBody Contact contact) {
	return da.save(contact);
	}
	
	@PutMapping(consumes="application/json")
	public String putContactCollection(@RequestBody List<Contact> contactList) {
	da.deleteAll();
	da.saveAll(contactList);
	return "Total Records: " + da.count();
	}


}
