package hu.bme.aut.mobsoft.mobsoftlab.ui.recipelist;

import hu.bme.aut.mobsoft.mobsoftlab.ui.Presenter;
import hu.bme.aut.mobsoft.mobsoftlab.ui.recipelist.RecipeListScreen;

import static hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication.injector;


public class RecipeListPresenter extends Presenter<RecipeListScreen> {

    @Override
    public void attachScreen(RecipeListScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}
