package ca.sheridancollege.pate2516.controllers;

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
		
		model.addAttribute("student", new Student());
		model.addAttribute("studentList", da.getStudentList());
		return "index";
	} 
	
	@PostMapping("/insertStudent")
	public String postIndex(Model model, @ModelAttribute Student student) {
		
		model.addAttribute("student", new Student());
		da.insertStudent(student);
		model.addAttribute("studentList", da.getStudentList());
		return "index";
	} 
}
