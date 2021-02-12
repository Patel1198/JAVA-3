package ca.sheridancollege.pate2516.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.pate2516.beans.Dice;
import ca.sheridancollege.pate2516.database.DatabaseAccess;

@Controller
	public class HomeController {

		@Autowired
		protected DatabaseAccess da;
		Dice dice = new Dice();
		
		@GetMapping("/")
		public String rollDice(Model model) {
			model.addAttribute("diceList", da.DiceList());
			model.addAttribute("dice", dice);
			
				return "index";
		}
	  
		
		
		@PostMapping("/rollDice")
		public String processRoll(Model model, @ModelAttribute Dice dice) {
			
			
			da.insertDice(dice);
			model.addAttribute("diceList", da.DiceList());
			model.addAttribute("dice", dice);
			
			  
			return "RollResult";
		}
		
		
	}
