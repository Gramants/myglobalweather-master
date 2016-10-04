package mvp.globalweather.cleanarchitecture.stefano.di.weatherservice;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = WeatherNetworkModule.class)
public interface WeatherNetworkComponent {

    Retrofit retrofit();
}
