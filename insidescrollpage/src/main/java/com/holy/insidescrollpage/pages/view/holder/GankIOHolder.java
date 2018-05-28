package com.holy.insidescrollpage.pages.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.holy.insidescrollpage.R;

/**
 * Created by DR on 2018/5/28.
 */

public class GankIOHolder extends RecyclerView.ViewHolder {
    public View itemView;
    public TextView desc, createdTime;
    public ImageView itemImage;

    public GankIOHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        desc = itemView.findViewById(R.id.item_desc);
        createdTime = itemView.findViewById(R.id.item_created_time);
        itemImage = itemView.findViewById(R.id.item_image);
    }
}
