package com.chuan.rxjavaandretrofit.view.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.chuan.rxjavaandretrofit.R;
import com.chuan.rxjavaandretrofit.bean.base.BaseBean;
import com.chuan.rxjavaandretrofit.presenter.INamePresenter;
import com.chuan.rxjavaandretrofit.presenter.NamePresenter;
import com.chuan.rxjavaandretrofit.view.activity.base.BaseListActivity;

import java.util.List;

/**
 * Created by admin on 2017/3/16.
 */

public class NameListActivity extends BaseListActivity implements INameView {

    private INamePresenter iNamePresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iNamePresenter = new NamePresenter(this);
        iNamePresenter.getAllNames();
    }

    @Override
    public BaseRecyclerAdapter createAdapter() {
        return new NameAdapter();
    }

    @Override
    public boolean setTitle(TextView title) {
        title.setText("names");
        return true;
    }

    @Override
    public void onRefresh() {
        iNamePresenter.getAllNames();
    }

    @Override
    public void onLoadMore(boolean isSilence) {
        iNamePresenter.getAllNames();
    }

    @Override
    public void addLoadData(final List<BaseBean> weatherInfos) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                addData(weatherInfos);
                mXRefreshView.stopRefresh();
            }
        });

    }


    class NameAdapter extends BaseRecyclerAdapter<NameViewHolder>{

        @Override
        public NameViewHolder getViewHolder(View view) {
            return new NameViewHolder(view,false);
        }

        @Override
        public NameViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
            View itemView = View.inflate(NameListActivity.this,R.layout.item_layout, null);
            return new NameViewHolder(itemView, isItem);
        }

        @Override
        public void onBindViewHolder(NameViewHolder holder, int position, List<Object> payloads) {
            if (payloads.isEmpty()){
                onBindViewHolder(holder, position);
            }else {
                holder.textView.setText((String)payloads.get(0));
            }
        }


        @Override
        public void onBindViewHolder(NameViewHolder holder, int position, boolean isItem) {
            holder.textView.setText(mList.get(0).toString());
        }

        @Override
        public int getAdapterItemCount() {
            return mList.size();
        }
    }


    class NameViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public NameViewHolder(View itemView, boolean isItem) {
            super(itemView);
            if (isItem)
                textView = (TextView) itemView.findViewById(R.id.item_tv);
        }
    }


    @Override
    protected boolean initRightIcon(ImageView iv, TextView tv) {
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.getLayoutManager().smoothScrollToPosition(recyclerView, null, 18);
            }
        });
        return true;
    }
}
