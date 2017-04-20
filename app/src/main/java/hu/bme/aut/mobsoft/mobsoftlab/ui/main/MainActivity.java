package hu.bme.aut.mobsoft.mobsoftlab.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hu.bme.aut.mobsoft.mobsoftlab.R;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MainPresenter.getInstance().attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        MainPresenter.getInstance().detachScreen();
    }

}
