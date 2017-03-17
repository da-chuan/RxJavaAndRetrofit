package com.chuan.rxjavaandretrofit.view.activity;

import com.chuan.rxjavaandretrofit.bean.WeatherInfo;
import com.chuan.rxjavaandretrofit.bean.base.BaseBean;

import java.util.List;

/**
 * Created by admin on 2017/3/16.
 */

public interface INameView {
    void addLoadData(List<BaseBean> weatherInfos);
}
