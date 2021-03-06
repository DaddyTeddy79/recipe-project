package fr.teddy.recipeproject.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import fr.teddy.recipeproject.domain.Recipe;
import fr.teddy.recipeproject.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> getRecipes() {
		// log.debug("I'm in the getRecipes method in RecipeServiceImpl");
		Set<Recipe> recipes = new HashSet<Recipe>();
		recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
		return recipes;
	}

}
