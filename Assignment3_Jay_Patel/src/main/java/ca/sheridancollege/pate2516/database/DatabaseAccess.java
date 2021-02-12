package ca.sheridancollege.pate2516.database;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.pate2516.beans.Contact;




@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public void addContact(Contact contact,String password) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "INSERT INTO contacts" 
			+ "(name, phoneNumber, address, email,role,encryptedPassword)" 
			+ " VALUES ( :name, :phoneNumber, :address, :email,:role,:encryptedPassword)" ;
	
		namedParameters.addValue("name", contact.getName());
		namedParameters.addValue("phoneNumber",contact.getPhoneNumber());
		namedParameters.addValue("address",contact.getAddress());
		namedParameters.addValue("email", contact.getEmail());
		namedParameters.addValue("role", contact.getRole());
		namedParameters.addValue("encryptedPassword", passwordEncoder.encode(password));
		int rowsAffected= jdbc.update(query, namedParameters);
		if (rowsAffected> 0) 
			System.out.println("Contact is successfully inserted into database.");
		}

	
	public List<String> getContactById(int id) {
		ArrayList<String> roles = new ArrayList<String>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM contacts WHERE id = :id";
		String query2 = "SELECT * FROM users WHERE userId = :userId";
		parameters.addValue("id", id);
		
		parameters.addValue("userId", id);
		
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		List<Map<String, Object>> row2 = jdbc.queryForList(query2, parameters);
		if (rows.size()>0) {
			for (Map<String, Object> row : rows) {
				roles.add((String)row.get("role"));
				
				}
		}else if(row2.size()>0) {
			for (Map<String, Object> row : row2) {
				roles.add((String)row.get("role"));
				
				}
		}
		
		
		return roles;
		
	}
	public List<Contact> getContact() {
		MapSqlParameterSource namedParameters= new  MapSqlParameterSource();
		String query = "SELECT * FROM contacts";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Contact>(Contact.class));
		}

	public void addUser(String email,String encryptedPassword,String role) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO users" 
			+ "( email, role, encryptedPassword)" 
			+ " VALUES ( :email, :role,:encryptedPassword)";
		parameters.addValue("email", email);
		parameters.addValue("role", role);
		parameters.addValue("encryptedPassword", passwordEncoder.encode(encryptedPassword));
		
		jdbc.update(query, parameters);
	}
	
	public Contact findContact(String email) { 
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM users where email=:email";
		String query2 = "SELECT * FROM contacts where email=:email	";
		parameters.addValue("email", email);
	
	
		ArrayList<Contact> users = (ArrayList<Contact>)jdbc.query(query, parameters,
				new BeanPropertyRowMapper<Contact>(Contact.class));
		ArrayList<Contact> contacts = (ArrayList<Contact>)jdbc.query(query2, parameters,
				new BeanPropertyRowMapper<Contact>(Contact.class));
		if (users.size()>0) {
			System.out.println("456"+ users);
			return users.get(0);}
		else if(contacts.size()>0) {
			System.out.println(contacts);
			return contacts.get(0);}
		else
			return null;
		
	}
	
	public void deleteContactById(int id) {
		
		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
		namedParameters.addValue("id", id);
		String query="DELETE FROM contacts WHERE id=:id";
		int rowsAffected= jdbc.update(query, namedParameters);
		if (rowsAffected> 0) 
			System.out.println("Contact is successfully deleted from the database.");
		}

 public void updateConatct(Contact contact) {
		
		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
		namedParameters.addValue("id", contact.getId() );
		namedParameters.addValue("name", contact.getName());
		namedParameters.addValue("phoneNumber",contact.getPhoneNumber());
		namedParameters.addValue("address",contact.getAddress());
		namedParameters.addValue("email", contact.getEmail());
		namedParameters.addValue("role", contact.getRole());
		
		String query="UPDATE contacts SET name =:name," + 
				"phoneNumber= :phoneNumber, address=:address, email=:email, role=:role WHERE id=:id";
		int rowsAffected= jdbc.update(query, namedParameters);
		
		if (rowsAffected> 0) 
			System.out.println("Contact info got updated on the database.");
		}
	public List<Contact> getContactsListById(int id) {
		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
		String query = "SELECT * FROM contacts WHERE id = :id";
		namedParameters.addValue("id", id);
	return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Contact>(Contact.class));
	}


	public List<Contact> findAll() {
		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
		String query = "SELECT * FROM contacts";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Contact>(Contact.class));
		}


	public Long save(Contact contact) {
		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
		KeyHolder generatedKeyHolder= new GeneratedKeyHolder();
		String query = "INSERT INTO contacts" 
				+ "(name, phoneNumber, address, email,role)" 
				+ " VALUES ( :name, :phoneNumber, :address, :email,:role)" ;
		namedParameters.addValue("name", contact.getName());
		namedParameters.addValue("phoneNumber",contact.getPhoneNumber());
		namedParameters.addValue("address",contact.getAddress());
		namedParameters.addValue("email", contact.getEmail());
		namedParameters.addValue("role", contact.getRole());
		jdbc.update(query, namedParameters, generatedKeyHolder);
		return (Long) generatedKeyHolder.getKey();
		}


	public void deleteAll() {
		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
		String query = "DELETE FROM contacts";
		jdbc.update(query, namedParameters);
		}
		public Long count() {
		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
		String query = "SELECT count(*) FROM contacts";
		return jdbc.queryForObject(query, namedParameters, Long.TYPE);
		}

		public void saveAll(List<Contact> contactList) {
			for (Contact s : contactList) {
				save(s);
			}
		}

		public List<Contact> findById(int id) {
			MapSqlParameterSource namedParameters= new MapSqlParameterSource();
			String query = "SELECT * FROM contacts WHERE id = :id";
			namedParameters.addValue("id", id);
			return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Contact>(Contact.class));
			}
 
}
