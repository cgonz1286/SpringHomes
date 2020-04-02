package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Home;
import dmacc.repository.HomeRepository;

@Controller
public class WebController {
	
	@Autowired
	HomeRepository repo;
	
	@GetMapping({ "/", "/viewAll" })
	public String viewAllHomes(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewHome(model);
		}
		
		model.addAttribute("contacts", repo.findAll());
		
		return "results_home";
	}
	
	@GetMapping("/inputHome")
	public String addNewHome(Model model) {
		Home h = new Home();
		model.addAttribute("newHome", h);
		
		return "input_home";
	}
	
	@PostMapping("/inputHome")
	public String addNewHome(@ModelAttribute Home h, Model model) {
		repo.save(h);
		
		return viewAllHomes(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateHome(@PathVariable("id") long id, Model model) {
		Home h = repo.findById(id).orElse(null);
		model.addAttribute("newHome", h);
		
		return "input_home";
	}
	
	@PostMapping("/update/{id}")
	public String reviseHome(Home h, Model model) {
		repo.save(h);
		
		return viewAllHomes(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Home h = repo.findById(id).orElse(null);
		repo.delete(h);
		
		return viewAllHomes(model);
	}
	
}
