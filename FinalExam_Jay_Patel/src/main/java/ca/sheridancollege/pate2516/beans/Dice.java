
package ca.sheridancollege.pate2516.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Dice {
	private int numberOfDices;
	private int numberOfSides;
	private int [] results;
	private int diceTotal;
	
	private final int[] diceTypes = {4,6,8,10,12,20};
}
