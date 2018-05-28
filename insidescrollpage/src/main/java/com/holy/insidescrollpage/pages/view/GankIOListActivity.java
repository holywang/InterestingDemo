package com.holy.insidescrollpage.pages.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import com.holy.insidescrollpage.R;
import com.holy.insidescrollpage.databean.AndroidBean;
import com.holy.insidescrollpage.databean.FuLiBean;
import com.holy.insidescrollpage.databean.WebBean;
import com.holy.insidescrollpage.pages.presenter.GankIOListPresenter;
import com.holy.insidescrollpage.pages.view.adapter.GankIOListAdapter;
import com.holy.insidescrollpage.pages.view.interfaces.AddMoreListener;
import com.holy.insidescrollpage.pages.view.interfaces.BaseFunction;
import com.holy.insidescrollpage.pages.view.interfaces.OnItemClickListener;

import java.util.List;

public class GankIOListActivity extends AppCompatActivity implements BaseFunction, View.OnClickListener {

    private ScrollView backScrollView;
    private GankIOListPresenter presenter;
    private RecyclerView androidListView, fuliListView, webListView;

    private static List<AndroidBean.ResultsBean> androidData;
    private static List<FuLiBean.ResultsBean> fuliData;
    private static List<WebBean.ResultsBean> webData;


    private GankIOListAdapter androidAdapter, fuliAdapter, webAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank_iolist);
        presenter = new GankIOListPresenter(this);
        presenter.initView();
        presenter.getDefaultData();
    }

    @Override
    public void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        backScrollView = findViewById(R.id.back_scroll_view);

        androidListView = findViewById(R.id.android_list);
        fuliListView = findViewById(R.id.fuli_list);
        webListView = findViewById(R.id.web_list);

        setLayoutManager(androidListView);
        setLayoutManager(fuliListView);
        setLayoutManager(webListView);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    private void setLayoutManager(RecyclerView view) {
        view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void showProgress() {
        toast("show");
    }

    @Override
    public void hideProgress() {
        toast("hide");
    }

    @Override
    public void toast(String info) {
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setAndroidList(AndroidBean data) {
        if (androidData == null) {
            androidData = data.getResults();
        } else {
            androidData.addAll(data.getResults());
        }

        if (androidAdapter != null) {
            androidAdapter.notifyDataSetChanged();
            return;
        }
        androidAdapter = new GankIOListAdapter(androidData, this);
        androidAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(Object data) {
                AndroidBean.ResultsBean bean = (AndroidBean.ResultsBean) data;
                Intent it = new Intent(GankIOListActivity.this, GankIoDetailActivity.class);
                it.putExtra("data", bean);
                startActivity(it);
            }
        });
        androidAdapter.setAddMoreListener(new AddMoreListener() {
            @Override
            public void refresh() {

            }

            @Override
            public void addMore() {
                presenter.addAndroidData();
            }
        });
        androidListView.setAdapter(androidAdapter);

    }

    @Override
    public void setFuliList(FuLiBean data) {
        if (fuliData == null) {
            fuliData = data.getResults();
        } else {
            fuliData.addAll(data.getResults());
        }

        if (fuliAdapter != null) {
            fuliAdapter.notifyDataSetChanged();
            return;
        }
        fuliAdapter = new GankIOListAdapter(fuliData, this);
        fuliAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(Object data) {
                FuLiBean.ResultsBean bean = (FuLiBean.ResultsBean) data;
                Intent it = new Intent(GankIOListActivity.this, GankIoDetailActivity.class);
                it.putExtra("data", bean);
                startActivity(it);
            }
        });
        fuliAdapter.setAddMoreListener(new AddMoreListener() {
            @Override
            public void refresh() {

            }

            @Override
            public void addMore() {
                presenter.addFuliData();
            }
        });
        fuliListView.setAdapter(fuliAdapter);
    }

    @Override
    public void setWebList(WebBean data) {
        if (webData == null) {
            webData = data.getResults();
        } else {
            webData.addAll(data.getResults());
        }

        if (webAdapter != null) {
            webAdapter.notifyDataSetChanged();
            return;
        }
        webAdapter = new GankIOListAdapter(webData, this);
        webAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(Object data) {
                WebBean.ResultsBean bean = (WebBean.ResultsBean) data;
                Intent it = new Intent(GankIOListActivity.this, GankIoDetailActivity.class);
                it.putExtra("data", bean);
                startActivity(it);
            }
        });
        webAdapter.setAddMoreListener(new AddMoreListener() {
            @Override
            public void refresh() {

            }

            @Override
            public void addMore() {
                presenter.addWebData();
            }
        });
        webListView.setAdapter(webAdapter);
    }

    @Override
    public void clearData() {
        androidData.clear();
        fuliData.clear();
        webData.clear();
        androidData = null;
        fuliData = null;
        webData = null;
        androidAdapter =null;
        fuliAdapter =null;
        webAdapter =null;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fab) {
            presenter.refresh();
        }
    }


}
