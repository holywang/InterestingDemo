package com.holy.interestingdemo.mygallery.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.annotations.BindView;
import com.holy.interestingdemo.mainInfo.BaseActivity;
import com.holy.interestingdemo.mygallery.adapter.GalleryAdapter;
import com.holy.interestingdemo.mygallery.present.GalleryPresent;
import com.holy.interestingdemo.network.bean.FuliBean;

import java.util.List;

public class PerfectGalleryActivity extends BaseActivity implements IImageShower{

    private FuliBean bean;
    private GalleryPresent present;

    @BindView(id = R.id.image_list)
    private RecyclerView imageList;

    private LinearLayoutManager mLayoutManager;
    private GalleryAdapter adapter;


    boolean isSlidingToLast = false;
    private int page = 0;


    @Override
    public void toSetContentView() {
        setContentView(R.layout.activity_perfect_gallery);
    }

    @Override
    public void initViews() {
        present = new GalleryPresent(this);
        imageList = findViewById(R.id.image_list);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void doSth() {
        imageList.setScrollingTouchSlop(RecyclerView.TOUCH_SLOP_PAGING);
        present.setImageList(10,page);
    }


    @Override
    public void setImageFile(List<FuliBean.ResultsBean> list) {
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        imageList.setLayoutManager(mLayoutManager);
        adapter = new GalleryAdapter(list,this);
        imageList.setAdapter(adapter);
        imageList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                // 当不滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //获取最后一个完全显示的ItemPosition
                    int lastVisibleItem = manager.findLastCompletelyVisibleItemPosition();
                    int totalItemCount = manager.getItemCount();

                    // 判断是否滚动到底部，并且是向右滚动
                    if (lastVisibleItem == (totalItemCount - 1) && isSlidingToLast) {
                        //加载更多功能的代码
                        page++;
                        present.addMoreImage(10,page+1);
                    }
                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dx > 0) {
                    //大于0表示正在向右滚动
                    isSlidingToLast = true;
                } else {
                    //小于等于0表示停止或向左滚动
                    isSlidingToLast = false;
                }
            }
        });
    }

    @Override
    public void addMoreImage(List<FuliBean.ResultsBean> list) {
       adapter.addList(list);
    }

    @Override
    public void onClick(View v) {

    }


}
