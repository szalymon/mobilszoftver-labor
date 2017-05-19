package hu.bme.aut.mobsoft.mobsoftlab.ui.main;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
import hu.bme.aut.mobsoft.mobsoftlab.ui.newrecipe.NewRecipeFragment;
import hu.bme.aut.mobsoft.mobsoftlab.ui.recipedetail.RecipeDetailFragment;
import hu.bme.aut.mobsoft.mobsoftlab.ui.recipelist.RecipeItemFragment;

public class MainActivity extends AppCompatActivity implements MainScreen, RecipeItemFragment.OnListFragmentInteractionListener, RecipeDetailFragment.OnFragmentInteractionListener {

    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;

    private Button refreshBtn;

    private RecipeDetailFragment recipeDetailFragment;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobSoftApplication.injector.inject(this);

        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

//        Button refreshBtn = (Button) findViewById(R.id.refresh_btn);
//        refreshBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mainPresenter.getRecipes();
//            }
//        });

        setupToolbar();

        DataModel[] drawerItem = new DataModel[2];

        // Név a menüben
        drawerItem[0] = new DataModel("Új recept");
        drawerItem[1] = new DataModel("Recept lista");
        // TODO hide default back button
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();

//        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
//        recipeListView = (ListView) findViewById(R.id.recipe_list_view);

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

//    @Override
//    public void showRecipeDetail(Recipe recipe) {
//        Bundle bundle = new Bundle();
//        bundle.putLong("recipe_id", recipe.getId());
//        selectItem(1, bundle);
//    }

    @Override
    public void showRecipeList(List<Recipe> recipies) {
        RecipeItemFragment fragment = new RecipeItemFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onListFragmentInteraction(Recipe item) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    private class DrawerItemClickListener implements ListView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position, null);
        }
    }

    private Fragment selectItem(int position, Bundle bundle) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new NewRecipeFragment();
                break;
            case 1:
                fragment = new RecipeItemFragment();
                break;

            default:
                break;
        }
        if (fragment != null) {
            if(bundle != null) {
                fragment.setArguments(bundle);
            }
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
        return fragment;
    }

    void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }

}
