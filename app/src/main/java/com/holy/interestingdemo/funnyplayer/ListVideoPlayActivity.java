package com.holy.interestingdemo.funnyplayer;

import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.funnyplayer.adapter.ListVideoPlayerAdapter;
import com.holy.interestingdemo.funnyplayer.model.bean.PlayerBean;
import com.holy.interestingdemo.funnyplayer.presenter.ListVideoPlayPresenter;
import com.holy.interestingdemo.funnyplayer.view.IListVideoPlay;
import com.holy.interestingdemo.mainInfo.BaseActivity;
import com.holy.interestingdemo.views.dialogs.LoadingDialog;

import java.util.List;

public class ListVideoPlayActivity extends BaseActivity implements IListVideoPlay, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout refreshLayout;
    private RecyclerView listLayout;
    private LoadingDialog loading;

    private Button showLoading;

    private ListVideoPlayPresenter presenter;
    private List<PlayerBean> videoList;
    private ListVideoPlayerAdapter adapter;


    @Override
    public void toSetContentView() {
        setContentView(R.layout.activity_list_video_play);
    }

    @Override
    public void initViews() {
        refreshLayout = findViewById(R.id.list_player_list_refresh);
        listLayout = findViewById(R.id.list_player_list);
        showLoading = findViewById(R.id.show_loading);
    }

    @Override
    public void setListener() {
        refreshLayout.setOnRefreshListener(this);
        showLoading.setOnClickListener(this);
    }

    @Override
    public void doSth() {
        presenter = new ListVideoPlayPresenter(this);
        videoList = presenter.getList(this);

        adapter = new ListVideoPlayerAdapter(this,videoList);
        refreshLayout.setColorSchemeResources(
                R.color.colorAccent,R.color.colorPrimary
        );
        listLayout.setHasFixedSize(true);
        listLayout.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        listLayout.setAdapter(adapter);
        listLayout.addOnScrollListener(listener);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.show_loading:
                presenter.showLoading(listLayout);
                break;
        }
    }


    @Override
    public void onRefresh() {

    }

    @Override
    public void showSnackBar(String text, View view) {
        Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading(ViewGroup rootView) {
        LoadingDialog.Builder builder = new LoadingDialog.Builder(this);
        loading = builder.create();
        loading.show();
    }

    @Override
    public void hideLoading() {
        if (loading != null) {
            loading.dismiss();
        }
    }

    private OnScrollListener listener = new OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }
    };
}
