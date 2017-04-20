package hu.bme.aut.mobsoft.mobsoftlab.ui.main;

import hu.bme.aut.mobsoft.mobsoftlab.ui.Presenter;

/**
 * Created by szalymon on 2017. 04. 20..
 */

public class MainPresenter extends Presenter<MainScreen>{

    private static MainPresenter instance = null;

    private MainPresenter() {
    }

    public static MainPresenter getInstance() {
        if (instance == null) {
            instance = new MainPresenter();
        }
        return instance;
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}
