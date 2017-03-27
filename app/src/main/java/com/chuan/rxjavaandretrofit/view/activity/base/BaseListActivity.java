package com.chuan.rxjavaandretrofit.view.activity.base;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.chuan.rxjavaandretrofit.R;
import com.chuan.rxjavaandretrofit.bean.base.BaseBean;
import com.chuan.rxjavaandretrofit.wiget.MyXRefreshViewFooter;
import com.chuan.rxjavaandretrofit.wiget.MyXRefreshViewHeader;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseListActivity extends BaseActivity implements XRefreshView.XRefreshViewListener {

    protected XRefreshView mXRefreshView;
    protected RecyclerView recyclerView;

    protected BaseRecyclerAdapter mAdapter;

    protected List<BaseBean> mList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View setCurrentContentView() {
        View current = View.inflate(getApplicationContext(), R.layout.activity_list,null);
        mXRefreshView = (XRefreshView) current.findViewById(R.id.xrefreshview);
        mXRefreshView.setPullLoadEnable(true);
        mXRefreshView.setPullRefreshEnable(true);
        mXRefreshView.setAutoLoadMore(false);
        mXRefreshView.setXRefreshViewListener(this);
        mXRefreshView.setCustomHeaderView(new MyXRefreshViewHeader(getApplicationContext()));
        recyclerView = (RecyclerView) current.findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mAdapter = createAdapter();
        recyclerView.setAdapter(mAdapter);
        return current;
    }

    public void setData(List<BaseBean> list){
        mList = list;
    }

    public void addData(List<BaseBean> list){
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    public abstract BaseRecyclerAdapter createAdapter();




    @Override
    public void onRefresh(boolean isPullDown) {

    }


    @Override
    public void onRelease(float direction) {

    }

    @Override
    public void onHeaderMove(double headerMovePercent, int offsetY) {

    }
}
