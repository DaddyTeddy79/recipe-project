package fr.teddy.recipeproject.services;

import java.util.Set;

import fr.teddy.recipeproject.domain.Recipe;

public interface RecipeService {
	Set<Recipe> getRecipes();
}
