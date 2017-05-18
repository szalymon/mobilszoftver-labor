package hu.bme.aut.mobsoft.mobsoftlab.interactor.recipe.events;

import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;
import lombok.Data;

@Data
public class UpdateRecipeEvent {
    private int code;
    private Throwable throwable;
    private Recipe recipe;
}
