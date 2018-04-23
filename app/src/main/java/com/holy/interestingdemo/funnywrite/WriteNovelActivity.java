package com.holy.interestingdemo.funnywrite;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.designpattern.factorypattern.base.INovels;
import com.holy.interestingdemo.funnywrite.event.NovelListFragmentEvent;
import com.holy.interestingdemo.funnywrite.fragments.NovelListFragment;
import com.holy.interestingdemo.funnywrite.fragments.NovelShowFragment;
import com.holy.interestingdemo.mainInfo.BaseActivity;
import com.holy.interestingdemo.utils.L;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class WriteNovelActivity extends BaseActivity {

    public static final String TAG = "WriteNovelActivity";

    public static final int ADD_REQUEST_CODE = 101;
    public static final int UPDATE_REQUEST_CODE = 102;

    private FloatingActionButton fab;
    private Toolbar toolbar;

    private NovelListFragment novelListFragment;
    private NovelShowFragment novelShowFragment;

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
                Intent addIntent = new Intent(this, NovelWriteActivity.class);
                addIntent.putExtra("novel", data);
                addIntent.putExtra("action", "add");
                addIntent.putExtra("ifNone",event.isIfNone());
                startActivityForResult(addIntent, ADD_REQUEST_CODE);
                break;
            case "read":
                flag = true;
                novelShowFragment = NovelShowFragment.newInstance(event.getData().getNovelId(), "read");
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.write_novel_under_part, novelShowFragment, "second")
                        .commit();
                break;
            case "update":
                Intent updateIntent = new Intent(this, NovelWriteActivity.class);
                updateIntent.putExtra("novel", data);
                updateIntent.putExtra("action", "update");
                startActivityForResult(updateIntent, UPDATE_REQUEST_CODE);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



    }

    @Override
    public void onClick(View v) {

    }
}
