package com.chuan.rxjavaandretrofit.view.activity;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.chuan.rxjavaandretrofit.R;
import com.chuan.rxjavaandretrofit.view.activity.base.BaseActivity;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;

/**
 * Created by admin on 2017/3/3.
 */

public class WebViewActivity extends BaseActivity {

    private BridgeWebView webView;
    private ProgressBar progressBar;
    private TextView mTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url = getIntent().getStringExtra("url");
        webView.loadUrl(url);
    }

    @Override
    public boolean setTitle(TextView title) {
        this.mTitle = title;
        return true;
    }

    @Override
    public View setCurrentContentView() {
       View view = View.inflate(getApplicationContext(), R.layout.activity_webview, null);
       webView = (BridgeWebView) view.findViewById(R.id.webview);
       progressBar = (ProgressBar) view.findViewById(R.id.web_progress);
       initWebView();
       return view;
    }

    private void initWebView() {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setSupportZoom(true);
        settings.setDatabaseEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setNeedInitialFocus(true);
        settings.setSupportMultipleWindows(true);
        settings.setUseWideViewPort(true);
        if (Build.VERSION.SDK_INT >= 19) {
            settings.setLoadsImagesAutomatically(true);
        } else {
            settings.setLoadsImagesAutomatically(false);
        }
        webView.setWebChromeClient(new CustomChrome());
        webView.setWebViewClient(new CustomView());
        webView.registerHandler("cust",new Bridge());
    }

    class Bridge implements BridgeHandler {//js交互类
        @Override
        public void handler(String data, CallBackFunction function) {

        }
    }


    class CustomChrome extends WebChromeClient{
        @Override
        public void onReceivedTitle(WebView view, String title) {
            mTitle.setText(title);
        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            progressBar.setProgress(newProgress);
        }
    }
    class CustomView extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        }else {
            finish();
        }
    }
}
