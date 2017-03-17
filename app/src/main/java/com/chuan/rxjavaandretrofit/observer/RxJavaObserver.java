package com.chuan.rxjavaandretrofit.observer;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.chuan.rxjavaandretrofit.app.CustomApp;
import com.chuan.rxjavaandretrofit.wiget.LoaddingProgressDialog;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by admin on 2017/3/14.
 */

public abstract class RxJavaObserver<T> implements Observer<T> {

    private Activity mActivity;
    private boolean mShowDialog;

    private Disposable mDisposable;
    private LoaddingProgressDialog progressDialog;


    public RxJavaObserver(Activity context){
        this(context,false);
    }

    public RxJavaObserver(Activity context, boolean showDialog){
        mActivity = context;
        mShowDialog = showDialog;
        progressDialog = new LoaddingProgressDialog(context);
        progressDialog.setCancelable(false);
    }

    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;
        if (mShowDialog && progressDialog != null && !progressDialog.isShowing()){
            progressDialog.show();
        }
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof SocketTimeoutException){
            Toast.makeText(mActivity,"网络异常",Toast.LENGTH_SHORT).show();
        }else if (e instanceof ConnectException){
            Toast.makeText(mActivity,"网络异常",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(CustomApp.getInstance(),e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        mDisposable.dispose();
    }

    @Override
    public void onComplete() {
        mDisposable.dispose();
        if (progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }
}
