package ca.sheridancollege.pate2516.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Student {

	private Long id;
	@NonNull
	private String name;
	private Boolean admin; 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate appointmentDate;
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime appointmentTime;
}
