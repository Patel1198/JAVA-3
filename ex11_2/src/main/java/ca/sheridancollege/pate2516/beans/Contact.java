package ca.sheridancollege.pate2516.beans;

import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Contact {

	private Long id;
	private String firstName;
	private String lastName;
	private Long phoneNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate appointmentDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthday;
	
}
