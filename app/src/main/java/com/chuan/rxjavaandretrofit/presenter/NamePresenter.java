package com.chuan.rxjavaandretrofit.presenter;

import android.os.SystemClock;

import com.chuan.rxjavaandretrofit.bean.User;
import com.chuan.rxjavaandretrofit.bean.base.BaseBean;
import com.chuan.rxjavaandretrofit.view.activity.INameView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/16.
 */

public class NamePresenter extends INamePresenter{

    private INameView mINameView;

    public NamePresenter(INameView iNameView){
        mINameView = iNameView;
    }

    @Override
    public void getAllNames() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1000);
                List<BaseBean> list = new ArrayList<>();
                list.add(new User(12L, "name1", "pwd"));
                list.add(new User(13L, "name2", "pwd"));
                list.add(new User(14L, "name3", "pwd"));
                mINameView.addLoadData(list);
            }
        }).start();

    }
}
