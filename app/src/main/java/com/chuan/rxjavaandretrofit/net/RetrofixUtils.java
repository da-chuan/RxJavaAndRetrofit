package com.chuan.rxjavaandretrofit.net;

import com.chuan.rxjavaandretrofit.api.URLConstant;
import com.chuan.rxjavaandretrofit.service.ApiService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2017/3/2.
 */

public class RetrofixUtils {

    public static ApiService getRetrofit(String baseUrl){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .callFactory(OKHttpUtils.getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiService.class);
    }

    public static ApiService getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLConstant.CITY_WEATHER)
                .callFactory(OKHttpUtils.getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiService.class);
    }

}
