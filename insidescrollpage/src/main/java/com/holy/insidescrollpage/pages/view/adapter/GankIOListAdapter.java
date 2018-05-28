package com.holy.insidescrollpage.pages.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.holy.insidescrollpage.R;
import com.holy.insidescrollpage.databean.AndroidBean;
import com.holy.insidescrollpage.databean.FuLiBean;
import com.holy.insidescrollpage.databean.WebBean;
import com.holy.insidescrollpage.pages.view.holder.GankIOHolder;
import com.holy.insidescrollpage.pages.view.interfaces.AddMoreListener;
import com.holy.insidescrollpage.pages.view.interfaces.OnItemClickListener;

import java.util.List;

/**
 * Created by DR on 2018/5/28.
 */

public class GankIOListAdapter extends RecyclerView.Adapter<GankIOHolder> {
    private final String defaultUri = "https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=60c889ffb051f819f125044ce28f2dd0/ae51f3deb48f8c54cd34cafb3a292df5e1fe7f7a.jpg";

    private List<Object> list;
    private Context context;
    private OnItemClickListener listener;
    private AddMoreListener addMoreListener;

    public GankIOListAdapter(List list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setAddMoreListener(AddMoreListener addMoreListener) {
        this.addMoreListener = addMoreListener;
    }

    @Override
    public GankIOHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gank_io_item_layout, parent, false);
        return new GankIOHolder(v);
    }

    @Override
    public void onBindViewHolder(GankIOHolder holder, int position) {
        final Object data = list.get(position);
        if (data instanceof AndroidBean.ResultsBean) {
            AndroidBean.ResultsBean bean = (AndroidBean.ResultsBean) data;
            Glide.with(context).load(defaultUri).into(holder.itemImage);
            holder.createdTime.setText(bean.getCreatedAt());
            holder.desc.setText(bean.getDesc());
        }
        if (data instanceof FuLiBean.ResultsBean) {
            FuLiBean.ResultsBean bean = (FuLiBean.ResultsBean) data;
            Glide.with(context).load(bean.getUrl()).into(holder.itemImage);
            holder.createdTime.setText(bean.getCreatedAt());
            holder.desc.setText(bean.getDesc());
        }
        if (data instanceof WebBean.ResultsBean) {
            WebBean.ResultsBean bean = (WebBean.ResultsBean) data;
            Glide.with(context).load(defaultUri).into(holder.itemImage);
            holder.createdTime.setText(bean.getCreatedAt());
            holder.desc.setText(bean.getDesc());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnItemClick(data);
            }
        });

        if (position%9 == 0){
            addMoreListener.addMore();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
