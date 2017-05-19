package hu.bme.aut.mobsoft.mobsoftlab.ui.recipedetail;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.recipe.RecipeInteractor;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.recipe.events.GetDetailedRecipeEvent;
import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;
import hu.bme.aut.mobsoft.mobsoftlab.ui.Presenter;

import static hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication.injector;


public class RecipeDetailPresenter extends Presenter<RecipeDetailScreen> {
    @Inject
    RecipeInteractor recipeInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(RecipeDetailScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        bus.unregister(this);
    }

    public void getRecipeDetails(Long id) {
        recipeInteractor.getRecipeDetail(id);
    }

    public void onEventMainThread(GetDetailedRecipeEvent event) {
        if(screen != null) {
            screen.showRecipeDetails(event.getRecipe());
        }
    }

    void deleteRecipe(Recipe recipe) {
        recipeInteractor.deleteRecipe(recipe);
        screen.back();
    }

}
