package ee.itcollege.i377.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ee.itcollege.i377.service.GuardService;

@Controller
public class GuardController {
	
	private static Logger log = Logger.getLogger(GuardController.class);
	
	@Resource
	private GuardService guardService;
	
	@RequestMapping(value="/guards")
	public String guards(Model model) {
		log.debug("Rendering guards view");
		guardService.getAllGuards();
		return "guards";
 
	}

}
