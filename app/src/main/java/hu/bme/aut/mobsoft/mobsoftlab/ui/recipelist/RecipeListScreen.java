package hu.bme.aut.mobsoft.mobsoftlab.ui.recipelist;


import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;

public interface RecipeListScreen {

    void showList(List<Recipe> recipeList);

    void openRecipeDetailedScreen(Long id);

}
