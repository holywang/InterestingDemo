package com.holy.interestingdemo.mainInfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;

import com.holy.insidescrollpage.pages.view.GankIOListActivity;
import com.holy.interestingdemo.R;
import com.holy.interestingdemo.eventbusdemo.EventBusActivity;
import com.holy.interestingdemo.funnyplayer.PlayerListActivity;
import com.holy.interestingdemo.funnywrite.WriteActivity;
import com.holy.interestingdemo.mainInfo.adapter.MainPageAdapter;
import com.holy.interestingdemo.mainInfo.listener.RecyclerViewOnItemClickListener;
import com.holy.interestingdemo.mp3player.MusicPlayerActivity;
import com.holy.interestingdemo.mygallery.view.PerfectGalleryActivity;
import com.holy.interestingdemo.tabItem.TabViewActivity;
import com.holy.interestingdemo.webview.WebViewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * created by holy·wang 2018/01/18
 */
public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainApplication.APP_TAG + "MainActivity";

    public static int PhoneWidth = 0;
    public static int PhoneHeight = 0;

    private RecyclerView recyclerView;

    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initAdapter();
        initPhoneWidthAndHeight();
    }

    private void initPhoneWidthAndHeight(){
        WindowManager wm = getWindowManager();
        PhoneWidth = wm.getDefaultDisplay().getWidth();
        PhoneHeight = wm.getDefaultDisplay().getHeight();
    }

    private void initView() {
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView = findViewById(R.id.button_List);
        recyclerView.setLayoutManager(mLayoutManager);
    }

    private void initAdapter() {
        List<String> list = new ArrayList<>();
        list.add("神奇的小说编辑器");
        list.add("一个功能挺不错的视频播放器");
        list.add("WebView允许上传文件");
        list.add("多线程MUSIC播放器");
        list.add("EventBus的Demo");
        list.add("关于Fresco的列表");
        list.add("GankIO社区");
        list.add("TabBar组件");


        MainPageAdapter adapter = new MainPageAdapter(this, list);
        adapter.setOnItemClickListener(new RecyclerViewOnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, Object data) {
                Intent it = new Intent();
                switch (position) {
                    case 0:
                        it.setClass(MainActivity.this, WriteActivity.class);
                        break;
                    case 1:
                        it.setClass(MainActivity.this, PlayerListActivity.class);
                        break;
                    case 2:
                        it.setClass(MainActivity.this, WebViewActivity.class);
                        break;
                    case 3:
                        it.setClass(MainActivity.this, MusicPlayerActivity.class);
                        break;
                    case 4:
                        it.setClass(MainActivity.this, EventBusActivity.class);
                        break;
                    case 5:
                        it.setClass(MainActivity.this, PerfectGalleryActivity.class);
                        break;
                    case 6:
                        it.setClass(MainActivity.this, GankIOListActivity.class);
                        break;
                    case 7:
                        it.setClass(MainActivity.this, TabViewActivity.class);
                        break;
                }
                startActivity(it);
            }
        });
        recyclerView.setAdapter(adapter);

    }
}

