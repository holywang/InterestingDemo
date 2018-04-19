package com.holy.interestingdemo.funnywrite;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.designpattern.factorypattern.base.INovels;
import com.holy.interestingdemo.funnywrite.event.NovelListFragmentEvent;
import com.holy.interestingdemo.funnywrite.fragments.NovelListFragment;
import com.holy.interestingdemo.funnywrite.fragments.NovelWriteFragment;
import com.holy.interestingdemo.mainInfo.BaseActivity;
import com.holy.interestingdemo.utils.L;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class WriteNovelActivity extends BaseActivity {

    public static final String TAG = "WriteNovelActivity";

    private FloatingActionButton fab;
    private Toolbar toolbar;

    private NovelListFragment novelListFragment;
    private NovelWriteFragment novelWriteFragment;

    private INovels data;
    private boolean flag;

    @Override
    public void toSetContentView() {
        setContentView(R.layout.activity_write_novel);
        EventBus.getDefault().register(this);
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
        toolbar.setTitle(data.getNovelName());
        setSupportActionBar(toolbar);
        setFragment();
    }

    private void setFragment() {
        novelListFragment = NovelListFragment.newInstance(data);
        getFragmentManager()
                .beginTransaction()
                .add(R.id.write_novel_under_part, novelListFragment, "first")
                .commit();
    }

    @Subscribe(sticky = true)
    public void onMessageEvent(NovelListFragmentEvent event) {
        L.i(TAG, event.getAction());
        switch (event.getAction()) {
            case "add":
                flag = true;
                novelWriteFragment = NovelWriteFragment.newInstance(data.getNovelId(), "add");
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.write_novel_under_part, novelWriteFragment, "add")
                        .commit();
                break;
            case "read":
                flag = true;
                novelWriteFragment = NovelWriteFragment.newInstance(event.getData(), "read");
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.write_novel_under_part, novelWriteFragment, "read")
                        .commit();
                break;
            case "update":
                flag = true;
                novelWriteFragment = NovelWriteFragment.newInstance(event.getData(), "update");
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.write_novel_under_part, novelWriteFragment, "update")
                        .commit();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (flag) {
            flag = false;
            novelListFragment = NovelListFragment.newInstance(data);
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.write_novel_under_part, novelListFragment, "first")
                    .commit();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

}
