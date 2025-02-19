package ca.sheridancollege.pate2516.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ca.sheridancollege.pate2516.beans.Contact;
import ca.sheridancollege.pate2516.database.DatabaseAccess;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	@Lazy
	private DatabaseAccess da;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
				ca.sheridancollege.pate2516.beans.Contact user = da.findContact(username);
		
				if (user == null) {
					System.out.println("User not found:" + username);
					throw new UsernameNotFoundException("User " + username + " was not found in the database");
					}
				//Get a list of roles for that user
				int tempId = 0;
				if(user.getUserId()!=0) {
					tempId = user.getUserId();
				}else {
					
					tempId = user.getId();
				}
				
			
				List<String> roleNames= da.getContactById(tempId);
				System.out.println(roleNames);
				// Change the list of the user's roles into a list of GrantedAuthority
				List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
				if (roleNames!= null) {
					for (String role : roleNames) {
						grantList.add(new SimpleGrantedAuthority(role));
						
						}
					}
				// Create a user based on the information above.
				UserDetails userDetails= (UserDetails) new User(user.getEmail(), 
				user.getEncryptedPassword(), grantList);
				return userDetails;
	}
	
				


	
	}
