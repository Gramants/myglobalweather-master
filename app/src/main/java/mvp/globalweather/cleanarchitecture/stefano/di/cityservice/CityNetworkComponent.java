package mvp.globalweather.cleanarchitecture.stefano.di.cityservice;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = CityNetworkModule.class)
public interface CityNetworkComponent {

    Retrofit retrofit();
}
