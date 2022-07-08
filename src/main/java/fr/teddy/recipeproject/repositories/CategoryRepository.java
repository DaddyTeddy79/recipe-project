package fr.teddy.recipeproject.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.teddy.recipeproject.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	Optional<Category> findByDescription(String description);
}
