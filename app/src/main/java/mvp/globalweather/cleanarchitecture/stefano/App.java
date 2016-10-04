package mvp.globalweather.cleanarchitecture.stefano;

import android.app.Application;

import mvp.globalweather.cleanarchitecture.stefano.di.cityservice.CityApiComponent;
import mvp.globalweather.cleanarchitecture.stefano.di.cityservice.CityNetworkComponent;
import mvp.globalweather.cleanarchitecture.stefano.di.cityservice.CityNetworkModule;

import mvp.globalweather.cleanarchitecture.stefano.di.cityservice.DaggerCityApiComponent;
import mvp.globalweather.cleanarchitecture.stefano.di.cityservice.DaggerCityNetworkComponent;
import mvp.globalweather.cleanarchitecture.stefano.di.weatherservice.DaggerWeatherApiComponent;
import mvp.globalweather.cleanarchitecture.stefano.di.weatherservice.DaggerWeatherNetworkComponent;
import mvp.globalweather.cleanarchitecture.stefano.di.weatherservice.WeatherApiComponent;
import mvp.globalweather.cleanarchitecture.stefano.di.weatherservice.WeatherNetworkComponent;
import mvp.globalweather.cleanarchitecture.stefano.di.weatherservice.WeatherNetworkModule;
import mvp.globalweather.cleanarchitecture.stefano.util.Constant;


public class App extends Application {

    private CityApiComponent mCityApiComponent;
    private WeatherApiComponent mWeatherApiComponent;

    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
    }

    private void resolveDependency() {
        mCityApiComponent = DaggerCityApiComponent.builder()
                .cityNetworkComponent(getCityNetworkComponent())
                .build();

        mWeatherApiComponent = DaggerWeatherApiComponent.builder()
                .weatherNetworkComponent(getWeatherNetworkComponent())
                .build();
    }

    public CityNetworkComponent getCityNetworkComponent() {
        return DaggerCityNetworkComponent.builder()
                .cityNetworkModule(new CityNetworkModule(Constant.CITY_WEB_SERVICE_BASE_URL))
                .build();
    }
    public WeatherNetworkComponent getWeatherNetworkComponent() {
        return DaggerWeatherNetworkComponent.builder()
                .weatherNetworkModule(new WeatherNetworkModule(Constant.WEATHER_WEB_SERVICE_BASE_URL))
                .build();
    }

    public CityApiComponent getCityApiComponent() {
        return mCityApiComponent;
    }
    public WeatherApiComponent getWeatherApiComponent() {
        return mWeatherApiComponent;
    }




}
