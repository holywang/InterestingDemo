package com.holy.interestingdemo.funnywrite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toolbar;

import com.holy.interestingdemo.R;

/**
 * create by holy·wang 2018/01/18
 */
public class WriteActivity extends AppCompatActivity {

    private Toolbar title;
    private Button addBtn,listBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        initView();
        setListener();
    }

    private void initView(){
        title = findViewById(R.id.write_title);
        addBtn = findViewById(R.id.write_add_btn);
        listBtn = findViewById(R.id.write_list_btn);
    }

    private void setListener(){
        addBtn.setOnClickListener(view -> {
            Intent it = new Intent(WriteActivity.this,WriteAddActivity.class);
            startActivity(it);
        });
        listBtn.setOnClickListener(view -> {
            Intent it = new Intent(WriteActivity.this,WriteListActivity.class);
            startActivity(it);
        });
    }

}
