package fr.teddy.recipeproject.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.teddy.recipeproject.domain.Recipe;
import fr.teddy.recipeproject.repositories.RecipeRepository;

class RecipeServiceImplTest {

	RecipeServiceImpl service;
	@Mock
	RecipeRepository repository;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		service = new RecipeServiceImpl(repository);
	}

	@Test
	void testGetRecipesMethod() {
		Recipe recipe = new Recipe();
		Set<Recipe> recipeData = new HashSet<Recipe>();
		recipeData.add(recipe);

		when(repository.findAll()).thenReturn(recipeData);

		Set<Recipe> recipes = service.getRecipes();
		assertEquals(1, recipes.size());
		verify(repository, times(1)).findAll();
	}

}
