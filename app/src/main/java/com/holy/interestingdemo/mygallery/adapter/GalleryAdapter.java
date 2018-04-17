package com.holy.interestingdemo.mygallery.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.holy.interestingdemo.network.bean.FuliBean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/17.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryHolder> {
    private List<FuliBean.ResultsBean> list;

    public GalleryAdapter(List<FuliBean.ResultsBean> list){
        this.list = list;
    }

    @Override
    public GalleryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(GalleryHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class GalleryHolder extends RecyclerView.ViewHolder{

    public GalleryHolder(View itemView) {
        super(itemView);
    }
}

