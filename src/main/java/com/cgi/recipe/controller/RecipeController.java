package com.cgi.recipe.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cgi.recipe.dto.Recipe;
import com.cgi.recipe.service.RecipeService;

/**
 * The Class RecipeController. This is the controller class for the Recipe App.
 */
@Controller
public class RecipeController {

	/** The recipe service. */
	@Autowired
	private RecipeService recipeService;
	
	/**
	 * Gets all the recipes.
	 *
	 * @return the recipes from json file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@GetMapping("/recipes")
	public String getRecipes(Model model) {

		// The list of all the recipes from the service layer.
		List<Recipe> recipeList = null;
		try {
			recipeList = recipeService.getRecipes();
		} catch (IOException ioexp) {
			System.out.println("There was an error in the operation. Detailed logs:- " + ioexp.getMessage());
		}
		
		// Setting up the model object
		model.addAttribute("recipes", recipeList);
		return "recipes";
	}
	
	/**
	 * Gets all the recipes using a list of ingredients
	 * as provided by the user.
	 *
	 * @param ingredients the ingredients passed in the request.
	 * @return the recipes from json file having the ingredients.
	 */
	@GetMapping("/recipeingredients")
	public String getRecipesFromIngredients(@RequestParam(required=false) List<String> ingredients,
			Model model) {

		// The list of all the recipes from the service layer.
		List<Recipe> recipeList = null;
		try {
			recipeList = recipeService.getRecipesFromIngredients(ingredients);
		} catch (IOException ioexp) {
			System.out.println("There was an error in the operation. Detailed logs:- " + ioexp.getMessage());
		}
		
		// Setting up the model object
		model.addAttribute("recipeingredients", recipeList);
		return "recipeIngredients";
	}
}
