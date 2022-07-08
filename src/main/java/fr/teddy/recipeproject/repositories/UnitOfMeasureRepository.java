package fr.teddy.recipeproject.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.teddy.recipeproject.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

	Optional<UnitOfMeasure> findByDescription(String description);

}
