package fr.teddy.recipeproject.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.teddy.recipeproject.domain.Recipe;
import fr.teddy.recipeproject.services.RecipeService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class IndexController {

	private final RecipeService recipeService;

	public IndexController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage(Model model) {
		log.debug("Nous sommes dans la méthode getIndexPage de IndexController");

		Set<Recipe> recipes = recipeService.getRecipes();
		model.addAttribute("recipes", recipes);
		return "index";
	}
}
