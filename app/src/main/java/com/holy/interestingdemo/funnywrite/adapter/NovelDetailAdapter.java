package com.holy.interestingdemo.funnywrite.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.designpattern.factorypattern.base.INovelDetail;
import com.holy.interestingdemo.mainInfo.listener.RecyclerViewOnItemClickListener;
import com.holy.interestingdemo.utils.L;

import java.util.List;

/**
 * Created by DR on 2018/4/17.
 */

public class NovelDetailAdapter extends RecyclerView.Adapter<NovelDetailHolder> {
    private List<INovelDetail> list;
    private Context context;
    private RecyclerViewOnItemClickListener listener;

    public NovelDetailAdapter(Context context, List<INovelDetail> list) {
        this.list = list;
        this.context = context;
    }

    public void setOnItemClickListener(RecyclerViewOnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public NovelDetailHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.write_list_item, parent, false);
        return new NovelDetailHolder(v);
    }

    @Override
    public void onBindViewHolder(NovelDetailHolder holder, int position) {
        if (position < list.size()) {
            holder.titleImage.setImageResource(R.mipmap.ic_launcher_round);
            holder.session.setText(list.get(position).getSession());
            holder.page.setText(list.get(position).getPage());
            holder.itemView.setOnClickListener(view -> listener.onItemClick(view, position, list.get(position)));
        }else{
            holder.titleImage.setVisibility(View.GONE);
            holder.session.setText("添加一个新的章节");
            holder.page.setVisibility(View.GONE);
            holder.itemView.setOnClickListener(view -> listener.onItemClick(view, position, null));
        }
        L.i("NDA","this is position"+position);
    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }


}

class NovelDetailHolder extends RecyclerView.ViewHolder {
    ImageView titleImage;
    TextView session, page;
    View itemView;

    public NovelDetailHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        titleImage = itemView.findViewById(R.id.write_list_item_head);
        session = itemView.findViewById(R.id.write_list_item_number);
        page = itemView.findViewById(R.id.write_list_item_book_name);
    }
}
