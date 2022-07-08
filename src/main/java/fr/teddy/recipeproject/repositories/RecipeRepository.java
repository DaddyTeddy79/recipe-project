package fr.teddy.recipeproject.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.teddy.recipeproject.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
