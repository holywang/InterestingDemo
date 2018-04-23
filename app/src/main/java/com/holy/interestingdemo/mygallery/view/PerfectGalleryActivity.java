package com.holy.interestingdemo.mygallery.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.annotations.BindView;
import com.holy.interestingdemo.mainInfo.BaseActivity;
import com.holy.interestingdemo.mygallery.adapter.GalleryAdapter;
import com.holy.interestingdemo.mygallery.present.GalleryPresent;
import com.holy.interestingdemo.network.bean.FuliBean;

import java.util.List;

public class PerfectGalleryActivity extends BaseActivity implements IImageShower{

    private FuliBean bean;
    private GalleryPresent present;

    @BindView(id = R.id.image_list)
    private RecyclerView imageList;

    private LinearLayoutManager mLayoutManager;

    @Override
    public void toSetContentView() {
        setContentView(R.layout.activity_perfect_gallery);
    }

    @Override
    public void initViews() {
        present = new GalleryPresent(this);
        imageList = findViewById(R.id.image_list);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void doSth() {
        imageList.setScrollingTouchSlop(RecyclerView.TOUCH_SLOP_PAGING);
        present.setImageList(10,2);
    }


    @Override
    public void setImageFile(List<FuliBean.ResultsBean> list) {
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        imageList.setLayoutManager(mLayoutManager);
        imageList.setAdapter(new GalleryAdapter(list,this));
    }

    @Override
    public void onClick(View v) {

    }


}
