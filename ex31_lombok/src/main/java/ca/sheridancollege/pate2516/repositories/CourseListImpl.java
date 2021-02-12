package ca.sheridancollege.pate2516.repositories;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

import ca.sheridancollege.pate2516.beans.Course;
import lombok.Data;


@Component
@Data
public class CourseListImpl implements CourseList {
	private List<Course> courseList = new CopyOnWriteArrayList<Course>();

	public void emptyList() {
		courseList.clear();
	}
	}
