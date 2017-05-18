package hu.bme.aut.mobsoft.mobsoftlab.ui.main;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.recipe.RecipeInteractor;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.recipe.events.GetRecipesEvent;
import hu.bme.aut.mobsoft.mobsoftlab.ui.Presenter;

import static hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication.injector;


public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    RecipeInteractor recipeInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        bus.unregister(this);
    }

    public void getRecipes() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                recipeInteractor.getRecipes();
            }
        });
    }

    public void onEventMainThread(GetRecipesEvent event) {
        if(screen != null) {
            screen.showMessage("GetRecipesEvent: " +  event.getRecipes().size());
//            screen.showList(event.getRecipes());
        }
    }

}
