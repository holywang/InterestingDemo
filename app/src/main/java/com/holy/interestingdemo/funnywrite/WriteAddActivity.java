package com.holy.interestingdemo.funnywrite;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.funnywrite.database.DatabaseConstant;
import com.holy.interestingdemo.funnywrite.database.DatabaseManager;
import com.holy.interestingdemo.funnywrite.database.DatabaseUtils;


public class WriteAddActivity extends Activity {

    private EditText name,author,desc;
    private Spinner style;
    private Button addFace,submit;
    private DatabaseManager databaseManager;

    private String styleText = "";
    private String iamgeUri = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_add);
        setDatabase();
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
        addFace.setOnClickListener(view -> iamgeUri = "image");

        submit.setOnClickListener(view -> {
            if(!checkNull(name.getText().toString(),styleText,author.getText().toString(),desc.getText().toString(),name.getText().toString())) {
                Snackbar.make(view, "您有一栏没填", Snackbar.LENGTH_LONG).show();
                return;
            }
            String[] data = {
                    ""+System.currentTimeMillis(),
                    name.getText().toString(),
                    author.getText().toString(),
                    styleText,
                    desc.getText().toString(),
                    iamgeUri,
            };
            long a = databaseManager.insert(DatabaseConstant.NOVEL_INFO_TABLE, DatabaseUtils.putValue(DatabaseConstant.NOVEL_INFO_ARRAY,data));
            if (a < 0){
                Snackbar.make(view,"添加失败请重新添加",Snackbar.LENGTH_LONG).show();
                return;
            }
            Snackbar.make(view,"添加成功",Snackbar.LENGTH_LONG).show();

        });

        style.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                styleText = getResources().getStringArray(R.array.novel_type)[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                styleText = "";
            }
        });
    }

    /**
     * 打开数据库
     */
    private void setDatabase(){
        databaseManager = new DatabaseManager(this);
    }

    /**
     * 检查输入是否有空
     * @param values
     * @return
     */
    private boolean checkNull(String... values){
        for (String str:values){
            if (("").equals(str))
                return false;
        }
        return true;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
