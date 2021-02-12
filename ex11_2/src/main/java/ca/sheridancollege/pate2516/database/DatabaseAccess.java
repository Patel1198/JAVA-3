package ca.sheridancollege.pate2516.database;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import ca.sheridancollege.pate2516.beans.Contact;

@Repository
public class DatabaseAccess {

	@Autowired
	NamedParameterJdbcTemplate jdbc;
	
	
	public void insertContact(String firstName,String lastName, Long phoneNumber,LocalDate appointmentDate, LocalDate birthday) {
		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
		namedParameters.addValue("firstName", firstName);
		namedParameters.addValue("lastName", lastName);
		namedParameters.addValue("phoneNumber", phoneNumber);
		namedParameters.addValue("appointmentDate", appointmentDate);
		namedParameters.addValue("birthday", birthday);
		String query="INSERT INTO contact(firstName,lastName,phoneNumber,appointmentDate,birthday) VALUES (:firstName,:lastName,:phoneNumber,:appointmentDate,:birthday)";
		int rowsAffected= jdbc.update(query, namedParameters);
		if (rowsAffected> 0) 
			System.out.println("Inserted contact into database.");
		}
	
	public List<Contact> getContact() {
		MapSqlParameterSource namedParameters= new  MapSqlParameterSource();
		String query = "SELECT * FROM contact";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Contact>(Contact.class));
		}

	public void updateContact(Contact contact) {
		

		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
		namedParameters.addValue("id", contact.getId() );
		namedParameters.addValue("firstName", contact.getFirstName());
		namedParameters.addValue("lastName", contact.getLastName());
		namedParameters.addValue("phoneNumber", contact.getPhoneNumber());
		namedParameters.addValue("appointmentDate", contact.getAppointmentDate());
		namedParameters.addValue("birthday", contact.getBirthday());
		String query="UPDATE contact SET firstName=:firstName, lastName=:lastName, phoneNumber=:phoneNumber, appointmentDate=:appointmentDate, birthday=:birthday WHERE id=:id";
		int rowsAffected= jdbc.update(query, namedParameters);
		if (rowsAffected> 0) 
			System.out.println("contact updated on the database.");
		}
	
	public void deleteContactById(Long id) {
		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
	String query = "DELETE FROM contact WHERE id = :id";
	namedParameters.addValue("id", id);
	int rowsAffected= jdbc.update(query, namedParameters);
	if (rowsAffected> 0)
		System.out.println("Deleted contact " + id + " from database");
	}
	
	public List<Contact> getContactListById(Long id) {
		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
		String query = "SELECT * FROM contact WHERE id = :id";
		namedParameters.addValue("id", id);
	return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Contact>(Contact.class));
	}

}

