package ca.sheridancollege.pate2516.controllers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.pate2516.beans.Order;


@Controller
public class ProcessOrder {
	
	List<Order> orderList= new CopyOnWriteArrayList<Order>();
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("order", new Order());
		model.addAttribute("orderList",orderList);
		return "index";
		
	}
	@PostMapping("/addOutput")
	public String order(Model model, @ModelAttribute Order order) {
		double price=0.0d;
		if(order.getSize().equals("Small")) {
			switch(order.getCoffeeType()){
			case "Regular": 
				order.setSugar(1);
				order.setCream(1);
				price=order.getQuantity()*1.54;
				
				break;
			case "Double Double": 
				order.setSugar(2);
				order.setCream(2);
				price=order.getQuantity()*1.54;
				break;
			case "Triple Triple":
				order.setSugar(3);
				order.setCream(3);
				price=order.getQuantity()*1.54;
				
				break;
			case "Black": 
				order.setSugar(0);
				order.setCream(0);
				price=order.getQuantity()*1.54;
				
				break;
			case "Black One Sugar":
				order.setSugar(1);
				order.setCream(0);
				price=order.getQuantity()*1.58;
				
				break;
			case "Black Two Sugar":
				order.setSugar(2);
				order.setCream(0);
				price=order.getQuantity()*1.60;
				
				break;
			case "Black Three Sugar":
				order.setSugar(3);
				order.setCream(0);
				price=order.getQuantity()*1.64;
				
				break;
			default:
				System.out.print("Invalid");
				break;
			}
			
		}else if(order.getSize().equals("Medium")){
			switch(order.getCoffeeType()){
			case "Regular": 
				order.setSugar(1);
				order.setCream(1);
				price=order.getQuantity()*1.76;
				
				break;
			case "Double Double": 
				order.setSugar(2);
				order.setCream(2);
				price=order.getQuantity()*1.76;
				
				break;
			case "Triple Triple":
				order.setSugar(3);
				order.setCream(3);
				price=order.getQuantity()*1.76;
				
				break;
			case "Black": 
				order.setSugar(0);
				order.setCream(0);
				price=order.getQuantity()*1.76;
				
				break;
			case "Black One Sugar":
				order.setSugar(1);
				order.setCream(0);
				price=order.getQuantity()*1.80;
				
				break;
			case "Black Two Sugar":
				order.setSugar(2);
				order.setCream(0);
				price=order.getQuantity()*1.84;
				
				break;
			case "Black Three Sugar":
				order.setSugar(3);
				order.setCream(0);
				price=order.getQuantity()*1.88;
				
				break;
			default:
				System.out.print("Invalid");
				break;
			}
		}else if(order.getSize().equals("Large")){
			switch(order.getCoffeeType()){
			case "Regular": 
				order.setSugar(1);
				order.setCream(1);
				price=order.getQuantity()*1.92;
				
				break;
			case "Double Double": 
				order.setSugar(2);
				order.setCream(2);
				price=order.getQuantity()*1.92;
				
				break;
			case "Triple Triple":
				order.setSugar(3);
				order.setCream(3);
				price=order.getQuantity()*1.92;
				
				break;
			case "Black": 
				order.setSugar(0);
				order.setCream(0);
				price=order.getQuantity()*1.92;
				
				break;
			case "Black One Sugar":
				order.setSugar(1);
				order.setCream(0);
				price=order.getQuantity()*1.95;
				
				break;
			case "Black Two Sugar":
				order.setSugar(2);
				order.setCream(0);
				price=order.getQuantity()*1.97;
				
				break;
			case "Black Three Sugar":
				order.setSugar(3);
				order.setCream(0);
				price=order.getQuantity()*1.99;
				
				break;
			default:
				System.out.print("Invalid");
				break;
			}
		}else if(order.getSize().equals("Extra-Large")){
			
			switch(order.getCoffeeType()){
			case "Regular": 
				order.setSugar(1);
				order.setCream(1);
				price=order.getQuantity()*2.19;
				
				break;
			case "Double Double": 
				order.setSugar(2);
				order.setCream(2);
				price=order.getQuantity()*2.19;
				
				break;
			case "Triple Triple":
				order.setSugar(3);
				order.setCream(3);
				price=order.getQuantity()*2.19;
				
				break;
			case "Black": 
				order.setSugar(0);
				order.setCream(0);
				price=order.getQuantity()*2.19;
				
				break;
			case "Black One Sugar":
				order.setSugar(1);
				order.setCream(0);
				price=order.getQuantity()*2.23;
				
				break;
			case "Black Two Sugar":
				order.setSugar(2);
				order.setCream(0);
				price=order.getQuantity()*2.26;
				
				break;
			case "Black Three Sugar":
				order.setSugar(3);
				order.setCream(0);
				price=order.getQuantity()*2.29;
				
				break;
			default:
				System.out.print("Invalid");
				break;
			}
		}
		double HST=13.00;
		double total=(price*HST/100)+price;
		double fTotal = 0;
		order.setTotal(total);
		order.setPrice(price);
		orderList.add(order);
		for(int i=0; i<orderList.size(); i++) {
			fTotal += orderList.get(i).getTotal();
		}
		model.addAttribute("order", order);
		model.addAttribute("orderList", orderList);
		model.addAttribute("fTotal", fTotal);
		System.out.println(order);
		
		return "output";
	}
}
