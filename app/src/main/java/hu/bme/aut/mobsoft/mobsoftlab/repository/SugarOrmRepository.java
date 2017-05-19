package hu.bme.aut.mobsoft.mobsoftlab.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;

public class SugarOrmRepository implements Repository {
    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Recipe> getRecipes() {
        return SugarRecord.listAll(Recipe.class);
    }

    @Override
    public Recipe getDetailedRecipe(Long id) {
        return SugarRecord.findById(Recipe.class, id);
    }

    @Override
    public void removeRecipe(Recipe recipe) {
        SugarRecord.deleteInTx(recipe);
    }

    @Override
    public void saveRecipe(Recipe recipe) {
        SugarRecord.saveInTx(recipe);
    }

    @Override
    public boolean isInDB(Recipe recipe) {
        return false;
    }
}
