package com.chuan.rxjavaandretrofit.app;

import android.app.Application;

import com.chuan.rxjavaandretrofit.bean.DaoMaster;
import com.chuan.rxjavaandretrofit.bean.DaoSession;
import com.chuan.rxjavaandretrofit.bean.User;
import com.chuan.rxjavaandretrofit.bean.UserDao;

/**
 * Created by admin on 2017/3/13.
 */

public class CustomApp extends Application {

    public static DaoSession session;

    public static CustomApp INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        initDaoSession();
        INSTANCE = this;
    }

    private void initDaoSession(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"chuan.db");
        DaoMaster master = new DaoMaster(helper.getWritableDb());
        session = master.newSession();
        UserDao dao = session.getUserDao();
        User user = new User(12992L,"xiao ming","password");
        dao.insertOrReplace(user);
    }


    public static Application getInstance(){
        return INSTANCE;
    }


}
