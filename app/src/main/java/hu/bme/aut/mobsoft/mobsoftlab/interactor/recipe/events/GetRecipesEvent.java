package hu.bme.aut.mobsoft.mobsoftlab.interactor.recipe.events;

import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;
import lombok.Data;

@Data
public class GetRecipesEvent {
    private int code;
    private List<Recipe> recipes;
    private Throwable throwable;
}
