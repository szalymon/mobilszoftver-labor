package hu.bme.aut.mobsoft.mobsoftlab.ui.rating;

import hu.bme.aut.mobsoft.mobsoftlab.ui.Presenter;

import static hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication.injector;

/**
 * Created by szalymon on 2017. 04. 21..
 */

public class RatingPresenter extends Presenter<RatingScreen> {

    @Override
    public void attachScreen(RatingScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

}
