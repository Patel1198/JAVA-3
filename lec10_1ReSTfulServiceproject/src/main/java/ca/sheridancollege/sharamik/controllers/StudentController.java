package ca.sheridancollege.sharamik.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.sharamik.beans.Student;
import ca.sheridancollege.sharamik.database.DatabaseAccess;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private DatabaseAccess da;
	
	@GetMapping
	public List<Student> getStudentCollection() {
	return da.findAll();
	}
	
	@GetMapping("/{id}")
	public Student getIndividualStudent(@PathVariable Long id) {
	return da.findById(id).get(0);
	}

	@PostMapping(consumes="application/json")
	public Long postStudent(@RequestBody Student student) {
	return da.save(student);
	}
	
	@PutMapping(consumes="application/json")
	public String putStudentCollection(@RequestBody List<Student> studentList) {
	da.deleteAll();
	da.saveAll(studentList);
	return "Total Records: " + da.count();
	}


}
