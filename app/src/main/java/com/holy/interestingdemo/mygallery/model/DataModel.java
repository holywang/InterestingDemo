package com.holy.interestingdemo.mygallery.model;

import com.holy.interestingdemo.network.bean.FuliBean;
import com.holy.interestingdemo.utils.NetUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/4/17.
 */

public class DataModel implements IDataModel {

    @Override
    public void getData(int number, int page, IDataCallback callback) {

        NetUtil.connectWithGankIO()
                .getFuliInfo(number,page)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<FuliBean>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(FuliBean fuliBean) {
                        callback.returnData(FuliBean.class,fuliBean);
                    }
                });
    }

}
