package com.holy.insidescrollpage.pages.model;

import com.holy.insidescrollpage.databean.AndroidBean;
import com.holy.insidescrollpage.databean.FuLiBean;
import com.holy.insidescrollpage.databean.WebBean;
import rx.Observable;

/**
 * Created by DR on 2018/5/28.
 */

public interface DataModel {

    Observable<AndroidBean> getAndroidData(int page, int number);
    Observable<FuLiBean> getFuliData(int page,int number);
    Observable<WebBean> getWebData(int page,int number);
 }
