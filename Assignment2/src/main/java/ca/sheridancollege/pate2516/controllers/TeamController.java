package ca.sheridancollege.pate2516.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import ca.sheridancollege.pate2516.beans.Team;
import ca.sheridancollege.pate2516.database.DatabaseAccess;

@Controller
public class TeamController {

	@Autowired
	DatabaseAccess dtb = new DatabaseAccess();
	
	@GetMapping("/")
	public String home(Model model) {
		return "home";
	}
	
	@GetMapping("/addTeam")
	public String addTeam(Model model) { 
		model.addAttribute("team",new Team());
		model.addAttribute("teamList", dtb.getTeamList());
		return "addTeam";
	}
	
	@PostMapping("/addTeam")
	public String processTeam(Model model, @ModelAttribute Team team) {
		dtb.insertTeam(team.getTeamName(),team.getContinent(),team.getPlayed(),team.getWon(),team.getDrawn(),team.getLost());
		model.addAttribute("team",new Team());
		model.addAttribute("teamList", dtb.getTeamList());
		return "addTeam";
	}
	
	@GetMapping("/editTeam")
	public String editTeam(Model model) {
		
		model.addAttribute("team",new Team());
		model.addAttribute("teamList",dtb.getTeamList());
		return "editTeam";
	}
	
	@GetMapping("/editTeamById/{teamId}")
	public String updateTeam(Model model, @PathVariable Long teamId) {
		
		Team team = dtb.getTeamById(teamId).get(0);
		model.addAttribute("team", team);
		model.addAttribute("teamList", dtb.getTeamList());
		return "update";
	}
	
	@PostMapping("/modifyTeam")
	public String modifyTeam(Model model, @ModelAttribute Team team) {
		dtb.updateTeam(team);
		model.addAttribute("teamList", dtb.getTeamList());
		return "editTeam";
	}
	
	@GetMapping("/deleteTeam")
	public String deleteTeam(Model model) {
		
		model.addAttribute("team",new Team());
		model.addAttribute("teamList", dtb.getTeamList());
		return "deleteTeam";
		
	}
	
	@GetMapping("/deleteTeamById/{teamId}")
	public String deleteTeamById(Model model, @PathVariable Long teamId) {
		
		dtb.deleteTeamById(teamId);
		model.addAttribute("teamList", dtb.getTeamList());
		return "deleteTeam";	
	}
	
	
	@GetMapping("/displayResults")
	public String displayTeam(Model model,@ModelAttribute Team team ) {
		
		List<Team> sort = dtb.getTeamList(); 
		int n = dtb.getTeamList().size();
		for(int i=0; i<n; i++) {
			int pts=sort.get(i).getWon()*3+sort.get(i).getDrawn();
			sort.get(i).setPts(pts);
		}
		model.addAttribute("team",new Team());
		model.addAttribute("teamList", sort);
		return "displayResults";
	}
	
	@GetMapping("/orderTeamName")
	public String orderName(Model model, @ModelAttribute Team team) {
		List<Team> sort = dtb.sortName(); 
		int n = dtb.sortName().size();
		for(int i=0; i<n; i++) {
			int pts=sort.get(i).getWon()*3+sort.get(i).getDrawn();
			sort.get(i).setPts(pts);
		}
		model.addAttribute("team", new Team());
		model.addAttribute("teamList", sort);
		
		
		return "displayResults";
		
	}
	@GetMapping("/orderTeamContinent")
	public String orderContinent(Model model, @ModelAttribute Team team) {
		List<Team> sort = dtb.sortContinent(); 
		int n = dtb.sortContinent().size();
		for(int i=0; i<n; i++) {
			int pts=sort.get(i).getWon()*3+sort.get(i).getDrawn();
			sort.get(i).setPts(pts);
		}
		model.addAttribute("team", new Team());
		model.addAttribute("teamList", sort);
		
		
		
		return "displayResults";
		
	}
	@GetMapping("/orderPts")
	public String orderPts(Model model, @ModelAttribute Team team) {
		List<Team> sort = dtb.getTeamList(); 
		int n = dtb.getTeamList().size();
		for(int i=0; i<n; i++) {
			int pts=sort.get(i).getWon()*3+sort.get(i).getDrawn();
			sort.get(i).setPts(pts);
		}
		Team temp = new Team();
		for(int j=0;j<n;j++) {
			temp = sort.get(j);
			int k=j-1;
			
			while(k>=0 && temp.getPts()<sort.get(k).getPts()) {
				sort.set(k+1, sort.get(k));
				k = k-1;
			}
			sort.set(k+1, temp);
		}
		model.addAttribute("team", new Team());
		
		
		model.addAttribute("teamList",sort);
		
		return "displayResults";
		
	}	
}
