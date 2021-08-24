package ca.sheridancollege.pate2516.beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Contact {

	private int id;
	private int userId;
	private String name;
	private Long phoneNumber;
	
	private String address;
	@NonNull 
	private String email;
	
	private String role;
	@NonNull 
	private String encryptedPassword;
	
	
	private final String[] roles = {"ROLE_ADMIN", "ROLE_GUEST", "ROLE_USER"}; 
	
}

