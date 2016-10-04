package mvp.globalweather.cleanarchitecture.stefano.di.weatherservice;


import dagger.Module;
import dagger.Provides;
import mvp.globalweather.cleanarchitecture.stefano.CustomScope;
import mvp.globalweather.cleanarchitecture.stefano.net.OpenWeatherMapWebService;
import retrofit2.Retrofit;


@Module
public class WeatherApiModule {

    @Provides
    @CustomScope
    OpenWeatherMapWebService provideOpenWeatherMapWebService(Retrofit retrofit) {
        return retrofit.create(OpenWeatherMapWebService.class);
    }
}
