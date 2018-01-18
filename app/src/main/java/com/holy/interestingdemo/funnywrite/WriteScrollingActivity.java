package com.holy.interestingdemo.funnywrite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dd.CircularProgressButton;
import com.holy.interestingdemo.R;

/**
 * create by holy·wang 2018/01/18
 */
public class WriteScrollingActivity extends AppCompatActivity {
    CircularProgressButton writeCpb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_scrolling);

        writeCpb = findViewById(R.id.write_cpb);
        initListener();


    }

    public void initListener(){
        writeCpb.setOnClickListener(v -> {

        });
    }
}
