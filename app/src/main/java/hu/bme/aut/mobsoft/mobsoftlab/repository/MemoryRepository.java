package hu.bme.aut.mobsoft.mobsoftlab.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;

public class MemoryRepository implements Repository {

    private static final long MINUTE = 60 * 1000;

    public static List<Recipe> recipes;

    static Long idseq = 0L;

    @Override
    public void open(Context context) {
        recipes = new ArrayList<>();
        {
            Recipe recipe = new Recipe("Stout");
            recipe.setId(idseq++);
            recipe.setDescription("It's a wounderful description");

            recipe.setFruitiness(2);
            recipe.setSweetness(5);
            recipe.setBitterness(3);

            recipe.setMalt(25);
            recipe.setBitterHop(3);
            recipe.setFlavourHop(3);

            recipes.add(recipe);
        }

        {
            Recipe recipe = new Recipe("IPA");
            recipe.setId(idseq++);
            recipe.setDescription("It's a wounderful description");

            recipe.setFruitiness(3);
            recipe.setSweetness(3);
            recipe.setBitterness(2);

            recipe.setMalt(25);
            recipe.setBitterHop(3);
            recipe.setFlavourHop(3);

            recipes.add(recipe);
        }

        {
            Recipe recipe = new Recipe("Pilsner");
            recipe.setId(idseq++);
            recipe.setDescription("It's a wounderful description");

            recipe.setFruitiness(3);
            recipe.setSweetness(3);
            recipe.setBitterness(2);

            recipe.setMalt(25);
            recipe.setBitterHop(3);
            recipe.setFlavourHop(3);

            recipes.add(recipe);
        }

        {
            Recipe recipe = new Recipe("Some kind of Lager");
            recipe.setId(idseq++);
            recipe.setDescription("It's a wounderful description");

            recipe.setFruitiness(3);
            recipe.setSweetness(3);
            recipe.setBitterness(2);

            recipe.setMalt(25);
            recipe.setBitterHop(3);
            recipe.setFlavourHop(3);

            recipes.add(recipe);
        }
    }

    @Override
    public void close() {
    }

    @Override
    public List<Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public Recipe getDetailedRecipe(Long id) {
        return recipes.get(id.intValue());
    }

    @Override
    public void removeRecipe(Recipe recipe) {
        recipes.remove(recipe);
    }

    @Override
    public void saveRecipe(Recipe recipe) {
        recipe.setId(idseq++);
        recipes.add(recipe);
    }

    @Override
    public boolean isInDB(Recipe recipe) {
        return recipes.contains(recipe);
    }

}

