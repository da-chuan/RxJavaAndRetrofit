package com.chuan.rxjavaandretrofit.net;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by admin on 2017/3/2.
 */

public class OKHttpUtils {
    private static volatile OkHttpClient client;
    private static volatile Headers headers;

    private static int READ_OUT_TIME = 100;
    private static int CONNECT_OUT_TIME = 80;

    private OKHttpUtils(){}

    public static OkHttpClient getOkHttpClient(){
        if (client == null){
            synchronized (OKHttpUtils.class){
                if (client == null){
                    OkHttpClient.Builder builder = new OkHttpClient.Builder()
                            .readTimeout(READ_OUT_TIME, TimeUnit.SECONDS)
                            .connectTimeout(CONNECT_OUT_TIME, TimeUnit.SECONDS)
                            .sslSocketFactory(HttpsCerts.getSocketFactory())
                            .hostnameVerifier(new HostnameVerifier() {
                                @Override
                                public boolean verify(String hostname, SSLSession session) {
                                    return true;
                                }
                            });
                    builder.addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request orgin_request = chain.request();
                            Request new_request = orgin_request.newBuilder()
                                    .headers(getHeaders())
                                    .method(orgin_request.method(),orgin_request.body())
                                    .build();
                            return chain.proceed(new_request);
                        }
                    });
                    client = builder.build();
                }
            }
        }
        return client;
    }

    private static Headers getHeaders(){
        if (headers == null){
            synchronized (OKHttpUtils.class){
                if (headers == null){
                    headers = new Headers.Builder()
                            .add("app","3")
                            .add("plate","and")
                            .add("product","10")
                            .add("abc","doub")
                            .build();
                }
            }
        }
        return headers;
    }



}
