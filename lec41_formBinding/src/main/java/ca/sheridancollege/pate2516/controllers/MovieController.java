package ca.sheridancollege.pate2516.controllers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.pate2516.beans.Movie;

@Controller
public class MovieController {

	List<Movie> movieList= new CopyOnWriteArrayList<Movie>();
	
	@GetMapping("/")
	public String indexMethod(Model model) {
		
		model.addAttribute("movie", new Movie());
		model.addAttribute("movieList",movieList);
		return "index";
		
	}
	@PostMapping("/addMovie")
	public String addMovie(Model model, @ModelAttribute Movie movie) {
		movieList.add(movie);
		model.addAttribute("movie", new Movie());
		model.addAttribute("movieList", movieList);
		return "index";
	}
}

