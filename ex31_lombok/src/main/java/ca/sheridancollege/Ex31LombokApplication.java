package ca.sheridancollege;

import static org.junit.Assert.assertEquals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ca.sheridancollege.pate2516.beans.Course;

@SpringBootApplication
public class Ex31LombokApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex31LombokApplication.class, args);
		Course course = new Course();
		course.setId((long) 991592044);
		course.setName("Java");
		course.setPrefix("Enterprise Java Development");
		course.setCode(24090);
		System.out.println(course);
	}

}
