package com.holy.interestingdemo.mainInfo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by DR on 2018/4/17.
 */

public abstract class BaseFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = setInflateView(inflater,container,savedInstanceState);
        initViews(view);
        setListener();
        doSth();
        return view;
    }

    public abstract View setInflateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState);
    public abstract void initViews(View view);
    public abstract void setListener();
    public abstract void doSth();


}
