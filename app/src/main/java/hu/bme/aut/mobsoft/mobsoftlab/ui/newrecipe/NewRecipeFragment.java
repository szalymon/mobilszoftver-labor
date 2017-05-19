package hu.bme.aut.mobsoft.mobsoftlab.ui.newrecipe;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.media.MediaBrowserCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.mobsoftlab.R;
import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NewRecipeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NewRecipeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewRecipeFragment extends Fragment implements NewRecipeScreen {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @Inject
    public NewRecipePresenter newRecipePresenter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public NewRecipeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewRecipeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewRecipeFragment newInstance(String param1, String param2) {
        NewRecipeFragment fragment = new NewRecipeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MobSoftApplication.injector.inject(this);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_recipe, container, false);

        Button savebtn = (Button)view.findViewById(R.id.save);
        savebtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String name = ((EditText)getView().findViewById(R.id.name)).getText().toString();
                        String desc = ((EditText)getView().findViewById(R.id.description)).getText().toString();
                        String bitterhop = ((EditText)getView().findViewById(R.id.bitterhop)).getText().toString();
                        String flavour = ((EditText)getView().findViewById(R.id.flavour)).getText().toString();
                        String water = ((EditText)getView().findViewById(R.id.water)).getText().toString();
                        String malt = ((EditText)getView().findViewById(R.id.malt)).getText().toString();

                        Recipe recipe = new Recipe(name);
                        recipe.setDescription(desc);
                        if(!bitterhop.equals("")){
                            recipe.setBitterHop(Float.parseFloat(bitterhop));
                        }
                        if(!flavour.equals("")){
                            recipe.setFlavourHop(Float.parseFloat(flavour));
                        }
                        if(!water.equals("")){
                            recipe.setWater(Float.parseFloat(water));
                        }
                        if(!malt.equals("")){
                            recipe.setMalt(Float.parseFloat(malt));
                        }

                        newRecipePresenter.saveRecipe(recipe);
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
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onStart() {
        super.onStart();
        newRecipePresenter.attachScreen(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        newRecipePresenter.detachScreen();
    }

    @Override
    public void back() {
        getFragmentManager().beginTransaction().remove(this).commit();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
