package com.holy.interestingdemo.network;

import com.holy.interestingdemo.network.bean.FuliBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2018/3/20.
 */

public interface RetrofitInterface {

    /**
     * 福利接口
     * http://gank.io/api/data/福利/10/1
     * @param number 请求个数： 数字，大于0
     * @param page 数字，大于0
     * @return
     */
    @GET("api/data/福利/{number}/{page}")
    Call<FuliBean> getFuliInfo(@Path("number")int number,@Path("page")int page);



}
