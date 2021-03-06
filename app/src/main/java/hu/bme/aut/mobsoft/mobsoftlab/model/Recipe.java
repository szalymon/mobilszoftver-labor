package hu.bme.aut.mobsoft.mobsoftlab.model;

import com.google.gson.annotations.SerializedName;
import com.orm.dsl.Table;

import lombok.Data;


@Table
@Data
public class Recipe {

    private Long id = null;

    @SerializedName("name")
    private String name;
    private String description;
    private float bitterHop;
    private float flavourHop;
    private float water;
    private float malt;

    // Ratings...
    private int bitterness;
    private int fruitiness;
    private int sweetness;


    public Recipe(String name) {
        this.name = name;
    }
}
