package mvp.globalweather.cleanarchitecture.stefano.presenter;


import mvp.globalweather.cleanarchitecture.stefano.services.GeoLocationService;

public interface FragmentPresenterContract {
    void CurrentGeoWeather(GeoLocationService locationService);
    void loadCurrenWeatherByCoords(double lat, double lng);
    void loadForecastByCoords(double lat, double lng);
}
