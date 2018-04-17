package com.holy.interestingdemo.mygallery.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.mygallery.adapter.GalleryAdapter;
import com.holy.interestingdemo.mygallery.present.GalleryPresent;
import com.holy.interestingdemo.network.bean.FuliBean;

import java.util.List;

public class PerfectGalleryActivity extends AppCompatActivity implements IImageShower{

    private FuliBean bean;
    private GalleryPresent present;

    private RecyclerView imageList;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfect_gallery);

        present = new GalleryPresent(this);

        imageList = findViewById(R.id.image_list);

    }


    @Override
    public void setImageFile(List<FuliBean.ResultsBean> list) {
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        imageList.setLayoutManager(mLayoutManager);
        imageList.setAdapter(new GalleryAdapter(list));
    }
}
