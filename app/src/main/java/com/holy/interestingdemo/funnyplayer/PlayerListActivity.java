package com.holy.interestingdemo.funnyplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.funnyplayer.adapter.PlayerListAdapter;
import com.holy.interestingdemo.funnyplayer.presenter.PlayerListPresenter;
import com.holy.interestingdemo.funnyplayer.view.IPlayerView;
import com.holy.interestingdemo.mainInfo.listener.RecyclerViewOnItemClickListener;
import com.holy.interestingdemo.utils.L;

import java.io.File;
import java.util.List;

public class PlayerListActivity extends PlayerBaseActivity implements IPlayerView {

    private final static String TAG = "PlayerListActivity";

    private SwipeRefreshLayout playerRefreshView;
    private RecyclerView playerList;

    private PlayerListPresenter presenter;
    private List<File> mediaList;
    private LinearLayoutManager mLayoutManager;
    private PlayerListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        L.i(TAG, "onCreate");
        initView();
        addAction();

    }

    public void initView() {
        L.i(TAG, "initView");
        playerList = findViewById(R.id.player_list);
        playerRefreshView = findViewById(R.id.player_list_refresh);
    }


    public void addAction() {
        L.i(TAG, "addAction");
        presenter = new PlayerListPresenter(this);
        mediaList = presenter.getMp4FileList(this);
        setListView();
    }

    private void setListView(){
        adapter = new PlayerListAdapter(this,mediaList);
        adapter.setOnItemClickListener(new RecyclerViewOnItemClickListener(){
            @Override
            public void onItemClick(View view, int position, Object data) {
                Snackbar.make(view,"这是第"+position+"项",Snackbar.LENGTH_LONG).show();
                Intent it = new Intent();
                it.setClass(PlayerListActivity.this,VideoPlayActivity.class);
                it.putExtra("url", mediaList.get(position).getPath());
                it.putExtra("name",mediaList.get(position).getName());
                startActivity(it);
            }
        });
        playerRefreshView.setColorSchemeResources(
                R.color.colorAccent,R.color.colorPrimary
        );
        if (mediaList.isEmpty()) return;
        if (mediaList.size()<=0) return;
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        playerList.setHasFixedSize(true);
        playerList.setLayoutManager(mLayoutManager);
        playerList.setAdapter(adapter);
//        playerRefreshView.setOnRefreshListener(() -> {
//            mediaList.clear();
//            mediaList = presenter.getMp3FileList(this);
//            setListView();
//        });
        playerList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState==RecyclerView.SCROLL_STATE_IDLE){
                    Snackbar.make(recyclerView,"没有更多",Snackbar.LENGTH_LONG).show();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

    }

    @Override
    public void showWaitingDialog() {

    }

    @Override
    public void dissmissWaitingDialog() {

    }
}
