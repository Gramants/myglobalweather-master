package mvp.globalweather.cleanarchitecture.stefano;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;

import butterknife.ButterKnife;
import mvp.globalweather.cleanarchitecture.stefano.adapter.ArrayAdapterCallback;
import mvp.globalweather.cleanarchitecture.stefano.adapter.CityListAdapter;
import mvp.globalweather.cleanarchitecture.stefano.model.cities.Postalcodes;

import mvp.globalweather.cleanarchitecture.stefano.net.GeoNamesWebService;
import mvp.globalweather.cleanarchitecture.stefano.presenter.MainActivityPresenterContract;
import mvp.globalweather.cleanarchitecture.stefano.presenter.MainActivityViewContract;
import mvp.globalweather.cleanarchitecture.stefano.presenter.impl.MainActivityPresenter;
import mvp.globalweather.cleanarchitecture.stefano.ui.FragmentActivityContract;
import mvp.globalweather.cleanarchitecture.stefano.ui.WeatherFragment;



public class MainActivity extends Activity implements ArrayAdapterCallback, MainActivityViewContract,FragmentActivityContract {

    private CityListAdapter cityadapter;
    private Fragment fragment;
    private MainActivityPresenterContract mainActivityPresenter;
    private List<Postalcodes> cities;


    @Bind(R.id.progressbar)
    ProgressBar progress;

    @Bind(R.id.currentlocation)
    ImageButton buttoncurrent;

    @Bind(R.id.search)
    EditText search;

    @Bind(R.id.citylist)
    ListView citylist;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        mainActivityPresenter= new MainActivityPresenter(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mainActivityPresenter.getFilteredCityList(search);
        fragment =  getFragmentManager().findFragmentById(R.id.parent);
        if (fragment instanceof WeatherFragment)
        {
            buttoncurrent.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    ((WeatherFragment) fragment).updateWeatherByCurrentGeo();
                    resetView();
                    showProgress();
                    disableEdittext();
                }
            });
        }
    }

    @Override
    public void disableEdittext() {
        search.setEnabled(false);
    }
    @Override
    public void enableEdittext() {
        search.setEnabled(true);
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public void LoadCity(double lat, double lng) {
        fragment =  getFragmentManager().findFragmentById(R.id.parent);
        showProgress();
        ((WeatherFragment) fragment).updateWeatherByGeoList(lat,lng);
        resetView();


    }

    private void resetView() {
        if (cities!=null)
            cities.clear();

        search.setText(null);
        citylist.setVisibility(View.GONE);
    }


    @Override
    public void showFilteredResult(List<Postalcodes> citiesget) {
        cities=citiesget;
        cityadapter = new CityListAdapter(cities,this);
        citylist.setAdapter(cityadapter);
        cityadapter.notifyDataSetChanged();
        cityadapter.setCallback(this);
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void showList() {
        citylist.setVisibility(View.VISIBLE);
    }


    @Override
    public void onHideProgress() {
        hideProgress();
    }

    @Override
    public void onEnableEdittext() {
        enableEdittext();
    }
}





