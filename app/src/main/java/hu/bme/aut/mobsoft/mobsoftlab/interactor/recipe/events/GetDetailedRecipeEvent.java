package hu.bme.aut.mobsoft.mobsoftlab.interactor.recipe.events;

import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;
import lombok.Data;


@Data
public class GetDetailedRecipeEvent {
    private int code;
    private Recipe recipe;
    private Throwable throwable;

    public GetDetailedRecipeEvent(){}

    public GetDetailedRecipeEvent(int code, Recipe recipe, Throwable throwable){
        this.code = code;
        this.recipe = recipe;
        this.throwable = throwable;
    }
}
