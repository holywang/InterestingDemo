package com.holy.interestingdemo.funnywrite;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.funnywrite.fragments.NovelListFragment;
import com.holy.interestingdemo.funnywrite.fragments.NovelWriteFragment;

public class WriteNovelActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private FragmentTransaction fragmentTransaction;

    private NovelListFragment novelListFragment;
    private NovelWriteFragment novelWriteFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_novel);
        initView();
        setListener();
        setFragments();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = findViewById(R.id.fab);
    }

    private void setListener() {
        fab.setOnClickListener(view -> {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            novelWriteFragment = new NovelWriteFragment();
            fragmentTransaction.hide(novelListFragment);
            fragmentTransaction.add(R.id.write_novel_under_part,novelWriteFragment);
        });
    }


    private void setFragments() {
        //获取到FragmentManager，在V4包中通过getSupportFragmentManager，
        //在系统中原生的Fragment是通过getFragmentManager获得的。
        FragmentManager FM = getFragmentManager();
        //2.开启一个事务，通过调用beginTransaction方法开启。
        fragmentTransaction = FM.beginTransaction();
        //把自己创建好的fragment创建一个对象
        novelListFragment = new NovelListFragment();
        //向容器内加入Fragment，一般使用add或者replace方法实现，需要传入容器的id和Fragment的实例。
        fragmentTransaction.add(R.id.write_novel_under_part, novelListFragment);
        //提交事务，调用commit方法提交。
        fragmentTransaction.commit();
    }
}
