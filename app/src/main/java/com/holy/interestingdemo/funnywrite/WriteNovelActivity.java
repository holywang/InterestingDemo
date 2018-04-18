package com.holy.interestingdemo.funnywrite;

import android.app.FragmentTransaction;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.designpattern.factorypattern.base.INovels;
import com.holy.interestingdemo.funnywrite.fragments.NovelListFragment;
import com.holy.interestingdemo.mainInfo.BaseActivity;

public class WriteNovelActivity extends BaseActivity {

    public static final String TAG = "WriteNovelActivity";

    private FloatingActionButton fab;
    private Toolbar toolbar;
    private FragmentTransaction transaction;

    private NovelListFragment novelListFragment;

    private INovels data;

    @Override
    public void toSetContentView() {
        setContentView(R.layout.activity_write_novel);
    }

    @Override
    public void initViews() {
        toolbar = findViewById(R.id.toolbar);
        fab = findViewById(R.id.fab);
    }

    @Override
    public void setListener() {
        fab.setOnClickListener(view -> {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        });
    }

    @Override
    public void doSth() {
        data = (INovels) getIntent().getSerializableExtra("novel");
        toolbar.setTitle(data.getNovel_name());
        setSupportActionBar(toolbar);
        setFragment();
    }

    private void setFragment() {
        transaction = getFragmentManager().beginTransaction();
        novelListFragment = NovelListFragment.newInstance(data);
        transaction.add(R.id.write_novel_under_part, novelListFragment, "first").commit();
    }


}
