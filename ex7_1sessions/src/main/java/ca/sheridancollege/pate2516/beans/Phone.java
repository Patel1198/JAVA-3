package ca.sheridancollege.pate2516.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

	private Long id;
	private String model;
	private double price;
	
	
}
