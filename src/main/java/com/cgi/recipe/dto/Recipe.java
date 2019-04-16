package com.cgi.recipe.dto;

import java.util.List;

/**
 * The Class Recipe. This is a DTO class to store the recipe objects.
 */
public class Recipe {

	/** The title of the recipe. */
	private String title;

	/** The link of the recipe. */
	private String href;

	/** The ingredients of the recipe. */
	private List<String> ingredients;

	/** The thumbnail of the recipe. */
	private String thumbnail;

	/**
	 * Gets the title of the recipe.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the recipe.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the link of the recipe.
	 *
	 * @return the link
	 */
	public String getHref() {
		return href;
	}

	/**
	 * Sets the link of the recipe.
	 *
	 * @param href the new link
	 */
	public void setHref(String href) {
		this.href = href;
	}

	/**
	 * Gets the ingredients of the recipe.
	 *
	 * @return the ingredients of the recipe
	 */
	public List<String> getIngredients() {
		return ingredients;
	}

	/**
	 * Sets the ingredients of the recipe.
	 *
	 * @param ingredients the new ingredients
	 */
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * Gets the thumbnail of the recipe.
	 *
	 * @return the thumbnail of the recipe
	 */
	public String getThumbnail() {
		return thumbnail;
	}

	/**
	 * Sets the thumbnail of the recipe.
	 *
	 * @param thumbnail the new thumbnail of the recipe
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

}
