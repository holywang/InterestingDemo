package com.holy.netmodule;

/**
 * Created by DR on 2018/5/28.
 */

public interface NetFunctionInterface{
      <T> T get(Class<T> clz, String uri);
      <T> T post(Class<T> clz,String uri,Object data);
}
