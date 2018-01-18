package com.holy.interestingdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.funnywrite.WriteScrollingActivity;

import java.util.List;

/**
 * Created by DR on 2018/1/18.
 */

public class MainPageAdapter extends RecyclerView.Adapter<MainPageHolder> {

    private Context context;
    private List<String> list;

    public MainPageAdapter(Context context, List<String> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public MainPageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        return new MainPageHolder(v);
    }

    @Override
    public void onBindViewHolder(MainPageHolder holder, final int position) {

        holder.textView.setText(list.get(position));
        holder.textView.setOnClickListener(view -> {
            Intent it = new Intent();
            switch (position){
                case 0 :
                    it.setClass(context, WriteScrollingActivity.class);

                    break;
                default:
                    it.setClass(context,null);
            }
            context.startActivity(it);
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class MainPageHolder extends RecyclerView.ViewHolder{

    public TextView textView;

    public MainPageHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.info_text);
    }
}
