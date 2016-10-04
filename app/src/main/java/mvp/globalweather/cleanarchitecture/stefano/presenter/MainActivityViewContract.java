package mvp.globalweather.cleanarchitecture.stefano.presenter;


import java.util.List;

import mvp.globalweather.cleanarchitecture.stefano.model.cities.Postalcodes;

public interface MainActivityViewContract {

    void showFilteredResult(List<Postalcodes> cities);
    void showProgress();
    void hideProgress();
    void showList();
}
