package mvp.globalweather.cleanarchitecture.stefano.ui;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


import butterknife.Bind;
import butterknife.ButterKnife;
import mvp.globalweather.cleanarchitecture.stefano.R;
import mvp.globalweather.cleanarchitecture.stefano.adapter.WeatherForecastListAdapter;
import mvp.globalweather.cleanarchitecture.stefano.model.WeatherForecast;
import mvp.globalweather.cleanarchitecture.stefano.model.daily.NowWeather;
import mvp.globalweather.cleanarchitecture.stefano.presenter.FragmentPresenterContract;
import mvp.globalweather.cleanarchitecture.stefano.services.GeoLocationService;
import mvp.globalweather.cleanarchitecture.stefano.presenter.FragmentViewContract;
import mvp.globalweather.cleanarchitecture.stefano.presenter.impl.WeatherFragmentPresenter;
import mvp.globalweather.cleanarchitecture.stefano.util.TemperatureFormatter;

public class WeatherFragment extends android.app.Fragment implements FragmentViewContract {
    private FragmentPresenterContract fragmentPresenter;
    private FragmentActivityContract callback;
    private LocationManager locationManager;
    private GeoLocationService locationService;
    private WeatherForecastListAdapter adapterForecast;


    @Bind(R.id.weather_forecast_list)
    ListView mForecastListView;

    @Bind(R.id.weatherdesc)
    TextView mCurrentDescTextView;

    @Bind(R.id.location_name)
    TextView mLocationNameTextView;

    @Bind(R.id.current_temperature)
    TextView mCurrentTemperatureTextView;



    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {

        fragmentPresenter= new WeatherFragmentPresenter(this);
        final View rootView = inflater.inflate(R.layout.fragment_weather, container, false);
        ButterKnife.bind(this, rootView);
        adapterForecast = new WeatherForecastListAdapter(new ArrayList<WeatherForecast>(), getActivity());
        mForecastListView.setAdapter(adapterForecast);
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        locationService = new GeoLocationService(locationManager);
        return rootView;
    }

    public void onAttach (Context context) {
        super.onAttach(context);
        try {
            Activity activity = (Activity) context;
            callback = (FragmentActivityContract) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(callback.toString()
                    + " must implement SellFragmentListener");
        }
    }

    public void updateWeatherByCurrentGeo() {
        fragmentPresenter.CurrentGeoWeather(locationService);
    }

    public void updateWeatherByGeoList(double lat, double lng) {
        fragmentPresenter.loadCurrenWeatherByCoords(lat,lng);
        fragmentPresenter.loadForecastByCoords(lat,lng);
    }



    @Override
    public void showForecast(ArrayList<WeatherForecast> weatherForecasts) {
        adapterForecast.clear();
        adapterForecast.addAll(weatherForecasts);
    }

    @Override
    public void showCurrentWeather(NowWeather cw) {
        mForecastListView.setVisibility(View.VISIBLE);
        mCurrentDescTextView.setVisibility(View.VISIBLE);
        mCurrentTemperatureTextView.setVisibility(View.VISIBLE);
        TemperatureFormatter tf = new TemperatureFormatter();
        mLocationNameTextView.setText(cw.getName());
        mCurrentTemperatureTextView.setText(tf.formatTemp(Float.parseFloat(cw.getMain().getTemp().toString())));
        mCurrentDescTextView.setText(cw.getWeather().get(0).getDescription());

    }

    @Override
    public void hideProgress() {
        callback.onHideProgress();
    }

    @Override
    public void enableEditText() {
        callback.onEnableEdittext();
    }

    @Override
    public void showCityNotFound() {
        mLocationNameTextView.setText(getString(R.string.error_fetch_weather));
        mForecastListView.setVisibility(View.GONE);
        mCurrentDescTextView.setVisibility(View.GONE);
        mCurrentTemperatureTextView.setVisibility(View.GONE);
    }



}