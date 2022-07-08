package fr.teddy.recipeproject.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest {
	Category category;

	@BeforeEach
	public void setup() {
		category = new Category();
	}

	@Test
	void shouldBeTheRightID() {
		category.setId(4L);
		assertEquals(4L, category.getId());
	}

}
