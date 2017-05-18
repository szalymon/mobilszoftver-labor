package hu.bme.aut.mobsoft.mobsoftlab.repository;

import android.content.Context;

import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;

public interface Repository {

    void open(Context context);

    void close();

    List<Recipe> getRecipes();

    Recipe getDetailedRecipe(Long id);

    void removeRecipe(Recipe recipe);

    void saveRecipe(Recipe recipe);

    boolean isInDB(Recipe recipe);
}
