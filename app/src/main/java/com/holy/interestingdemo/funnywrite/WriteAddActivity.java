package com.holy.interestingdemo.funnywrite;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.holy.interestingdemo.R;

public class WriteAddActivity extends Activity {

    private EditText name,style,author,desc;
    private Button addFace,submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_add);
        initView();
        initOnClickListener();
    }

    private void initView(){
        name = findViewById(R.id.write_add_name);
        style = findViewById(R.id.write_add_style);
        author = findViewById(R.id.write_add_author);
        desc = findViewById(R.id.write_add_des);
        addFace = findViewById(R.id.write_add_image);
        submit = findViewById(R.id.write_add_submit);
    }

    private void initOnClickListener(){
        addFace.setOnClickListener(view -> {

        });
        submit.setOnClickListener(view -> {

        });
    }
}
