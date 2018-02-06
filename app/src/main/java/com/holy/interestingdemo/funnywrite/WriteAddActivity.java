package com.holy.interestingdemo.funnywrite;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.funnywrite.bean.NovelInfoBean;

import io.realm.Realm;
import io.realm.Realm.Callback;
import io.realm.RealmAsyncTask;
import io.realm.RealmConfiguration;

public class WriteAddActivity extends Activity {

    private EditText name,style,author,desc;
    private Button addFace,submit;
    private Realm realm;

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
        addFace.setOnClickListener(view -> {

        });
        submit.setOnClickListener(view -> {
            NovelInfoBean newNovel = new NovelInfoBean();

        });
    }

    /**
     * 打开数据库
     */
    private void setDatabase(){
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("novel.realm") //文件名
                .schemaVersion(0) //版本号
                .build();
        realm = Realm.getInstance(config);
    }

    /**
     * 添加一本小说进数据库里
     * @param bean
     * @param callback
     */
    private void add(NovelInfoBean bean,Callback callback) {
        RealmAsyncTask transaction = realm.executeTransactionAsync(
                realm -> {

                }, () -> {
                    //成功回调
                }, error -> {
                    //失败回调
                });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close the Realm instance.
        realm.close();
    }
}
