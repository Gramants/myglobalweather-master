package mvp.globalweather.cleanarchitecture.stefano.di.cityservice;


import dagger.Module;
import dagger.Provides;
import mvp.globalweather.cleanarchitecture.stefano.CustomScope;
import mvp.globalweather.cleanarchitecture.stefano.net.GeoNamesWebService;
import retrofit2.Retrofit;


@Module
public class CityApiModule {

    @Provides
    @CustomScope
    GeoNamesWebService provideGeoNamesWebService(Retrofit retrofit) {
        return retrofit.create(GeoNamesWebService.class);
    }
}
