package hu.bme.aut.mobsoft.mobsoftlab.ui.recipedetail;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.mobsoftlab.R;
import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecipeDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RecipeDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipeDetailFragment extends Fragment implements RecipeDetailScreen {

    public static final String RECIPE_ID = "recipe_id";

    private Long recipeId;

    private OnFragmentInteractionListener mListener;

    private Recipe showedRecipe;

    @Inject
    RecipeDetailPresenter recipeDetailPresenter;

    public RecipeDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecipeDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecipeDetailFragment newInstance(String param1, String param2) {
        RecipeDetailFragment fragment = new RecipeDetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MobSoftApplication.injector.inject(this);

        if (getArguments() != null) {
            recipeId = getArguments().getLong("recipe_id");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_recipe_detail, container, false);

        final Button backBtn = (Button)view.findViewById(R.id.back_button);
        backBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        back();
                    }
                }
        );

        final Button deleteBtn = (Button)view.findViewById(R.id.detail_delete);
        deleteBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        recipeDetailPresenter.deleteRecipe(showedRecipe);
                    }
                }
        );

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        recipeDetailPresenter.attachScreen(this);
        recipeDetailPresenter.getRecipeDetails(recipeId);
    }

    @Override
    public void onStop() {
        super.onStop();
        recipeDetailPresenter.detachScreen();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showRecipeDetails(Recipe recipe) {
        showedRecipe = recipe;
        View view = getView();
        TextView title = (TextView)view.findViewById(R.id.recipe_detail_title);
        TextView description = (TextView)view.findViewById(R.id.recipe_detail_description);
        TextView malt = (TextView)view.findViewById(R.id.recipe_detail_malt);
        TextView water = (TextView)view.findViewById(R.id.recipe_detail_water);
        TextView aromahop = (TextView)view.findViewById(R.id.recipe_detail_aromahop);
        TextView bitterhop = (TextView)view.findViewById(R.id.recipe_detail_bitterhop);

        title.setText(recipe.getName());
        description.setText(recipe.getDescription());
        water.setText("Víz: " + recipe.getWater());
        malt.setText("Maláta: " + recipe.getMalt());
        aromahop.setText("Aroma komló: " + recipe.getFlavourHop());
        bitterhop.setText("Keserű komló: " + recipe.getBitterHop());

        Log.v("ShowDetails", ""+recipe.getName());
    }

    @Override
    public void back() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().remove(this).commit();
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
