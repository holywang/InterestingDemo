package com.holy.interestingdemo.funnywrite;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
    private Fragment currentFragment;

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
//        getFragmentManager()
//                .beginTransaction()
//                .add(R.id.write_novel_under_part, novelListFragment, "first")
//                .commit();
        addNewFragment(novelListFragment,R.id.write_novel_under_part,"first");
    }

    @Subscribe(sticky = true)
    public void onMessageEvent(NovelListFragmentEvent event) {
        L.i(TAG, event.getAction());
        switch (event.getAction()) {
            case "add":
                Intent addIntent = new Intent(this, NovelWriteActivity.class);
                addIntent.putExtra("novel", data);
                addIntent.putExtra("action", "add");
                addIntent.putExtra("ifNone", event.isIfNone());
                startActivityForResult(addIntent, ADD_REQUEST_CODE);
                break;
            case "read":
                flag = true;
                novelShowFragment = NovelShowFragment.newInstance(event.getData().getNovelId(), "read");
//                getFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.write_novel_under_part, novelShowFragment, "second")
//                        .commit();
                addNewFragment(novelShowFragment,R.id.write_novel_under_part,"read");
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

    /**
     * 添加/或展示一个fragment
     * @param fragment 想要添加/展示的fragment
     * @param id 占位布局的ID
     * @param tag 打一个T啊，需要用这个Tag去搜索是否存在这个fragment
     */
    private <T extends Fragment> void addNewFragment( T fragment, int id, String tag) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //优先检查，fragment是否存在，避免重叠
        T tempFragment = (T)fragmentManager.findFragmentByTag(tag);

        if (tempFragment != null) {
            fragment = tempFragment;
        }

        if (fragment.isAdded()) {
            addOrShow(fragmentTransaction, fragment, id, tag);
        } else {
            if (currentFragment != null && currentFragment.isAdded()) {
                fragmentTransaction.hide(currentFragment).add(id, fragment, tag).commit();
            } else {
                fragmentTransaction.add(id, fragment, tag).commit();
            }
            currentFragment = fragment;
        }
    }

    /**
     * 添加/展示fragment方法
     * @param transaction fragment处理事务
     * @param fragment 想要添加/展示的fragment
     * @param id 占位布局的ID
     * @param tag fragment查询标识
     */
    private <T extends Fragment> void addOrShow(FragmentTransaction transaction, T fragment, int id, String tag) {
        if (currentFragment == fragment)
            return;
        if (!fragment.isAdded()) { // 如果当前fragment未被添加，则添加到Fragment管理器中
            transaction.hide(currentFragment).add(id, fragment, tag).commit();
        } else {
            transaction.hide(currentFragment).show(fragment).commit();
        }
        currentFragment.setUserVisibleHint(false);
        currentFragment = fragment;
        currentFragment.setUserVisibleHint(true);
    }
}
