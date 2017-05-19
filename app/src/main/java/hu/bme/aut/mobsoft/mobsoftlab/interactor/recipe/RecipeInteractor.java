package hu.bme.aut.mobsoft.mobsoftlab.interactor.recipe;


import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.recipe.events.DeleteRecipeEvent;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.recipe.events.GetDetailedRecipeEvent;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.recipe.events.GetRecipesEvent;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.recipe.events.SaveRecipeEvent;
import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;
import hu.bme.aut.mobsoft.mobsoftlab.network.recipe.RecipeApi;
import hu.bme.aut.mobsoft.mobsoftlab.repository.Repository;

public class RecipeInteractor {

    @Inject
    Repository repository;

    @Inject
    RecipeApi recipeApi;

    @Inject
    EventBus bus;

    public RecipeInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void deleteRecipe(Recipe recipe) {
        DeleteRecipeEvent event = new DeleteRecipeEvent();
        event.setRecipe(recipe);
        try {
            repository.removeRecipe(recipe);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void saveRecipe(Recipe recipe) {
        SaveRecipeEvent event = new SaveRecipeEvent();
        event.setRecipe(recipe);
        try {
            // TODO save HTTP API-ba is
            repository.saveRecipe(recipe);
            bus.post(recipe);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void getRecipes() {
        GetRecipesEvent event = new GetRecipesEvent();
        try {
            List<Recipe> recipes = repository.getRecipes();
            event.setRecipes(recipes);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
//        final GetRecipesEvent event = new GetRecipesEvent();
//        try {
//            recipeApi.getRecipes().enqueue(
//                    new Callback<List<Recipe>>() {
//                        @Override
//                        public void onResponse(Response<List<Recipe>> response) {
//                            event.setRecipes(response.body());
//                            bus.post(event);
//                        }
//
//                        @Override
//                        public void onFailure(Throwable t) {
//                            List<Recipe> recipes = repository.getRecipes();
//                            event.setRecipes(recipes);
//                            bus.post(event);
//                        }
//                    }
//            );
    }

    public void getRecipeDetail(long id) {
        GetDetailedRecipeEvent event = new GetDetailedRecipeEvent();
        try {
            Recipe recipe = repository.getDetailedRecipe(id);
            event.setRecipe(recipe);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

}
