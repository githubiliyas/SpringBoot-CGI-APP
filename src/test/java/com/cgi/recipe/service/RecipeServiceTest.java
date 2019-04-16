package com.cgi.recipe.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cgi.starter.CGIAppStarter;

/**
 * The Class RecipeServiceTest.
 * This is a JUnit class for the
 * RecipeService.
 */
@SpringBootTest(classes = { CGIAppStarter.class })
@RunWith(SpringRunner.class)
public class RecipeServiceTest {

	/** The recipe service. */
	@Autowired
	private RecipeService recipeService;

	/**
	 * Test get recipes.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public void testGetRecipes() throws IOException {
		
		// Asserting the returned values.
		Assert.assertNotNull(recipeService.getRecipes());
		Assert.assertFalse(recipeService.getRecipes().isEmpty());
	}
	
	/**
	 * Test get recipes from ingredients.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public void testGetRecipesFromIngredients() throws IOException {
		
		// Asserting the returned values.
		Assert.assertNotNull(recipeService.getRecipesFromIngredients(Arrays.asList("onions","salmon")));
		Assert.assertFalse(recipeService.getRecipesFromIngredients(Arrays.asList("rice")).isEmpty());
	}
	
	/**
	 * Test get recipes as string.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws IllegalAccessException the illegal access exception
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws InvocationTargetException the invocation target exception
	 * @throws NoSuchMethodException the no such method exception
	 * @throws SecurityException the security exception
	 */
	@Test
	public void testGetRecipeAsString() throws IOException, IllegalAccessException, 
		IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		// Using reflection to access the private method.
		Method privateMethod = RecipeService.class.getDeclaredMethod("getRecipeAsString");
		privateMethod.setAccessible(Boolean.TRUE);
		
		// Asserting the returned values.
		Assert.assertNotNull(privateMethod.invoke(recipeService, null));
	}

}
