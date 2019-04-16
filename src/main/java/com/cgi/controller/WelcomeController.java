package com.cgi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The Class WelcomeController.
 * This is the main home screen
 * controller.
 */
@Controller
public class WelcomeController {

	/** The welcome message. */
	@Value("${welcome.message}")
	private String message;

	/**
	 * Index. The welcome screen 
	 * controller method.
	 *
	 * @param model the model
	 * @return the string of the view
	 */
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("message", message);
		return "index";
	}
}
