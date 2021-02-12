package ca.sheridancollege.pate2516.beans;

import static org.junit.Assert.assertEquals;

public class CourseTest {
	public void buildCourse() {
		Course test = Course.builder().id(Long.valueOf(10)).prefix("").code(10).name("").build();
		assertEquals(test.getId(),Long.valueOf(10));
		assertEquals(test.getName(),"");
		assertEquals(test.getCode(),1);
		assertEquals(test.getPrefix(),"");
	}

}
