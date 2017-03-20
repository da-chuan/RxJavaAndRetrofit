package com.chuan.rxjavaandretrofit.wiget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andview.refreshview.callback.IHeaderCallBack;
import com.chuan.rxjavaandretrofit.R;

/**
 * Created by admin on 2017/3/20.
 */

public class MyXRefreshViewHeader extends LinearLayout implements IHeaderCallBack {

    private TextView headerState;

    public MyXRefreshViewHeader(Context context) {
        this(context,null);
    }

    public MyXRefreshViewHeader(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyXRefreshViewHeader(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    private void initView(){
        View container = View.inflate(getContext(), R.layout.my_header, this);
        headerState = (TextView) container.findViewById(R.id.header_tv);
    }

    @Override
    public void onStateNormal() {
        headerState.setText("下拉刷新");
    }

    @Override
    public void onStateReady() {
        headerState.setText("松开刷新");
    }

    @Override
    public void onStateRefreshing() {
        headerState.setText("正在刷新");
    }

    @Override
    public void onStateFinish(boolean success) {
        headerState.setText(success?"刷新成功":"刷新失败");
    }

    @Override
    public void onHeaderMove(double headerMovePercent, int offsetY, int deltaY) {

    }

    @Override
    public void setRefreshTime(long lastRefreshTime) {

    }

    @Override
    public void hide() {
        setVisibility(GONE);
    }

    @Override
    public void show() {
        setVisibility(VISIBLE);
    }

    @Override
    public int getHeaderHeight() {
        return getMeasuredHeight();
    }
}
