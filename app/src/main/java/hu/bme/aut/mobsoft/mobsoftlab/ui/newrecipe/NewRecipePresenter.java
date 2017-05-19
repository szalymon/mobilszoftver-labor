package hu.bme.aut.mobsoft.mobsoftlab.ui.newrecipe;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.recipe.RecipeInteractor;
import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;
import hu.bme.aut.mobsoft.mobsoftlab.ui.Presenter;

import static hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication.injector;


public class NewRecipePresenter extends Presenter<NewRecipeScreen> {

    @Inject
    RecipeInteractor recipeInteractor;

    @Inject
    Executor executor;

//    @Inject
//    EventBus bus;

    @Override
    public void attachScreen(NewRecipeScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
//        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
//        bus.unregister(this);
    }

    public void saveRecipe(Recipe recipe) {
        recipeInteractor.saveRecipe(recipe);
        screen.back();
    }

}
