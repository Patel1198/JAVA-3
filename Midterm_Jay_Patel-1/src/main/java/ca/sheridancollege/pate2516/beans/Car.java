package ca.sheridancollege.pate2516.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Car {

	private int carId;
	private String manufacturer;
	private String model;
	private int year;
	private String colour;
	private double price;
	
	private final String[] manufacturerList= {"Honda", "Nissan", "Toyota", "Ford", "Chevrolet"};
}
