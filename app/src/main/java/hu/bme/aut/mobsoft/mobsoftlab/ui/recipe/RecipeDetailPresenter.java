package hu.bme.aut.mobsoft.mobsoftlab.ui.recipe;

import hu.bme.aut.mobsoft.mobsoftlab.ui.Presenter;

import static hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication.injector;


public class RecipeDetailPresenter extends Presenter<RecipeDetailScreen> {

    public RecipeDetailPresenter() {
    }

    @Override
    public void attachScreen(RecipeDetailScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}
