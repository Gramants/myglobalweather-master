package mvp.globalweather.cleanarchitecture.stefano.net;


import mvp.globalweather.cleanarchitecture.stefano.model.cities.Root;
import mvp.globalweather.cleanarchitecture.stefano.util.Constant;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface GeoNamesWebService {
    @GET("/postalCodeSearchJSON?maxRows=5&username=" + Constant.USERNAME)
    Observable<Root> fetchFilteredResults(@Query("placename_startsWith") String initial);

}