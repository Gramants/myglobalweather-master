package mvp.globalweather.cleanarchitecture.stefano.di.cityservice;


import dagger.Component;
import mvp.globalweather.cleanarchitecture.stefano.CustomScope;
import mvp.globalweather.cleanarchitecture.stefano.presenter.impl.MainActivityPresenter;

@CustomScope
@Component(modules = CityApiModule.class, dependencies = CityNetworkComponent.class)
public interface CityApiComponent {
    void inject(MainActivityPresenter mainPresenter);
}
