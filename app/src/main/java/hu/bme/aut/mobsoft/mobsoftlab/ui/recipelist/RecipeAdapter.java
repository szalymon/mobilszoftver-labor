package hu.bme.aut.mobsoft.mobsoftlab.ui.recipelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.R;
import hu.bme.aut.mobsoft.mobsoftlab.model.Recipe;

/**
 * Created by szalymon on 2017. 05. 18..
 */

public class RecipeAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<Recipe> mDataSource;

    public RecipeAdapter(Context context, List<Recipe> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int i) {
        return mDataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = mInflater.inflate(R.layout.beerrecipe_item, viewGroup, false);

        TextView title = (TextView) rowView.findViewById(R.id.recipe_list_item_title);
        TextView description = (TextView) rowView.findViewById(R.id.recipe_list_item_description);

        Recipe recipe = (Recipe) getItem(i);

        title.setText(recipe.getName());
        description.setText(recipe.getDescription());
        return rowView;
    }
}
