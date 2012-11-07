package ee.itcollege.i377.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ee.itcollege.i377.model.Guard;
import ee.itcollege.i377.service.GuardService;

@Controller
public class GuardController {
	
	private static Logger log = Logger.getLogger(GuardController.class);
	
	@Resource
	private GuardService guardService;
	
	@RequestMapping(value="/guards")
	public String guards(Model model) {
		log.debug("Rendering guards view");
		List<Guard> guards = guardService.getAllGuards();
		model.addAttribute("allGuards", guards);
		return "guards";
	}
	
	@RequestMapping(value="/guardForm")
	public String guardForm(Model model) {
		log.debug("Rendering guard form");
		model.addAttribute("guard", new Guard());
		return "add";
		
	}
	
	@RequestMapping(value="/addGuard", method = RequestMethod.POST)
	public String addGuard(@ModelAttribute Guard guard, Model model) {
		log.debug("Adding a new Guard");
		guardService.addGuard(guard);
		model.addAttribute("guardAdded", true);
		return "add";
	}

}
