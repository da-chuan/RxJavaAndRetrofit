package com.chuan.rxjavaandretrofit.wiget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.callback.IFooterCallBack;
import com.chuan.rxjavaandretrofit.R;

/**
 * Created by admin on 2017/3/20.
 */

public class MyXRefreshViewFooter extends LinearLayout implements IFooterCallBack{

    private View view;
    private TextView textView;

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
        view = View.inflate(getContext(), R.layout.my_header, this);
        textView = (TextView) view.findViewById(R.id.header_tv);
    }



    @Override
    public void callWhenNotAutoLoadMore(XRefreshView xRefreshView) {

    }

    @Override
    public void onStateReady() {
        textView.setText("上啦加载更多");
    }

    @Override
    public void onStateRefreshing() {
        textView.setText("加载中。。。");
    }

    @Override
    public void onReleaseToLoadMore() {
        textView.setText("释放开始加载");
    }

    @Override
    public void onStateFinish(boolean hidefooter) {
        textView.setText("加载完成");
    }

    @Override
    public void onStateComplete() {
        RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) view.getLayoutParams();
        lp.height = 0;
        view.setLayoutParams(lp);
    }

    @Override
    public void show(boolean show) {
        RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) view.getLayoutParams();
        lp.height = LayoutParams.WRAP_CONTENT;
        view.setLayoutParams(lp);
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
