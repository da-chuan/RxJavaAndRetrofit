package com.chuan.rxjavaandretrofit.service;

import com.chuan.rxjavaandretrofit.bean.User;
import com.chuan.rxjavaandretrofit.bean.WeatherInfo;
import com.chuan.rxjavaandretrofit.bean.base.BaseResponse;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by admin on 2017/3/17.
 */

public interface ApiService {

    @GET("sk/{cityid}")
    Observable<BaseResponse<WeatherInfo>> getWeatherInfo(@Path("cityid") String cityId);

    @POST
    Observable<BaseResponse<User>> getUserById(@Field("userId") String userId);


}
