package com.holy.interestingdemo.funnyplayer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.funnyplayer.adapter.adapterHolder.ListVideoPlayerHolder;
import com.holy.interestingdemo.funnyplayer.model.bean.PlayerBean;

import java.util.List;

/**
 * Created by DR on 2018/5/7.
 */

public class ListVideoPlayerAdapter extends RecyclerView.Adapter<ListVideoPlayerHolder> {

    private Context context;
    private List<PlayerBean> list;

    public ListVideoPlayerAdapter(Context context,List<PlayerBean> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public ListVideoPlayerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_video_player_list_item, parent, false);
        return new ListVideoPlayerHolder(v);
    }

    @Override
    public void onBindViewHolder(ListVideoPlayerHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * 加载更多
     * @param moreList
     */
    public void addMore(List<PlayerBean> moreList){
        list.addAll(moreList);
        notifyDataSetChanged();
    }
}
