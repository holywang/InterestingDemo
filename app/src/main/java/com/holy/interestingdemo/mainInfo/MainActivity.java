package com.holy.interestingdemo.mainInfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.mainInfo.adapter.MainPageAdapter;
import com.holy.interestingdemo.funnywrite.WriteActivity;
import com.holy.interestingdemo.mainInfo.listener.RecyclerViewOnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * created by holy·wang 2018/01/18
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private LinearLayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initAdapter();
    }

    private void initView(){
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView = findViewById(R.id.button_List);
        recyclerView.setLayoutManager(mLayoutManager);
    }

    private void initAdapter(){
        List<String> list = new ArrayList<>();
        list.add("神奇的小说编辑器");

        MainPageAdapter adapter = new MainPageAdapter(this,list);
        adapter.setOnItemClickListener(new RecyclerViewOnItemClickListener(){
            @Override
            public void onItemClick(View view, int position, Object data) {
                Intent it = new Intent();
                switch (position){
                    case 0:
                        it.setClass(MainActivity.this, WriteActivity.class);
                        break;
                }
                startActivity(it);
            }
        });
        recyclerView.setAdapter(adapter);

    }
}
