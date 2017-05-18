package hu.bme.aut.mobsoft.mobsoftlab.interactor;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.recipe.RecipeInteractor;

@Module
public class InteractorModule {
	@Provides
	public RecipeInteractor provideReciepes() {
		return new RecipeInteractor();
	}


}
