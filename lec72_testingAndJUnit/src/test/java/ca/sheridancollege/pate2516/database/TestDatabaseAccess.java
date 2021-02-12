package ca.sheridancollege.pate2516.database;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.sheridancollege.pate2516.beans.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class TestDatabaseAccess {

	@Autowired
	private DatabaseAccess da;
	
	@Test
	public void whenInsertStudent_getStudents() {
		
		// setup
		Student student= new Student();
		student.setName("Jay");
		// when
		da.insertStudent(student);
		// then (the actual test!)
		Assert.assertTrue(da.getStudents().size() > 0);
		Assert.assertFalse(da.getStudents().size()<0);
	}
}

