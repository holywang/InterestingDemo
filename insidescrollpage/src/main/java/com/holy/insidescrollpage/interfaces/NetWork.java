package com.holy.insidescrollpage.interfaces;

import com.holy.insidescrollpage.databean.AndroidBean;
import com.holy.insidescrollpage.databean.FuLiBean;
import com.holy.insidescrollpage.databean.WebBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by DR on 2018/5/28.
 */

public interface NetWork {

    /**
     * 获取福利接口的数据
     * @param number 个数
     * @param page 页码
     * @return
     */
    @GET("{number}/{page}")
    Observable<FuLiBean> getFuLiInfo(@Path("number")int number, @Path("page")int page);

    /**
     * 获取Android接口数据
     * @param number
     * @param page
     * @return
     */
    @GET("{number}/{page}")
    Observable<AndroidBean> getAndroidInfo(@Path("number")int number, @Path("page")int page);

    /**
     * 获取Web前端接口数据
     * @param number
     * @param page
     * @return
     */
    @GET("{number}/{page}")
    Observable<WebBean> getWebInfo(@Path("number")int number, @Path("page")int page);
}
