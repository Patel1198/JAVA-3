package ca.sheridancollege.pate2516.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.pate2516.beans.Dice;
import ca.sheridancollege.pate2516.database.DatabaseAccess;

@RestController
@RequestMapping("/rollDice")
public class FindTotalController {

	@Autowired
	private DatabaseAccess da;
	
	@GetMapping
	public List<Dice> getresultCollection() {
	return da.DiceList();
	}
	
	public int sum(List<Integer> results) {
	    int sum = 0;
	    for (int i: results) {
	        sum += i;
	    }
	    
	    return sum;
	}

}
