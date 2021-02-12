package ca.sheridancollege.pate2516.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.pate2516.beans.Student;

@Repository
public class DatabaseAccess {

	@Autowired
	NamedParameterJdbcTemplate jdbc;
	
	public List<Student> getStudentList() {
		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
		String query = "SELECT * FROM student";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Student>(Student.class));
		}

	public void insertStudent(Student student) {
		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
		String query = "INSERT INTO student(name) VALUES(:name)";
		namedParameters.addValue("name", student.getName());
		jdbc.update(query, namedParameters);
		}


}
