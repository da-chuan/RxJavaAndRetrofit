package com.chuan.rxjavaandretrofit.view.activity;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.chuan.rxjavaandretrofit.R;
import com.chuan.rxjavaandretrofit.presenter.MainPresenter;
import com.chuan.rxjavaandretrofit.view.activity.base.BaseActivity;
import com.chuan.rxjavaandretrofit.view.activity.base.BaseListActivity;

public class MainActivity extends BaseActivity implements IMainView {

    private MainPresenter presenter;
    private ViewGroup current;
    private TextView textView;
    private BottomNavigationBar navigationBar;

    private void initNavigation() {
        navigationBar
                .setInActiveColor("#A5A5A5")
                .setActiveColor("#FF4081")
                .setBarBackgroundColor("#303F9F")
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT)
                .addItem(new BottomNavigationItem(android.R.drawable.ic_menu_mapmode,"图片"))
                .addItem(new BottomNavigationItem(android.R.drawable.ic_menu_compass,"荣耀"))
                .addItem(new BottomNavigationItem(android.R.drawable.ic_menu_edit,"编辑"))
                .addItem(new BottomNavigationItem(android.R.drawable.ic_menu_myplaces,"我的"))
                .setFirstSelectedPosition(0)
                .initialise();
    }

    @Override
    public boolean setTitle(TextView title) {
        title.setText("首页");
        return true;
    }

    @Override
    public View setCurrentContentView() {
        current = (ViewGroup) View.inflate(getApplicationContext(),R.layout.activity_main,null);
        textView = (TextView) current.findViewById(R.id.hell);
//        navigationBar = (BottomNavigationBar) current.findViewById(R.id.navigation_bar);
        presenter = new MainPresenter(this);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getWeatherInfo("101010100.html");
            }
        });
//        initNavigation();
        return current;
    }

    @Override
    public void setTextView(String msg) {
        textView.setText(msg);
        /*UserDao userDao = CustomApp.session.getUserDao();
        User user = userDao.queryBuilder().where(UserDao.Properties.Id.eq(12992L)).build().unique();
        if (user != null){
            textView.setText(user.getName()+user.getPassword());
        }*/
    }

    @Override
    public void openOther() {
        Intent intent = new Intent(MainActivity.this, NameListActivity.class);
//        Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
        intent.putExtra("url","https://www.baidu.com/");
        startActivity(intent);
    }


}
