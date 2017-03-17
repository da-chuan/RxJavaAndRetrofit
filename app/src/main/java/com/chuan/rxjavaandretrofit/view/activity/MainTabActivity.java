package com.chuan.rxjavaandretrofit.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.chuan.rxjavaandretrofit.R;
import com.chuan.rxjavaandretrofit.view.activity.base.BaseActivity;

public class MainTabActivity extends BaseActivity {

    private BottomNavigationBar navigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab);
        navigationBar = (BottomNavigationBar) findViewById(R.id.main_tab);
        initTab(navigationBar);
    }

    @Override
    public boolean setTitle(TextView title) {
        return true;
    }

    @Override
    public View setCurrentContentView() {
        return View.inflate(getApplicationContext(),R.layout.activity_main_tab,null);
    }

    private void initTab(BottomNavigationBar navigationBar) {
        BottomNavigationItem item = new BottomNavigationItem(android.R.drawable.ic_menu_edit,"编辑");
        item.setBadgeItem(initBadgeItem());
        navigationBar
                .setInActiveColor("#FFFFFF")
                .setActiveColor("#FF4081")
                .setBarBackgroundColor("#303F9F")
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT)
                .addItem(new BottomNavigationItem(android.R.drawable.ic_menu_mapmode,"图片"))
                .addItem(new BottomNavigationItem(android.R.drawable.ic_menu_compass,"荣耀"))
                .addItem(item)
                .addItem(new BottomNavigationItem(android.R.drawable.ic_menu_myplaces,"我的"))
                .setFirstSelectedPosition(0)
                .initialise();


    }


    private BadgeItem initBadgeItem(){
        BadgeItem badge = new BadgeItem()
                .setBackgroundColor("#ff0000")
                .setBorderWidth(2)
                .setText(9+"+")
                .setTextColor("#ffffff")
                .setAnimationDuration(500)
                .setHideOnSelect(true);
        return badge;
    }


}
