package mvp.globalweather.cleanarchitecture.stefano.presenter;


import android.widget.EditText;

public interface MainActivityPresenterContract {
    void getFilteredCityList(EditText search);

}
