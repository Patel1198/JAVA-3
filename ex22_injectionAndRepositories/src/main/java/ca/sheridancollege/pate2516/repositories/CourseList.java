package ca.sheridancollege.pate2516.repositories;

import java.util.List;

import ca.sheridancollege.pate2516.beans.Course;

public interface CourseList {
	public List<Course>getCourseList();
	public void setCourseList(List<Course>courseList);
	public void emptyList();
}
