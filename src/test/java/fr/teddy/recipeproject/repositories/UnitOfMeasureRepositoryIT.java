package fr.teddy.recipeproject.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fr.teddy.recipeproject.domain.UnitOfMeasure;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UnitOfMeasureRepositoryIT {

	@Autowired
	UnitOfMeasureRepository uomRepository;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFindByDescription() {
		Optional<UnitOfMeasure> uomOptional = uomRepository.findByDescription("grammes");
		assertEquals("grammes", uomOptional.get().getDescription());
	}

}
