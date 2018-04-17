package com.holy.interestingdemo.mygallery.model;

/**
 * Created by Administrator on 2018/4/17.
 */

public interface IDataCallback {

    <T extends Object> T returnData(Class<T> clz,T t);
}
