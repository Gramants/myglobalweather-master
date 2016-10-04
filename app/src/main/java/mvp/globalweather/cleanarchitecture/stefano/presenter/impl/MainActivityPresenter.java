package mvp.globalweather.cleanarchitecture.stefano.presenter.impl;

import android.widget.EditText;

import com.jakewharton.rxbinding.widget.RxTextView;
import com.jakewharton.rxbinding.widget.TextViewTextChangeEvent;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import mvp.globalweather.cleanarchitecture.stefano.App;
import mvp.globalweather.cleanarchitecture.stefano.MainActivity;
import mvp.globalweather.cleanarchitecture.stefano.model.cities.Postalcodes;
import mvp.globalweather.cleanarchitecture.stefano.model.cities.Root;
import mvp.globalweather.cleanarchitecture.stefano.net.GeoNamesWebService;
import mvp.globalweather.cleanarchitecture.stefano.presenter.MainActivityPresenterContract;
import mvp.globalweather.cleanarchitecture.stefano.presenter.MainActivityViewContract;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivityPresenter implements MainActivityPresenterContract {

    @Inject
    GeoNamesWebService gWebService;

    private Subscription subscriptioncityfilter;
    private MainActivityViewContract callback;
    private List<Postalcodes> cities;


    public MainActivityPresenter(MainActivity main) {
        callback=main;
        ((App) main.getApplication()).getCityApiComponent().inject(this);
    }



    @Override
    public void getFilteredCityList(EditText edittext) {



        subscriptioncityfilter = RxTextView.textChangeEvents(edittext)
                .debounce(600, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TextViewTextChangeEvent>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(TextViewTextChangeEvent textView) {
                        if (!textView.text().toString().equals(""))
                        {
                            callback.showProgress();
                            callback.showList();
                            gWebService.fetchFilteredResults( textView.text().toString())
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(new Action1<Root>() {
                                        @Override
                                        public void call(Root placesResult) {

                                            cities = (List) placesResult.getPostalCodes();
                                            callback.hideProgress();
                                            callback.showFilteredResult(cities);

                                        }
                                    }, new Action1<Throwable>() {
                                        @Override
                                        public void call(Throwable throwable) {
                                            throwable.printStackTrace();
                                        }
                                    });



                        }

                    }
                });
    }
}
