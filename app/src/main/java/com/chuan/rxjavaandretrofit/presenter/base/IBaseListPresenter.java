package com.chuan.rxjavaandretrofit.presenter.base;

import com.chuan.rxjavaandretrofit.bean.base.BaseBean;

import java.util.List;

/**
 * Created by admin on 2017/3/16.
 */

public abstract class IBaseListPresenter {

    public abstract void refreshPage();

    public abstract List<BaseBean> loadMore();

}
