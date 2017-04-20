package hu.bme.aut.mobsoft.mobsoftlab;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.mobsoft.mobsoftlab.ui.UIModule;
import hu.bme.aut.mobsoft.mobsoftlab.ui.main.MainActivity;

/**
 * Created by szalymon on 2017. 04. 20..
 */

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

}
