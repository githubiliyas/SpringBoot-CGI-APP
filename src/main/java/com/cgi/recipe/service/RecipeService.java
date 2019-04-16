package com.cgi.recipe.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.cgi.recipe.dto.Recipe;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class RecipeService. This is the service class for the Recipe App.
 */
@Service
public class RecipeService {

	/**
	 * Gets all the recipes.
	 *
	 * @return the recipes
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public List<Recipe> getRecipes() throws IOException {

		// Mapping the json file to a list of Java objects.
		ObjectMapper objMapper = new ObjectMapper();
		List<Recipe> recipeList = objMapper.readValue(getRecipeAsString(), new TypeReference<List<Recipe>>() {
		});

		// Filtering the recipe according to the title.
		recipeList.sort(new Comparator<Recipe>() {

			@Override
			public int compare(Recipe r1, Recipe r2) {
				return r1.getTitle().compareTo(r2.getTitle());
			}
		});

		// The list of all the recipes.
		return recipeList;
	}

	/**
	 * Gets all the recipes using a list of ingredients as provided by the user.
	 *
	 * @param ingredients the ingredients passed in the request.
	 * @return the recipes from json file having the ingredients.
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public List<Recipe> getRecipesFromIngredients(List<String> ingredients) throws IOException {

		// Mapping the json file to a list of Java objects.
		ObjectMapper objMapper = new ObjectMapper();
		List<Recipe> recipeList = objMapper.readValue(getRecipeAsString(), new TypeReference<List<Recipe>>() {
		});
		
		// Replacing the URL value of + with space.
		List<String> correctedIngredientsList = new ArrayList<>();
		for (String ingredient : ingredients) {
			correctedIngredientsList.add(ingredient.replace("+", " "));
		}
		
		List<Recipe> fileterdList = new ArrayList<>();

		// Iterating to filter the list.
		for (Recipe recipe : recipeList) {

			if (null != ingredients && recipe.getIngredients().containsAll(ingredients)) {
				fileterdList.add(recipe);
			}
		}

		// Filtering the recipe according to the title.
		fileterdList.sort(new Comparator<Recipe>() {

			@Override
			public int compare(Recipe r1, Recipe r2) {
				return r1.getTitle().compareTo(r2.getTitle());
			}
		});
		return fileterdList;
	}

	/**
	 * Gets the recipe as string from the json file.
	 *
	 * @return the recipe as string from the json file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private static String getRecipeAsString() throws IOException {

		// Reading the json file from the classpath resource.
		File jsonFile = new ClassPathResource("receipe.json").getFile();
		InputStream stream = new FileInputStream(jsonFile);

		// Converting the json file to a String.
		return IOUtils.toString(stream, StandardCharsets.UTF_8);
	}
}
