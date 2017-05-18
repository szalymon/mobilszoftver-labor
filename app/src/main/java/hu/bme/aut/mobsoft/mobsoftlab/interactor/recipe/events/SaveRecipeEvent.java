package hu.bme.aut.mobsoft.mobsoftlab.interactor.recipe.events;


import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;
import lombok.Data;

@Data
public class SaveRecipeEvent {
    private int code;
    private Recipe recipe;
    private Throwable throwable;

    public SaveRecipeEvent(){}

    public SaveRecipeEvent(int code, Recipe recipe, Throwable throwable){
        this.code = code;
        this.recipe = recipe;
        this.throwable = throwable;
    }

}
