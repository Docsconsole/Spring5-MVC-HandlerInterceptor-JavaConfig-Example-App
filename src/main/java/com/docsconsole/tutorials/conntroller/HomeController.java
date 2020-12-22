package com.docsconsole.tutorials.conntroller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	private static final Logger logger = Logger.getLogger(HomeController.class);
	@RequestMapping(value="/getAdminHome", method = RequestMethod.GET)
	public String getAdminHome(ModelMap model) {
		
		logger.info("Request @getAdminHome-HomeController");
		model.addAttribute("msg", "Welcome Admin to AdminHome Page !!");
		logger.info("Sending response @getAdminHome-HomeController");
		return "adminHome";		
		
	}
	
	@RequestMapping(value="/getUserHome", method = RequestMethod.GET)
	public String getUserHome(ModelMap model) {
		
		logger.info("Request @getUserHome-HomeController");
		model.addAttribute("msg", "Welcome User to UserHome Page !!");
		logger.info("Sending response @getUserHome-HomeController");
		return "userHome";		
		
	}
}