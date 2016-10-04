package mvp.globalweather.cleanarchitecture.stefano.presenter;


import java.util.ArrayList;

import mvp.globalweather.cleanarchitecture.stefano.model.WeatherForecast;
import mvp.globalweather.cleanarchitecture.stefano.model.daily.NowWeather;
import mvp.globalweather.cleanarchitecture.stefano.model.forecast.FullWeather;

public interface FragmentViewContract {


    void showCurrentWeather(NowWeather currentweather);
    void hideProgress();
    void enableEditText();
    void showCityNotFound();
    void showForecast(ArrayList<WeatherForecast> weatherForecasts);
}
