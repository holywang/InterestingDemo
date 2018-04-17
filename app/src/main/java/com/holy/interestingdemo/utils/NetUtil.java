package com.holy.interestingdemo.utils;

import com.holy.interestingdemo.network.RetrofitInterface;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/3/20.
 */

public class NetUtil {

    //gank.io地址
    public final static String GANK_IO_URL = "http://gank.io/";

    public static RetrofitInterface connectWithGankIO() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GANK_IO_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(RetrofitInterface.class);

    }
}
