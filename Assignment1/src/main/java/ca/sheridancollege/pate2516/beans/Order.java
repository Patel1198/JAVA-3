package ca.sheridancollege.pate2516.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String size;
	private int quantity;
	private String coffeeType;
	private double price;
	private double total;
	private int sugar;
	private int cream;
	private double fTotal;
	
	
	private final String[] sizes = {"Small","Medium","Large","Extra-Large"};
	private final String[] coffeeTypes = {"Regular", "Double Double", "Triple Triple", "Black", "Black One Sugar", 
			"Black Two Sugar", "Black Three Sugar"};
	
}
