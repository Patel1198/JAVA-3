package ca.sheridancollege.pate2516.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ca.sheridancollege.pate2516.beans.Student;
@Controller
public class StudentController {
@GetMapping("/")
	public String processRequest(Model model) {
	model.addAttribute("ServerDate",LocalDate.now());	
	return "index";
	}
@GetMapping("/getStudent")
public String getStudent(Model model) {
	
	Student s = new Student();
	s.setId(Long.valueOf(1));
	s.setName("Jay");
	model.addAttribute("myStudent",s);
	return "getStudent";	

}
@GetMapping("/getStudentList")
public String getStudentList(Model model) {
	List<Student> students = new CopyOnWriteArrayList<Student>();
	students.add(new Student(Long.valueOf(1), "Frank"));
	students.add(new Student(Long.valueOf(2), "Sally"));
	students.add(new Student(Long.valueOf(3), "Angela"));
	model.addAttribute("studentList", students);
	return "getStudentList";
}
}
