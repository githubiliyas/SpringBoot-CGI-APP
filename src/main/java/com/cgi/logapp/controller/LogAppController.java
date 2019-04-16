package com.cgi.logapp.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cgi.logapp.service.LogAppService;

@Controller
public class LogAppController {
	
	/** The log app service. */
	@Autowired
	private LogAppService logAppService;
	
	@GetMapping("/logtype")
	public String getLogsByType(@RequestParam(name="loglevel", required=false) String logLevel,
			Model model) {
		
		Map<String, String> logMap = null;
		try {
			logMap = logAppService.getLogsByType(logLevel);
		} catch (IOException ioexp) {
			System.out.println("There was an error in the operation. Detailed logs:- " + ioexp.getMessage());
		}
		
		// Setting up the model objects.
		model.addAttribute("logLevel", logLevel);
		model.addAttribute("logs",logMap);
		return "logtype";
	}

}
