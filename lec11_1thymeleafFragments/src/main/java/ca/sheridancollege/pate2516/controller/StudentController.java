package ca.sheridancollege.pate2516.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.pate2516.beans.Student;
import ca.sheridancollege.pate2516.database.DatabaseAccess;

@Controller
public class StudentController {

	@Autowired
	protected DatabaseAccess da;
	
	@GetMapping("/")
	public String getIndex(Model model) {
		
		model.addAttribute("studentList", da.findAll());
		Student student = new Student();
		student.setAdmin(true);
		model.addAttribute("student", student);
		return "index";
	}
	@PostMapping("/insertAppointment")
	public String postIndex(Model model, @ModelAttribute Student student) {
		
		da.save(student);
		model.addAttribute("studentList", da.findAll());
		model.addAttribute("student", new Student());
		return "index";
	}
	
}
