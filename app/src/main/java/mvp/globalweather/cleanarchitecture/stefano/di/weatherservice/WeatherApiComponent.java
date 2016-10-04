package mvp.globalweather.cleanarchitecture.stefano.di.weatherservice;


import dagger.Component;
import mvp.globalweather.cleanarchitecture.stefano.CustomScope;
import mvp.globalweather.cleanarchitecture.stefano.presenter.impl.WeatherFragmentPresenter;

@CustomScope
@Component(modules = WeatherApiModule.class, dependencies = WeatherNetworkComponent.class)
public interface WeatherApiComponent {
    void inject(WeatherFragmentPresenter fragmentPresenter);
}
