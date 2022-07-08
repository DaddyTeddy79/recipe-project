package fr.teddy.recipeproject.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import fr.teddy.recipeproject.domain.Category;
import fr.teddy.recipeproject.domain.Difficulty;
import fr.teddy.recipeproject.domain.Ingredient;
import fr.teddy.recipeproject.domain.Notes;
import fr.teddy.recipeproject.domain.Recipe;
import fr.teddy.recipeproject.domain.UnitOfMeasure;
import fr.teddy.recipeproject.repositories.CategoryRepository;
import fr.teddy.recipeproject.repositories.RecipeRepository;
import fr.teddy.recipeproject.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RecipesLoader implements ApplicationListener<ContextRefreshedEvent> {

	private final CategoryRepository categoryRepository;
	private final RecipeRepository recipeRepository;
	private final UnitOfMeasureRepository uomRepository;

	public RecipesLoader(CategoryRepository categoryRepository, RecipeRepository recipeRepository,
			UnitOfMeasureRepository uomRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.recipeRepository = recipeRepository;
		this.uomRepository = uomRepository;
	}

	private List<Recipe> getRecipeList() {

		List<Recipe> recipes = new ArrayList<Recipe>(2);

		UnitOfMeasure uomPinch = getUOMFromDescription("pincées");
		UnitOfMeasure uomGram = getUOMFromDescription("grammes");
		UnitOfMeasure uomBag = getUOMFromDescription("sachets");
		UnitOfMeasure uomCentiliter = getUOMFromDescription("centilitres");
		UnitOfMeasure uomLeaf = getUOMFromDescription("feuilles");
		UnitOfMeasure uomBranch = getUOMFromDescription("branches");
		UnitOfMeasure uomCube = getUOMFromDescription("cubes");

		Category frenchCategory = getCategoryFromDescription("French");
		Category italianCategory = getCategoryFromDescription("Italian");

		Recipe tiramisu = new Recipe();
		tiramisu.setDescription("Tiramisu (recette originale)");
		tiramisu.setPreparationTime(15);
		tiramisu.setCookingTime(0);
		tiramisu.setDifficulty(Difficulty.EASY);
		tiramisu.setDirections("ÉTAPE 1 \n" + "Séparer les blancs des jaunes d'oeufs.\n" + "ÉTAPE 2 \n"
				+ "Mélanger les jaunes avec le sucre roux et le sucre vanillé.\n" + "ÉTAPE 3 \n"
				+ "Ajouter le mascarpone au fouet.\n" + "ÉTAPE 4 \n"
				+ "Monter les blancs en neige et les incorporer délicatement à la spatule au mélange précédent. Réserver.\n"
				+ "ÉTAPE 5 \n Mouiller les biscuits dans le café rapidement avant d'en tapisser le fond du plat.\n"
				+ "ÉTAPE 6 \n Recouvrir d'une couche de crème au mascarpone puis répéter l'opération en alternant couche de biscuits et couche de crème en terminant par cette dernière.\n"
				+ "ÉTAPE 7 \n Saupoudrer de cacao."
				+ "ÉTAPE 8 \n Mettre au réfrigérateur 4 heures minimum puis déguster frais.");

		log.debug("Directives de cette recette : " + tiramisu.getDirections());

		Notes tiramisuNotes = new Notes();
		tiramisuNotes.setRecipeNotes("Il existe de nombreuses recettes de tiramisu. Celle-ci est la recette originale "
				+ "(ou en tous les cas, l'une des recettes pouvant prétendre l'être!). NB: il y a bien de l'alcool dans "
				+ "le tiramisu mais il s'agit de Marsala sec (ni aux oeufs, ni à l'amande) mélangé au café très fort.");
		tiramisu.setNotes(tiramisuNotes);

		tiramisu.addIngredient(new Ingredient("sucre roux", new BigDecimal(100), uomGram));
		tiramisu.addIngredient(new Ingredient("sucre vanillé", new BigDecimal(1), uomBag));
		tiramisu.addIngredient(new Ingredient("biscuits à la cuillère", new BigDecimal(24), null));
		tiramisu.addIngredient(new Ingredient("cacao amer", new BigDecimal(30), uomGram));
		tiramisu.addIngredient(new Ingredient("oeufs", new BigDecimal(3), null));
		tiramisu.addIngredient(new Ingredient("mascarpone", new BigDecimal(250), uomGram));
		tiramisu.addIngredient(new Ingredient("café noir non sucré", new BigDecimal(50), uomCentiliter));

		tiramisu.getCategories().add(italianCategory);

		Recipe saucissesLentilles = new Recipe();
		saucissesLentilles.setDescription("Saucisses aux lentilles du Puy : la meilleure recette");
		saucissesLentilles.setPreparationTime(5);
		saucissesLentilles.setCookingTime(50);
		saucissesLentilles.setDifficulty(Difficulty.EASY);
		saucissesLentilles.setDirections(
				"1. Éplucher et émincer l'oignon. Éplucher la carotte, la couper en rondelles. Dans une casserole, faire fondre"
						+ " un grosse noix de beurre. Y verser l'oignon et la carotte, et les faire revenir pendant 5 minutes.\n"
						+ "2. Ajouter les lentilles, des grains de poivre, le thym et le laurier, le cube, et couvrir d'environ "
						+ "deux fois le volume d'eau. Couvrir et laisser cuire environ 25 minutes à feu moyen.\n"
						+ "3. Piquer les saucisses, et les ajouter dans la casserole. Faire cuire encore 20 minutes.");

		Notes saucissesLentillesNotes = new Notes();
		saucissesLentillesNotes
				.setRecipeNotes("Pour finir\n" + "5 minutes avant la fin de la cuisson, saler les lentilles.");
		saucissesLentilles.setNotes(saucissesLentillesNotes);

		saucissesLentilles.addIngredient(new Ingredient("saucisses aux herbes", new BigDecimal(6), null));
		saucissesLentilles.addIngredient(new Ingredient("lentilles vertes du Puy", new BigDecimal(250), uomGram));
		saucissesLentilles.addIngredient(new Ingredient("oignons", new BigDecimal(1), null));
		saucissesLentilles.addIngredient(new Ingredient("carotte", new BigDecimal(1), null));
		saucissesLentilles.addIngredient(new Ingredient("laurier", new BigDecimal(1), uomLeaf));
		saucissesLentilles.addIngredient(new Ingredient("thym", new BigDecimal(1), uomBranch));
		saucissesLentilles.addIngredient(new Ingredient("bouillon de légumes", new BigDecimal(1), uomCube));
		saucissesLentilles.addIngredient(new Ingredient("poivre du moulin", new BigDecimal(3), uomPinch));
		saucissesLentilles.addIngredient(new Ingredient("sel", new BigDecimal(3), uomPinch));
		saucissesLentilles.addIngredient(new Ingredient("beurre", new BigDecimal(30), uomGram));

		saucissesLentilles.getCategories().add(frenchCategory);

		recipes.add(saucissesLentilles);
		recipes.add(tiramisu);

		return recipes;
	}

	private UnitOfMeasure getUOMFromDescription(String description) {
		return uomRepository.findByDescription(description)
				.orElseThrow(() -> new RuntimeException("Unit of measure '" + description + "' not found"));
	}

	private Category getCategoryFromDescription(String description) {
		return categoryRepository.findByDescription(description)
				.orElseThrow(() -> new RuntimeException("Category '" + description + "' not found"));
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		recipeRepository.saveAll(getRecipeList());
	}
}
