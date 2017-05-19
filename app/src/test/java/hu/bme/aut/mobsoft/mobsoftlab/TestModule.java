package hu.bme.aut.mobsoft.mobsoftlab;

import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

import hu.bme.aut.mobsoft.mobsoftlab.ui.UIModule;
import hu.bme.aut.mobsoft.mobsoftlab.ui.main.MainPresenter;
import hu.bme.aut.mobsoft.mobsoftlab.ui.newrecipe.NewRecipePresenter;
import hu.bme.aut.mobsoft.mobsoftlab.ui.recipedetail.RecipeDetailPresenter;
import hu.bme.aut.mobsoft.mobsoftlab.ui.recipelist.RecipeListPresenter;
import hu.bme.aut.mobsoft.mobsoftlab.utils.UiExecutor;

@Module
public class TestModule {

	private final UIModule UIModule;


	public TestModule(Context context) {
		this.UIModule = new UIModule(context);
	}

	@Provides
	public Context provideContext() {
		return UIModule.provideContext();
	}


	@Provides
	public MainPresenter provideMainPresenter() {
		return UIModule.provideMainPresenter();
	}

    @Provides
    public RecipeDetailPresenter provideRecipeDetailPresenter() {
        return UIModule.provideRecipeDetailPresenter();
    }

    @Provides
    public RecipeListPresenter provideRecipeListPresenter() {
        return UIModule.provideRecipeListPresenter();
    }

    @Provides
    public NewRecipePresenter provideNewRecipePresenter() {
        return UIModule.provideNewRecipePresenter();
    }

	@Provides
	@Singleton
	public EventBus provideEventBus() {
		return EventBus.getDefault();
	}

	@Provides
	@Singleton
	public Executor provideNetworkExecutor() {
		return new UiExecutor();
	}


}
