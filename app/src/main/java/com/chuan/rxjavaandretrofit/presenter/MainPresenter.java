package com.chuan.rxjavaandretrofit.presenter;

import android.app.Activity;

import com.chuan.rxjavaandretrofit.bean.WeatherInfo;
import com.chuan.rxjavaandretrofit.bean.base.BaseResponse;
import com.chuan.rxjavaandretrofit.api.URLConstant;
import com.chuan.rxjavaandretrofit.observer.RxJavaObserver;
import com.chuan.rxjavaandretrofit.net.RetrofixUtils;
import com.chuan.rxjavaandretrofit.view.activity.IMainView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by admin on 2017/3/3.
 */

public class MainPresenter implements IMainPresenter {
    private static final String TAG = "MainPresenter";
    private IMainView mainView;
    public MainPresenter(IMainView iMainView){
        mainView = iMainView;
    }
    @Override
    public void getWeatherInfo(String cityId) {
        RetrofixUtils.getRetrofit(URLConstant.CITY_WEATHER)
                .getWeatherInfo(cityId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxJavaObserver<BaseResponse<WeatherInfo>>((Activity) mainView) {
                    @Override
                    public void onNext(BaseResponse<WeatherInfo> weatherInfoBaseResponse) {
                        if (weatherInfoBaseResponse.getRetCode() == 0){
                            if (weatherInfoBaseResponse.getData() != null){
                                mainView.setTextView(weatherInfoBaseResponse.getData().getWeatherinfo().toString());
                            }
                            mainView.openOther();
                        }
                    }
                });
    }
}
