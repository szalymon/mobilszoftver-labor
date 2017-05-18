package hu.bme.aut.mobsoft.mobsoftlab;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.InteractorModule;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.recipe.RecipeInteractor;
import hu.bme.aut.mobsoft.mobsoftlab.repository.RepositoryModule;
import hu.bme.aut.mobsoft.mobsoftlab.ui.UIModule;
import hu.bme.aut.mobsoft.mobsoftlab.ui.main.MainActivity;
import hu.bme.aut.mobsoft.mobsoftlab.ui.main.MainPresenter;
import hu.bme.aut.mobsoft.mobsoftlab.ui.recipelist.RecipeListPresenter;

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class})
public interface MobSoftApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(MobSoftApplication mobSoftApplication);

    void inject(MainPresenter mainPresenter);

    void inject(RecipeInteractor recipeInteractor);

    void inject(RecipeListPresenter recipeListPresenter);
}
