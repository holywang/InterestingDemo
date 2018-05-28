package com.holy.netmodule;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DR on 2018/5/28.
 */

public class Net implements NetFunctionInterface {


    @Override
    public <T> T get(Class<T> clz, String uri) {
        return new Retrofit.Builder()
                .baseUrl(uri)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(clz);
    }

    @Override
    public <T> T post(Class<T> clz, String uri, Object data) {
        return null;
    }
}
