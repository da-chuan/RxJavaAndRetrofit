package com.chuan.rxjavaandretrofit.wiget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.callback.IFooterCallBack;
import com.chuan.rxjavaandretrofit.R;

/**
 * Created by admin on 2017/3/20.
 */

public class MyXRefreshViewFooter extends LinearLayout implements IFooterCallBack{
    public MyXRefreshViewFooter(Context context) {
        this(context,null);
    }

    public MyXRefreshViewFooter(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyXRefreshViewFooter(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        View view = View.inflate(getContext(), R.layout.my_header, this);

    }



    @Override
    public void callWhenNotAutoLoadMore(XRefreshView xRefreshView) {

    }

    @Override
    public void onStateReady() {

    }

    @Override
    public void onStateRefreshing() {

    }

    @Override
    public void onReleaseToLoadMore() {

    }

    @Override
    public void onStateFinish(boolean hidefooter) {

    }

    @Override
    public void onStateComplete() {

    }

    @Override
    public void show(boolean show) {

    }

    @Override
    public boolean isShowing() {
        return false;
    }

    @Override
    public int getFooterHeight() {
        return 0;
    }
}
