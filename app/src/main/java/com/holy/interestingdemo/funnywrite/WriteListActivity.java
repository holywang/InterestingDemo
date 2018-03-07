package com.holy.interestingdemo.funnywrite;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.funnywrite.adapter.WriteListAdapter;
import com.holy.interestingdemo.funnywrite.bean.WritePageItemBean;
import com.holy.interestingdemo.funnywrite.database.DatabaseConstant;
import com.holy.interestingdemo.funnywrite.database.DatabaseManager;
import com.holy.interestingdemo.funnywrite.database.DatabaseUtils;
import com.holy.interestingdemo.mainInfo.listener.RecyclerViewOnItemClickListener;
import com.holy.interestingdemo.mainInfo.listener.RecyclerViewUpLoadingListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WriteListActivity extends AppCompatActivity {

    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private List<WritePageItemBean> list;
    private WriteListAdapter adapter;
    private LinearLayoutManager mLayoutManager;
    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_list);
        initView();
        getData();
        doSth();
    }

    private void getData(){
        databaseManager = new DatabaseManager(this);
        list = getDataFromSQLite(new ArrayList<>());
    }

    private void initView(){
        refreshLayout = findViewById(R.id.write_list_refresh);
        recyclerView = findViewById(R.id.write_list_list);
    }

    private void doSth(){
        refreshLayout.setColorSchemeResources(
                R.color.colorAccent,R.color.colorPrimary
        );
        if (list.isEmpty()) return;
        if (list.size()<=0) return;
        adapter = new WriteListAdapter(this,list);
        adapter.setOnItemClickListener(new RecyclerViewOnItemClickListener(){
            @Override
            public void onItemClick(View view, int position, Object data){
                Intent it = new Intent();
                it.setClass(WriteListActivity.this,WriteDetailActivity.class);
                it.putExtra("data",(WritePageItemBean)data);
                startActivity(it);
            }
        });
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        refreshLayout.setOnRefreshListener(() -> {
            list.clear();
            getData();
        });
        recyclerView.addOnScrollListener(new RecyclerViewUpLoadingListener(mLayoutManager){
            @Override
            public void onLoadMore(int currentPage) {

            }
        });
    }

    /**
     * 查库填数据
     * @param list
     * @return
     */
    private List<WritePageItemBean> getDataFromSQLite(List<WritePageItemBean> list){
        String table = DatabaseConstant.NOVEL_INFO_TABLE;
        Cursor cs = databaseManager.queryAll("NovelInfo");
        List<Map<String ,String>> dataList = DatabaseUtils.getList(cs,"NovelInfo");
        for (int i = 0; i < dataList.size(); i++) {
            WritePageItemBean writePageItemBean = new WritePageItemBean();
            writePageItemBean.setNovelId(dataList.get(i).get(DatabaseConstant.NOVEL_INFO_ARRAY[0]));
            writePageItemBean.setName(dataList.get(i).get(DatabaseConstant.NOVEL_INFO_ARRAY[1]));
            writePageItemBean.setType(dataList.get(i).get(DatabaseConstant.NOVEL_INFO_ARRAY[3]));
            writePageItemBean.setTitleImage(dataList.get(i).get(DatabaseConstant.NOVEL_INFO_ARRAY[5]));
            list.add(writePageItemBean);
        }
        return list;
    }
}
