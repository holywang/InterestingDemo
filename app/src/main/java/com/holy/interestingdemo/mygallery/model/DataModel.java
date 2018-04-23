package com.holy.interestingdemo.mygallery.model;

import com.holy.interestingdemo.network.bean.FuliBean;
import com.holy.interestingdemo.utils.NetUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/4/17.
 */

public class DataModel implements IDataModel {

    @Override
    public void getData(int number, int page, IDataCallback callback) {

        NetUtil.connectWithGankIO().getFuliInfo(number,page).enqueue(new Callback<FuliBean>() {
            @Override
            public void onResponse(Call<FuliBean> call, Response<FuliBean> response) {
               callback.returnData(FuliBean.class,response.body());

            }

            @Override
            public void onFailure(Call<FuliBean> call, Throwable t) {

            }
        });
    }

}
