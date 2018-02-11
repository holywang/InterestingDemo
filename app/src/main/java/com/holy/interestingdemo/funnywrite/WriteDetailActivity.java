package com.holy.interestingdemo.funnywrite;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.funnywrite.bean.WritePageItemBean;
import com.holy.interestingdemo.funnywrite.database.DatabaseConstant;
import com.holy.interestingdemo.funnywrite.database.DatabaseManager;
import com.holy.interestingdemo.funnywrite.database.DatabaseUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WriteDetailActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private Toolbar toolbar;
    private Button write,read,file;
    private TextView title,style,des;

    private DatabaseManager databaseManager;
    private String novelId;
    private Map<String,String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_detail);
        databaseManager = new DatabaseManager(this);
        getData();
        initView();
        setListener();
        doSth();
    }

    private void initView(){
        fab = findViewById(R.id.fab);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        write = findViewById(R.id.write_detail_write);
        read = findViewById(R.id.write_detail_read);
        file = findViewById(R.id.write_detail_file);

        title = findViewById(R.id.write_detail_title);
        style = findViewById(R.id.write_detail_style);
        des = findViewById(R.id.write_detail_des);

    }

    private void getData(){
        List<Map<String,String>> list = getDataFromSQLite();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("novel_id").equals(novelId)){
                data = list.get(i);
                break;
            }
        }
    }

    private void setListener(){
        fab.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(WriteDetailActivity.this);
            builder.setTitle("删除该小说");
            builder.setPositiveButton("删除", (dialogInterface, i) -> {
                databaseManager.delete(DatabaseConstant.NOVEL_INFO_TABLE,
                        DatabaseConstant.NOVEL_INFO_ARRAY[0],
                        new String[]{novelId});
                finish();
            });
            builder.setNegativeButton("取消",null);
            builder.create().show();
        });
        write.setOnClickListener(view -> {
            Snackbar.make(view,"写",Snackbar.LENGTH_LONG).show();
        });
        read.setOnClickListener(view -> {
            Snackbar.make(view,"读",Snackbar.LENGTH_LONG).show();
        });
        file.setOnClickListener(view -> {
            Snackbar.make(view,"生成文件",Snackbar.LENGTH_LONG).show();
        });
    }

    private void doSth(){

        Intent lastPageDataIntent = getIntent();
        novelId = ((WritePageItemBean)lastPageDataIntent.getSerializableExtra("data")).getNovelId();

        title.setText(data.get("novel_name"));
        style.setText(data.get("novel_style"));
        des.setText(data.get("novel_description"));
    }

    /**
     * 查库获取数据
     * @return
     */
    private List<Map<String ,String>> getDataFromSQLite(){
        String table = DatabaseConstant.NOVEL_INFO_TABLE;
        Cursor cs = databaseManager.queryAll(table);
        List<Map<String ,String>> dataList = DatabaseUtils.getList(cs,table);
        return dataList;
    }

}
