package hu.bme.aut.mobsoft.mobsoftlab.model;

import com.orm.dsl.Table;


/**
 * Created by szalymon on 2017. 04. 21..
 */
@Table
public class Recipe {

    private String name;
    private String description;
    private float bitterHop;
    private float flavourHop;
    private float water;
    private float malt;

}
