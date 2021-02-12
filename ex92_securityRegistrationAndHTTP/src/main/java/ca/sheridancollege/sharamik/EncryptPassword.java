package ca.sheridancollege.sharamik;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPassword {

	public static String encrypt(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
	public static void main(String[] agrs) {
		System.out .println(encrypt("abcde"));
		System.out .println(encrypt("12345"));
		
	}
}
