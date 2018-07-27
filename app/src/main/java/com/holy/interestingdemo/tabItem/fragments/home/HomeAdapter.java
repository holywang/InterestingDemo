package com.holy.interestingdemo.tabItem.fragments.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.holy.insidescrollpage.databean.FuLiBean;
import com.holy.interestingdemo.R;

import java.util.List;

/**
 * Created by holywang on 2018/7/24.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder>{

    private Context context;
    private List<FuLiBean.ResultsBean> list;


    public HomeAdapter(Context context,List<FuLiBean.ResultsBean> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public HomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item_layout,parent,false);
        return new HomeHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(HomeHolder holder, int position) {

        Glide.with(context).load(list.get(position).getUrl()).into(holder.itemImage);
        holder.price.setText("￥" + (int)(10000 * Math.random()));
        holder.desc.setText(list.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void loadMore(List<FuLiBean.ResultsBean> moreList ,OnFinishCallback callback){
//        list.addAll(moreList);
        for (int i = 0; i < moreList.size(); i++) {
            list.add(moreList.get(i));
            notifyDataSetChanged();
        }

        callback.onFinish();
    }

    class HomeHolder extends RecyclerView.ViewHolder{
        private TextView price,desc;
        private ImageView itemImage;

        public HomeHolder(View itemView) {
            super(itemView);
            price = itemView.findViewById(R.id.home_item_price);
            desc = itemView.findViewById(R.id.home_item_desc);
            itemImage = itemView.findViewById(R.id.home_item_image);
        }
    }

    public interface OnFinishCallback{
        void onFinish();
    }
}
