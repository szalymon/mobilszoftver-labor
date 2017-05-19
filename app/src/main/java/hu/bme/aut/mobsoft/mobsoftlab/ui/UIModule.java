package hu.bme.aut.mobsoft.mobsoftlab.ui;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.mobsoftlab.ui.main.MainPresenter;
import hu.bme.aut.mobsoft.mobsoftlab.ui.newrecipe.NewRecipePresenter;
import hu.bme.aut.mobsoft.mobsoftlab.ui.recipedetail.RecipeDetailPresenter;
import hu.bme.aut.mobsoft.mobsoftlab.ui.recipelist.RecipeListPresenter;
import hu.bme.aut.mobsoft.mobsoftlab.ui.recipelist.RecipeListScreen;

/**
 * Created by szalymon on 2017. 04. 20..
 */

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public NewRecipePresenter provideNewRecipePresenter() {
        return new NewRecipePresenter();
    }

    @Provides
    @Singleton
    public RecipeListPresenter provideRecipeListPresenter() {
        return new RecipeListPresenter();
    }

    @Provides
    @Singleton
    public RecipeDetailPresenter provideRecipeDetailPresenter() {
        return new RecipeDetailPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus(){return EventBus.getDefault();}

    @Provides
    @Singleton
    public Executor provideExecutor() {return Executors.newFixedThreadPool(1);}

}
