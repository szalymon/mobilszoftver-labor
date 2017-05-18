package hu.bme.aut.mobsoft.mobsoftlab.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.mobsoftlab.R;
import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;
import hu.bme.aut.mobsoft.mobsoftlab.ui.recipelist.RecipeAdapter;

public class MainActivity extends AppCompatActivity implements MainScreen {

    private ListView mDrawerList;
    private ListView recipeListView;
    private Button refreshBtn;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobSoftApplication.injector.inject(this);

//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

//        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        recipeListView = (ListView) findViewById(R.id.recipe_list_view);

        refreshBtn = (Button) findViewById(R.id.refresh);
        refreshBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainPresenter.getRecipes();
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRecipeDetail(Long id) {

    }

    @Override
    public void showRecipeList() {
//        RecipeAdapter adapter = new RecipeAdapter(this, recipeList);
//        recipeListView.setAdapter(adapter);
    }


    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        }
    }

}
