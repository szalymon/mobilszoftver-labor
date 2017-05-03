package hu.bme.aut.mobsoft.mobsoftlab.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;

public class MemoryRepository implements Repository {

	private static final long MINUTE = 60 * 1000;

	public static List<Recipe> recipes;

	@Override
	public void open(Context context) {
		Recipe recipe1 = new Recipe();
		Recipe recipe2 = new Recipe();

		recipes = new ArrayList<>();
		recipes.add(recipe1);
		recipes.add(recipe2);
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

