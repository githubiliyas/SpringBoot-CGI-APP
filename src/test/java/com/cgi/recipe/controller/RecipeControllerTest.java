package com.cgi.recipe.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cgi.starter.CGIAppStarter;

/**
 * The Class RecipeControllerTest. This is a test class for RecipeController
 */
@ContextConfiguration(classes = CGIAppStarter.class)
@RunWith(SpringRunner.class)
@WebMvcTest(RecipeController.class)
public class RecipeControllerTest {

	/** The mock mvc. */
	@Autowired
	MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	/** The recipe controller. */
	@MockBean
	private RecipeController recipeController;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	/**
	 * Test get recipes.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGetRecipes() throws Exception {

		// Calling the api to check for the view returned.
		MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/recipes")).andExpect(status().isOk())
				.andReturn();

		// Asserting the content of the page.
		String content = result.getResponse().getContentAsString();
		assertNotNull(content);
		assertTrue(content.contains("All Recipe List"));
	}

	/**
	 * Test get recipes from ingredients.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGetRecipesFromIngredients() throws Exception {

		// Calling the api to check for the view returned.
		MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/recipeingredients?ingredients=chicken"))
				.andExpect(status().isOk()).andReturn();

		// Asserting the content of the page.
		String content = result.getResponse().getContentAsString();
		assertNotNull(content);
		assertTrue(content.contains("All Recipes according to the Ingredients List"));
	}

}
