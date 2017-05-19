package hu.bme.aut.mobsoft.mobsoftlab.ui.recipelist;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.mobsoftlab.R;
import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;
import hu.bme.aut.mobsoft.mobsoftlab.ui.recipedetail.RecipeDetailFragment;

public class RecipeItemFragment extends Fragment implements RecipeListScreen {

    private OnListFragmentInteractionListener mListener;

    private ListView recipeListView;

    @Inject
    RecipeListPresenter listPresenter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RecipeItemFragment() {
    }

//    public static RecipeItemFragment newInstance(int columnCount) {
//        RecipeItemFragment fragment = new RecipeItemFragment();
//        Bundle args = new Bundle();
//        args.putInt(ARG_COLUMN_COUNT, columnCount);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MobSoftApplication.injector.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipeitem_list, container, false);
        recipeListView = (ListView) view.findViewById(R.id.recipe_list_view);

        recipeListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Recipe recipe = (Recipe)recipeListView.getAdapter().getItem(i);
                        openRecipeDetailedScreen(recipe.getId());
                        Log.v("RECIPE", ""+recipe.getName());
                        Log.v("RECIPE ID", ""+recipe.getId());
                    }
                }
        );

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.v("Recipe list", "Attached");
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        listPresenter.attachScreen(this);

        listPresenter.refreshList();
    }

    @Override
    public void onStop() {
        super.onStop();
        listPresenter.detachScreen();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listPresenter.detachScreen();
        mListener = null;
    }

    @Override
    public void showList(List<Recipe> recipeList) {
        RecipeAdapter adapter = new RecipeAdapter(getContext(), recipeList);
        recipeListView.setAdapter(adapter);
    }

    @Override
    public void openRecipeDetailedScreen(Long id) {
        Fragment fragment = new RecipeDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(RecipeDetailFragment.RECIPE_ID, id);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .addToBackStack("RecipeList")
                .commit();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Recipe item);
    }
}
