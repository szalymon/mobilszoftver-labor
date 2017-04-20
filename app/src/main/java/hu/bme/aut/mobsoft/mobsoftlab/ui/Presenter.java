package hu.bme.aut.mobsoft.mobsoftlab.ui;

/**
 * Created by szalymon on 2017. 04. 20..
 */

public abstract class Presenter<S> {

    protected S screen;

    public void attachScreen(S screen) {
        this.screen = screen;
    }

    public void detachScreen() {
        this.screen = null;
    }

}
