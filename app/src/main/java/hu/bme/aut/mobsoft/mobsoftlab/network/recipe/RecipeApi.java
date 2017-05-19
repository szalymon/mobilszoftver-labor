package hu.bme.aut.mobsoft.mobsoftlab.network.recipe;



import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;
import hu.bme.aut.mobsoft.mobsoftlab.model.RecipeInfo;
import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RecipeApi {
  
  /**
   * Add a new recipe
   * 
   * @param body Recipe object that needs to be saved
   * @return Call<Void>
   */
  
  @PUT("recipe")
  Call<Void> addRecipe(
    @Body Recipe body
  );

  
  /**
   * Get detailed list by id
   * Get recipe
   * @param recipeId Recipe id to delete
   * @return Call<Recipe>
   */
  
  @GET("recipe/{recipeId}")
  Call<Recipe> getRecipe(
    @Path("recipeId") Long recipeId
  );

  
  /**
   * Deletes a recipe
   * 
   * @param recipeId Recipe id to delete
   * @return Call<Void>
   */
  
  @DELETE("recipe/{recipeId}")
  Call<Void> deleteRecipe(
    @Path("recipeId") Long recipeId
  );

  
  /**
   * List all recipes
   * 
   * @return Call<List<RecipeInfo>>
   */
  
  @GET("recipes")
  Call<List<Recipe>> getRecipes();
    

  
}
