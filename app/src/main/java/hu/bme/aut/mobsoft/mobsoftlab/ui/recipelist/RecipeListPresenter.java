package hu.bme.aut.mobsoft.mobsoftlab.ui.recipelist;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.recipe.RecipeInteractor;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.recipe.events.DeleteRecipeEvent;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.recipe.events.GetDetailedRecipeEvent;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.recipe.events.GetRecipesEvent;
import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;
import hu.bme.aut.mobsoft.mobsoftlab.ui.Presenter;
import hu.bme.aut.mobsoft.mobsoftlab.ui.recipelist.RecipeListScreen;

import static hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication.injector;


public class RecipeListPresenter extends Presenter<RecipeListScreen> {
    @Inject
    RecipeInteractor recipeInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(RecipeListScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        bus.unregister(this);
    }


    public void refreshList() {
        recipeInteractor.getRecipes();
    }

    public void deleteRecipe(Recipe recipe) {
        recipeInteractor.deleteRecipe(recipe);
    }

    public void onEventMainThread(GetRecipesEvent event) {
        if (screen != null) {
            screen.showList(event.getRecipes());
        }
    }

    public void onEventMainThread(DeleteRecipeEvent event) {
        refreshList();
    }

}
