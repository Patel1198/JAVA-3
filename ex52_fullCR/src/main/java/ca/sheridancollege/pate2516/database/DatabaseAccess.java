package ca.sheridancollege.pate2516.database;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.pate2516.beans.Appointment;



@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public void insertAppointment() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query="INSERT INTO appointment(firstName) VALUES ('Patel')";
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected> 0)
			System.out.println("Inserted appointment into databse.");
	}
	public void insertAppointment(String firstName,String email, LocalDate appointmentDate, LocalTime appointmentTime) {
		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
		namedParameters.addValue("firstName", firstName);
		namedParameters.addValue("email", email);
		namedParameters.addValue("appointmentDate", appointmentDate);
		namedParameters.addValue("appointmentTime", appointmentTime);
		String query="INSERT INTO appointment(firstName,email,appointmentDate,appointmentTime) VALUES (:firstName,:email,:appointmentDate,:appointmentTime)";
		int rowsAffected= jdbc.update(query, namedParameters);
		if (rowsAffected> 0) 
			System.out.println("Inserted appointment into database.");
		}
	
	public List<Appointment> getAppointment() {
		MapSqlParameterSource namedParameters= new  MapSqlParameterSource();
		String query = "SELECT * FROM appointment";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Appointment>(Appointment.class));
		}

	public void updateStudent(Appointment appointment) {
		

		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
		namedParameters.addValue("id", appointment.getId() );
		namedParameters.addValue("firstName", appointment.getFirstName());
		namedParameters.addValue("email", appointment.getEmail());
		namedParameters.addValue("appointmentDate", appointment.getAppointmentDate());
		namedParameters.addValue("appointmentTime", appointment.getAppointmentTime());
		String query="UPDATE appointment SET firstName=:firstName, email=:email, appointmentDate=:appointmentDate, appointmentTime=:appointmentTime WHERE id=:id";
		int rowsAffected= jdbc.update(query, namedParameters);
		if (rowsAffected> 0) 
			System.out.println("appointment updated on the database.");
		}
	
	public void deleteAppointmentById(Long id) {
		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
	String query = "DELETE FROM appointment WHERE id = :id";
	namedParameters.addValue("id", id);
	int rowsAffected= jdbc.update(query, namedParameters);
	if (rowsAffected> 0)
		System.out.println("Deleted appointment " + id + " from database");
	}
	
	public List<Appointment> getAppointmentListById(Long id) {
		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
		String query = "SELECT * FROM appointment WHERE id = :id";
		namedParameters.addValue("id", id);
	return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Appointment>(Appointment.class));
	}

}
