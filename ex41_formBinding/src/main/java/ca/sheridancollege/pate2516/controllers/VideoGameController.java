package ca.sheridancollege.pate2516.controllers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.pate2516.beans.VideoGame;


@Controller
public class VideoGameController {

List<VideoGame> videoGameList= new CopyOnWriteArrayList<VideoGame>();
	
	@GetMapping("/")
	public String indexMethod(Model model) {
		
		model.addAttribute("videoGame", new VideoGame());
		model.addAttribute("videoGameList",videoGameList);
		return "index";
		
	}
	@PostMapping("/addVideoGame")
	public String addMovie(Model model, @ModelAttribute VideoGame videoGame) {
		videoGameList.add(videoGame);
		model.addAttribute("videoGame", new VideoGame());
		model.addAttribute("videoGameList", videoGameList);
		return "index";
	}
	
}
