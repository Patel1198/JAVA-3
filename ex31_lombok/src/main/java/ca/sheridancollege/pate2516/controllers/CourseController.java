package ca.sheridancollege.pate2516.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ca.sheridancollege.pate2516.beans.Course;
import ca.sheridancollege.pate2516.repositories.CourseList;
import lombok.Builder;
@Controller
@Builder
public class CourseController {
	private CourseList courseList;
	@GetMapping("/")
	public String index(Model model) {
		System.out.println("Clearing List");
		courseList.emptyList();
		return "index";
	}
	@PostMapping("/processForm")
	public String processForm(@RequestParam String prefix,@RequestParam Long id,
			@RequestParam int code,@RequestParam String name) {
		Course course = new Course(id, prefix, code, name);
		courseList.getCourseList().add(course);
		System.out.println("***");
		for(Course c:courseList.getCourseList()) {
		System.out.println(c);	
		}
		return "working";
	}
}

