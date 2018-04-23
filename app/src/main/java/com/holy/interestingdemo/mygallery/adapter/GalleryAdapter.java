package com.holy.interestingdemo.mygallery.adapter;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.holy.interestingdemo.R;
import com.holy.interestingdemo.network.bean.FuliBean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/17.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryHolder> {
    private List<FuliBean.ResultsBean> list;
    private Context context;

    public GalleryAdapter(List<FuliBean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public GalleryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item_view, parent, false);
        return new GalleryHolder(v);
    }

    @Override
    public void onBindViewHolder(GalleryHolder holder, int position) {

        Uri uri = Uri.parse(list.get(position).getUrl());
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setProgressiveRenderingEnabled(true)
                .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(holder.imageView.getController())
                .build();
        holder.imageView.setController(controller);

       // holder.imageView.setImageURI(Uri.parse(list.get(position).getUrl()));
        if (position % 2 == 1) {
            holder.itemView.setBackgroundColor(Color.YELLOW);
        }else{
            holder.itemView.setBackgroundColor(Color.RED);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class GalleryHolder extends RecyclerView.ViewHolder {

    public SimpleDraweeView imageView;

    View itemView;

    public GalleryHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        imageView = itemView.findViewById(R.id.gallery_image_item);

    }

}

