package com.holy.interestingdemo.listener;

import android.view.View;

import com.holy.interestingdemo.interfaces.RecyclerViewOnItemClick;

/**
 * Created by DR on 2018/1/27.
 */
public class RecyclerViewOnItemClickListener implements RecyclerViewOnItemClick{

    @Override
    public void onItemClick(View view, int position, Object data) {
        throw new RuntimeException("Stub!");
    }
}
