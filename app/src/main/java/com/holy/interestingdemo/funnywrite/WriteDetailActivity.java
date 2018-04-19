package com.holy.interestingdemo.funnywrite;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.designpattern.factorypattern.base.INovels;
import com.holy.interestingdemo.funnywrite.database.DatabaseConstant;
import com.holy.interestingdemo.funnywrite.database.DatabaseManager;
import com.holy.interestingdemo.funnywrite.database.DatabaseUtils;

import java.util.List;
import java.util.Map;

public class WriteDetailActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private Toolbar toolbar;
    private Button write,read,file,statistics;
    private TextView title,style,des;

    private DatabaseManager databaseManager;
    private String novelId;
    private INovels data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_detail);
        databaseManager = new DatabaseManager(this);
        data = (INovels) getIntent().getSerializableExtra("data");
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
        statistics = findViewById(R.id.write_detail_statistics);

        title = findViewById(R.id.write_detail_title);
        style = findViewById(R.id.write_detail_style);
        des = findViewById(R.id.write_detail_des);

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
            writeNovel();
        });
        read.setOnClickListener(view -> {
            Snackbar.make(view,"读",Snackbar.LENGTH_LONG).show();
            readNovel();
        });
        file.setOnClickListener(view -> {
            Snackbar.make(view,"生成文件",Snackbar.LENGTH_LONG).show();
            getFile();
        });
        statistics.setOnClickListener(view -> getStatistics());
    }

    private void doSth(){
        novelId = data.getNovelId();
        title.setText(data.getNovelName());
        style.setText(data.getNovelStyle());
        des.setText(data.getNovelDescription());
    }

    /**
     * 写小说
     */
    private void writeNovel(){
        Intent wIntent = new Intent();
        wIntent.putExtra("novel",data);
        wIntent.setClass(this,WriteNovelActivity.class);
        startActivity(wIntent);
    }

    /**
     * 读小说
     */
    private void readNovel(){

    }

    /**
     * 生成文件
     */
    private void getFile(){

    }

    /**
     * 生成统计
     */
    private void getStatistics(){
        Intent wIntent = new Intent();
        wIntent.putExtra("novel",data);
        wIntent.setClass(this,WriteStatisticsActivity.class);
        startActivity(wIntent);
    }



}
