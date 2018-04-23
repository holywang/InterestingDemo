package com.holy.interestingdemo.mainInfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.holy.interestingdemo.annotations.BindViewInstaller;

/**
 * Created by DR on 2018/4/18.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BindViewInstaller.initBindView(this);
        getInstanceState(savedInstanceState);
        toSetContentView();
        initViews();
        setListener();
        doSth();
    }
    public abstract void toSetContentView();
    public abstract void initViews();
    public abstract void setListener();
    public abstract void doSth();
    public void getInstanceState(Bundle savedInstanceState){}

}
