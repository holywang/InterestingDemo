package com.holy.interestingdemo.funnywrite.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.designpattern.factorypattern.base.INovels;
import com.holy.interestingdemo.mainInfo.listener.RecyclerViewOnItemClickListener;

import java.util.List;

/**
 * Created by DR on 2018/1/18.
 */

public class WriteListAdapter extends RecyclerView.Adapter<WriteListHolder> {

    private Context context;
    private List<INovels> list;
    private RecyclerViewOnItemClickListener listener;

    public void setOnItemClickListener(RecyclerViewOnItemClickListener listener) {
        this.listener = listener;
    }

    public WriteListAdapter(Context context,List<INovels> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public WriteListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.write_list_item, parent, false);
        return new WriteListHolder(v);
    }

    @Override
    public void onBindViewHolder(WriteListHolder holder, int position) {

//        holder.head.setImageURI();
        holder.bookName.setText(list.get(position).getNovelName());
        holder.number.setText(list.get(position).getNovelStyle());
        holder.itemView.setOnClickListener(view -> listener.onItemClick(view,position,list.get(position)));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class WriteListHolder extends RecyclerView.ViewHolder{

    public ImageView head;
    public TextView bookName;
    public TextView number;
    public View itemView;

    public WriteListHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        head = itemView.findViewById(R.id.write_list_item_head);
        bookName = itemView.findViewById(R.id.write_list_item_book_name);
        number = itemView.findViewById(R.id.write_list_item_number);
    }
}
