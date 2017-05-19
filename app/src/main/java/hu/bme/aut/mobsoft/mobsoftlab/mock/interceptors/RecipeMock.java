package hu.bme.aut.mobsoft.mobsoftlab.mock.interceptors;

import android.net.Uri;

import java.util.ArrayList;

import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;
import hu.bme.aut.mobsoft.mobsoftlab.network.NetworkConfig;
import hu.bme.aut.mobsoft.mobsoftlab.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static hu.bme.aut.mobsoft.mobsoftlab.mock.interceptors.MockHelper.makeResponse;

public class RecipeMock {
	public static Response process(Request request) {
		Uri uri = Uri.parse(request.url().toString());

		String responseString;
		int responseCode;
		Headers headers = request.headers();


		if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "recipe") && request.method().equals("PUT")) {
			responseString = newRecipe();
			responseCode = 200;
		}else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "recipe/0") && request.method().equals("GET")) {
			responseString = getRecipe();
			responseCode = 200;
		} else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "recipe/1") && request.method().equals("DELETE")) {
			responseString = deleteRecipe();
			responseCode = 200;
		} else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "recipes") && request.method().equals("GET")) {
			responseString = getRecipes();
			responseCode = 200;
		}else {
			responseString = "ERROR";
			responseCode = 503;
		}

		return makeResponse(request, headers, responseCode, responseString);
	}

    static String newRecipe() {
        return "";
    }

	static String deleteRecipe() {
        return "";
    }

	static String getRecipe() {
        Recipe recipe = new Recipe("Stout");
        recipe.setId(0L);
        recipe.setDescription("It's a wounderful description");

        recipe.setFruitiness(2);
        recipe.setSweetness(5);
        recipe.setBitterness(3);

        recipe.setMalt(25);
        recipe.setBitterHop(3);
        recipe.setFlavourHop(3);

        return GsonHelper.getGson().toJson(recipe);
    }

	static String getRecipes() {
        Long idseq = -1L;
        ArrayList<Recipe> recipes = new ArrayList<>();
        {
            Recipe recipe = new Recipe("Stout");
            recipe.setId(idseq++);
            recipe.setDescription("It's a wounderful description");

            recipe.setFruitiness(2);
            recipe.setSweetness(5);
            recipe.setBitterness(3);

            recipe.setMalt(25);
            recipe.setBitterHop(3);
            recipe.setFlavourHop(3);

            recipes.add(recipe);
        }

        {
            Recipe recipe = new Recipe("IPA");
            recipe.setId(idseq++);
            recipe.setDescription("It's a wounderful description");

            recipe.setFruitiness(3);
            recipe.setSweetness(3);
            recipe.setBitterness(2);

            recipe.setMalt(25);
            recipe.setBitterHop(3);
            recipe.setFlavourHop(3);

            recipes.add(recipe);
        }

        {
            Recipe recipe = new Recipe("Pilsner");
            recipe.setId(idseq++);
            recipe.setDescription("It's a wounderful description");

            recipe.setFruitiness(3);
            recipe.setSweetness(3);
            recipe.setBitterness(2);

            recipe.setMalt(25);
            recipe.setBitterHop(3);
            recipe.setFlavourHop(3);

            recipes.add(recipe);
        }

        {
            Recipe recipe = new Recipe("Some kind of Lager");
            recipe.setId(idseq++);
            recipe.setDescription("It's a wounderful description");

            recipe.setFruitiness(3);
            recipe.setSweetness(3);
            recipe.setBitterness(2);

            recipe.setMalt(25);
            recipe.setBitterHop(3);
            recipe.setFlavourHop(3);

            recipes.add(recipe);
        }
        return GsonHelper.getGson().toJson(recipes);
    }

}
