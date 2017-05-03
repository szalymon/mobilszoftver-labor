package hu.bme.aut.mobsoft.mobsoftlab.repository;

import android.content.Context;

import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;

public interface Repository {

    void open(Context context);

    void close();

    List<Recipe> getRecipes();

    Recipe getRecipe();

    void addRecipe(Recipe recipe);

    void deleteRecipe(Recipe recipe);

    boolean isInDB(Recipe recipe);
}
