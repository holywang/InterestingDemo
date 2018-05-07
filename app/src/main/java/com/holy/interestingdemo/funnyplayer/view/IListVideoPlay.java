package com.holy.interestingdemo.funnyplayer.view;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by DR on 2018/5/7.
 */

public interface IListVideoPlay {

    void showSnackBar(String text,View view);
    void showLoading(ViewGroup rootView);
    void hideLoading();
}
