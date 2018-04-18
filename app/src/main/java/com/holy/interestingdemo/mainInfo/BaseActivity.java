package com.holy.interestingdemo.mainInfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by DR on 2018/4/18.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toSetContentView();
        initViews();
        setListener();
        doSth();
    }
    public abstract void toSetContentView();
    public abstract void initViews();
    public abstract void setListener();
    public abstract void doSth();

}
