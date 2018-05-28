package com.holy.insidescrollpage.pages.model;

import com.holy.insidescrollpage.constant.GankIOApis;
import com.holy.insidescrollpage.databean.AndroidBean;
import com.holy.insidescrollpage.databean.FuLiBean;
import com.holy.insidescrollpage.databean.WebBean;
import com.holy.insidescrollpage.interfaces.NetWork;
import com.holy.netmodule.Net;
import rx.Observable;


/**
 * Created by DR on 2018/5/28.
 */

public class IDataImpl implements DataModel {


    @Override
    public Observable<AndroidBean> getAndroidData(int page,int number) {
        return new Net().get(NetWork.class, GankIOApis.ANDROID_API).getAndroidInfo(number,page);
    }

    @Override
    public Observable<FuLiBean> getFuliData(int page,int number) {
        return new Net().get(NetWork.class, GankIOApis.FULI_API).getFuLiInfo(number,page);
    }

    @Override
    public Observable<WebBean> getWebData(int page,int number) {
        return new Net().get(NetWork.class, GankIOApis.WEB_API).getWebInfo(number,page);
    }
}
