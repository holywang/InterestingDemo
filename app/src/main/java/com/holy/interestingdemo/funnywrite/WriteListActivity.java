package com.holy.interestingdemo.funnywrite;

import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.funnywrite.adapter.WriteListAdapter;
import com.holy.interestingdemo.funnywrite.bean.WritePageItemBean;
import com.holy.interestingdemo.listener.RecyclerViewOnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class WriteListActivity extends AppCompatActivity {

    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private List<WritePageItemBean> list;
    private WriteListAdapter adapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_list);
        initView();
        getData();
        doSth();
    }

    private void getData(){
        list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            WritePageItemBean writePageItemBean = new WritePageItemBean();
            writePageItemBean.setName("我的故事"+i);
            writePageItemBean.setPageNum(20);
            list.add(writePageItemBean);
        }
    }

    private void initView(){
        refreshLayout = findViewById(R.id.write_list_refresh);
        recyclerView = findViewById(R.id.write_list_list);
    }

    private void doSth(){
        if (list.isEmpty()) return;
        if (list.size()<=0) return;
        adapter = new WriteListAdapter(this,list);
        adapter.setOnItemClickListener(new RecyclerViewOnItemClickListener(){

            @Override
            public void onItemClick(View view, int position, Object data){
                Snackbar.make(view,list.get(position).getName(),Snackbar.LENGTH_SHORT).show();
            }
        });
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
