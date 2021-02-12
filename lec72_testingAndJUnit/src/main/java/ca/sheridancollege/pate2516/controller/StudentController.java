package ca.sheridancollege.pate2516.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.pate2516.beans.Student;
import ca.sheridancollege.pate2516.database.DatabaseAccess;




@Controller
public class StudentController {
	
	
	@Autowired
	private DatabaseAccess da;

	@GetMapping("/")
	public String processIndex(Model model) {
		
		// da.insertStudent();

		
		model.addAttribute("student", new Student());
		model.addAttribute("studentList", da.getStudents());
		
		return "index";
		
	}
	
	@PostMapping("/insertStudent")
	public String insertStudent(Model model, @ModelAttribute Student student) {  //ModelAttribute
		da.insertStudent(student);
		model.addAttribute("student", new Student());
		model.addAttribute("studentList", da.getStudents());
		return "index";
		
	}
	
	@GetMapping("/deleteStudentById/{id}")
	public String deleteStudentById(Model model,@PathVariable Long id) {  //ModelAttribute
	 	da.deleteStudentById(id);
		model.addAttribute("student", new Student());
		model.addAttribute("studentList", da.getStudents());
		return "index";
		
	}
	
	
	@GetMapping("/editStudentById/{id}")
	public String editStudentById(Model model,@PathVariable Long id) {  //ModelAttribute
	  	Student student = da.getStudentById(id).get(0);
		model.addAttribute("student", student);
		model.addAttribute("studentList", da.getStudents());
		return "update";
		
	}
	
	@PostMapping("/modifyStudent")
	public String modifyStudent(Model model, @ModelAttribute Student student) {  //ModelAttribute
	  	da.updateStudent (student);
		model.addAttribute("student", new Student());
		model.addAttribute("studentList", da.getStudents());
		return "index";
		
	}


}
