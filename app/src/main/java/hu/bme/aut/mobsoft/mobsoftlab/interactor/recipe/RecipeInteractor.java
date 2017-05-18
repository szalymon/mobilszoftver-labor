package hu.bme.aut.mobsoft.mobsoftlab.interactor.recipe;


import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.mobsoftlab.repository.Repository;

public class RecipeInteractor {

    public RecipeInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public void getRecipes() {
    }

}
