package mvp.globalweather.cleanarchitecture.stefano.presenter.impl;

import android.location.Location;
import android.util.Log;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import mvp.globalweather.cleanarchitecture.stefano.App;
import mvp.globalweather.cleanarchitecture.stefano.model.WeatherForecast;
import mvp.globalweather.cleanarchitecture.stefano.model.forecast.FullWeather;
import mvp.globalweather.cleanarchitecture.stefano.model.daily.NowWeather;
import mvp.globalweather.cleanarchitecture.stefano.net.OpenWeatherMapWebService;
import mvp.globalweather.cleanarchitecture.stefano.presenter.FragmentPresenterContract;
import mvp.globalweather.cleanarchitecture.stefano.presenter.FragmentViewContract;
import mvp.globalweather.cleanarchitecture.stefano.services.GeoLocationService;
import mvp.globalweather.cleanarchitecture.stefano.ui.WeatherFragment;
import mvp.globalweather.cleanarchitecture.stefano.util.Constant;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class WeatherFragmentPresenter implements FragmentPresenterContract {


    private Subscription subscriptioncurrentweather;
    private Subscription subscriptionforecast;
    private Subscription subscriptioncurrengeo;
    private FragmentViewContract callback;

    @Inject
    OpenWeatherMapWebService mWebService;

    public WeatherFragmentPresenter(WeatherFragment weatherFragment) {
        callback=weatherFragment;
        ((App)  (weatherFragment.getActivity()).getApplication()).getWeatherApiComponent().inject(this);

    }

@Override
    public void loadCurrenWeatherByCoords(double lat,double lon) {

        if (subscriptionforecast != null) subscriptionforecast.unsubscribe();
        subscriptionforecast = mWebService.fetchCurrentWeatherByCoords(lon,lat)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<NowWeather>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable error) {

                    }

                    @Override
                    public void onNext(NowWeather currentweather) {

                         if (currentweather.getCod().toString().equals("404"))
                         {
                         callback.showCityNotFound();
                         }
                         else
                         {
                         callback.showCurrentWeather(currentweather);
                         }
                    }


                });
        
        
        
    }
    @Override
    public void loadForecastByCoords(double lat,double lon) {

        if (subscriptioncurrentweather != null) subscriptioncurrentweather.unsubscribe();
         subscriptioncurrentweather = mWebService.fetchWeatherForecastsByCoords(lon,lat)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<FullWeather>() {


                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable error) {

                    }

                    @Override
                    public void onNext(FullWeather repositoriesfull) {
                        final ArrayList<WeatherForecast> weatherForecasts = new ArrayList<>();

                        for (int index=0;index<repositoriesfull.getList().size();index++) {

                            final WeatherForecast weatherForecast = new WeatherForecast(
                                    Long.parseLong(repositoriesfull.getList().get(index).getDt().toString() ),
                                    repositoriesfull.getList().get(index).getWeather().get(0).getDescription(),
                                    Float.parseFloat(repositoriesfull.getList().get(index).getTemp().getMin().toString()),
                                    Float.parseFloat(repositoriesfull.getList().get(index).getTemp().getMax().toString()));
                                     weatherForecasts.add(weatherForecast);

                            }

                        callback.hideProgress();
                        callback.enableEditText();
                        callback.showForecast(weatherForecasts);

                    }


                });
        
        
    }


    @Override
    public void CurrentGeoWeather(GeoLocationService locationService) {

        subscriptioncurrengeo = locationService.getLocation()
                .timeout(Constant.LOCATION_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<Location>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Location location) {
                        loadCurrenWeatherByCoords(location.getLatitude(),location.getLongitude());
                        loadForecastByCoords(location.getLatitude(),location.getLongitude());
                    }
                });
    }
}
