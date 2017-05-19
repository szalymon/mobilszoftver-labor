package hu.bme.aut.mobsoft.mobsoftlab.ui.main;

import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;

/**
 * Created by szalymon on 2017. 04. 20..
 */

public interface MainScreen {

    void showMessage(String message);

    void showRecipeList(List<Recipe> recipies);
}
