package com.holy.interestingdemo.funnyplayer.adapter.adapterHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.holy.interestingdemo.R;

/**
 * Created by DR on 2018/3/6.
 */

public class PlayerListHolder extends RecyclerView.ViewHolder {

    public ImageView headImage;
    public TextView fileName,fileSize;
    public View itemView;

    public PlayerListHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        headImage = itemView.findViewById(R.id.player_list_item_head);
        fileName = itemView.findViewById(R.id.player_list_item_file_name);
        fileSize = itemView.findViewById(R.id.player_list_item_file_size);
    }
}
