package hu.bme.aut.mobsoft.mobsoftlab.ui.rating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.mobsoftlab.R;

public class RatingActivity extends AppCompatActivity {

    @Inject
    RatingPresenter ratingPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
    }
}
