package hu.bme.aut.mobsoft.mobsoftlab.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;

public class SugarOrmRepository implements Repository {
    @Override
    public void open(Context context) {

    }

    @Override
    public void close() {

    }

    @Override
    public List<Recipe> getRecipes() {
        return null;
    }

    @Override
    public Recipe getRecipe() {
        return null;
    }

    @Override
    public void addRecipe(Recipe recipe) {

    }

    @Override
    public void deleteRecipe(Recipe recipe) {

    }

    @Override
    public boolean isInDB(Recipe recipe) {
        return false;
    }
}
