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
import com.holy.interestingdemo.mainInfo.BaseActivity;
import com.holy.interestingdemo.mainInfo.listener.RecyclerViewOnItemClickListener;
import com.holy.interestingdemo.utils.L;

import java.io.File;
import java.io.Serializable;
import java.util.List;

public class PlayerListActivity extends BaseActivity implements IPlayerView {

    private final static String TAG = "PlayerListActivity";

    private SwipeRefreshLayout playerRefreshView;
    private RecyclerView playerList;

    private PlayerListPresenter presenter;
    private LinearLayoutManager mLayoutManager;
    private PlayerListAdapter adapter;

    @Override
    public void toSetContentView() {
        setContentView(R.layout.activity_player);
    }

    @Override
    public void initViews() {
        playerList = findViewById(R.id.player_list);
        playerRefreshView = findViewById(R.id.player_list_refresh);
    }

    @Override
    public void setListener() {
        presenter = new PlayerListPresenter(this);
        presenter.setList(presenter.getMp4FileList(this));

    }

    @Override
    public void doSth() {
        setListView();
    }

    private void setListView(){
        L.i(TAG, "setListView");
        adapter = new PlayerListAdapter(this,presenter.getMediaList());
        adapter.setOnItemClickListener(new RecyclerViewOnItemClickListener(){
            @Override
            public void onItemClick(View view, int position, Object data) {
               // Snackbar.make(view,"这是第"+position+"项",Snackbar.LENGTH_LONG).show();
                Intent it = new Intent();
                it.setClass(PlayerListActivity.this,VideoPlayActivity.class);
                it.putExtra("url", presenter.getMediaList().get(position).getPath());
                it.putExtra("name",presenter.getMediaList().get(position).getName());
                it.putExtra("position",position);
                startActivity(it);
            }

            @Override
            public void onItemLongClick(View view, int position, Object data) {
                Intent it = new Intent();
                it.setClass(PlayerListActivity.this,ListVideoPlayActivity.class);
                it.putExtra("position",position);
                startActivity(it);
            }
        });

        playerRefreshView.setColorSchemeResources(
                R.color.colorAccent,R.color.colorPrimary
        );
        if (presenter.getMediaList().isEmpty()) return;
        if (presenter.getMediaList().size()<=0) return;
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

    @Override
    public void onClick(View v) {

    }
}
