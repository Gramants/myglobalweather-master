package mvp.globalweather.cleanarchitecture.stefano.net;

import mvp.globalweather.cleanarchitecture.stefano.model.daily.NowWeather;
import mvp.globalweather.cleanarchitecture.stefano.model.forecast.FullWeather;
import mvp.globalweather.cleanarchitecture.stefano.util.Constant;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface OpenWeatherMapWebService {
    @GET("data/2.5/weather?units=metric&apikey=" + Constant.API_KEY)
    Observable<NowWeather> fetchCurrentWeatherByCoords(@Query("lon") double longitude, @Query("lat") double latitude);

    @GET("data/2.5/weather?units=metric&apikey=" + Constant.API_KEY)
    Observable<NowWeather> fetchCurrentWeatherByCityName(@Query("q") String city);


    @GET("data/2.5/forecast/daily?units=metric&cnt=5&apikey=" + Constant.API_KEY)
    Observable<FullWeather> fetchWeatherForecastsByCoords(
            @Query("lon") double longitude, @Query("lat") double latitude);

    @GET("data/2.5/forecast/daily?units=metric&cnt=5&apikey=" + Constant.API_KEY)
    Observable<FullWeather> fetchWeatherForecastsByCityName(@Query("q") String city);


}