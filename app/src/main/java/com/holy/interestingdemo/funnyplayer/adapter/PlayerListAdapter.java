package com.holy.interestingdemo.funnyplayer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.funnyplayer.adapter.adapterHolder.PlayerListHolder;
import com.holy.interestingdemo.mainInfo.listener.RecyclerViewOnItemClickListener;
import com.holy.interestingdemo.utils.MediaUtil;

import java.io.File;
import java.util.List;

/**
 * Created by DR on 2018/3/6.
 */

public class PlayerListAdapter extends RecyclerView.Adapter<PlayerListHolder> {

    private Context context;
    private List<File> list;
    private RecyclerViewOnItemClickListener listener;

    public PlayerListAdapter(Context context, List<File> list) {
        this.context = context;
        this.list = list;
    }

    public void setOnItemClickListener(RecyclerViewOnItemClickListener listener) {
        this.listener = listener;
    }


    @Override
    public PlayerListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_list_item, parent, false);
        return new PlayerListHolder(v);
    }

    @Override
    public void onBindViewHolder(PlayerListHolder holder, int position) {
        holder.itemView.setOnClickListener(view -> listener.onItemClick(view, position, list.get(position)));
        holder.itemView.setOnLongClickListener(view ->{
            listener.onItemLongClick(view, position, list.get(position));
            return true;
        });
        holder.fileName.setText(list.get(position).getName());
        holder.fileSize.setText(MediaUtil.changeToMB(list.get(position).length())+"MB");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
