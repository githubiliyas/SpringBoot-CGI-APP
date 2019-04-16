package com.cgi.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.cgi.controller.WelcomeController;
import com.cgi.logapp.controller.LogAppController;
import com.cgi.logapp.service.LogAppService;
import com.cgi.recipe.controller.RecipeController;
import com.cgi.recipe.service.RecipeService;

/**
 * The Class CGIAppStarter.
 * This is the starter class for the CGI app.
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = {LogAppController.class, LogAppService.class, 
		RecipeController.class, RecipeService.class, WelcomeController.class})
public class CGIAppStarter {

	/**
	 * The main method.The method which starts the CGI app;
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		SpringApplication.run(CGIAppStarter.class, args);
	}

}
