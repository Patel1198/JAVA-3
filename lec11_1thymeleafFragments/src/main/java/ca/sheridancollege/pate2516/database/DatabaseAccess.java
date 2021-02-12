package ca.sheridancollege.pate2516.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.pate2516.beans.Student;

@Repository
public class DatabaseAccess {

	@Autowired
	NamedParameterJdbcTemplate jdbc;
	
	public List<Student> findAll() {
		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
		String query = "SELECT * FROM student";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Student>(Student.class));
		}
	

	public Long save(Student student) {
		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
		KeyHolder generatedKeyHolder= new GeneratedKeyHolder();
		String query = "INSERT INTO student(name,appointmentDate,appointmentTime) VALUES(:name,:appointmentDate,:appointmentTime)";
		namedParameters.addValue("name", student.getName());
		namedParameters.addValue("appointmentDate", student.getAppointmentDate());
		namedParameters.addValue("appointmentTime", student.getAppointmentTime());
		jdbc.update(query, namedParameters, generatedKeyHolder);
		return (Long) generatedKeyHolder.getKey();
		}
}
