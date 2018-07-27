package com.holy.interestingdemo.tabItem.fragments.home;


import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;

import com.holy.interestingdemo.utils.DisplayUtils;

/**
 * Created by holywang on 2018/7/24.
 */

public class HomeLayoutManager extends LayoutManager {

    private int totalHeight = 0;
    private int verticalScrollOffset = 0;

    public HomeLayoutManager() {

    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.WRAP_CONTENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
        );
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        detachAndScrapAttachedViews(recycler);
        calculateChildrenSite(recycler);
    }

    private void calculateChildrenSite(RecyclerView.Recycler recycler) {
        totalHeight = 0;
        for (int i = 0; i < getItemCount(); i++) {
            View view = recycler.getViewForPosition(i);
            addView(view);
            measureChildWithMargins(view, 0, 0);
            int width = getDecoratedMeasuredWidth(view);
            int height = getDecoratedMeasuredHeight(view);

            Rect mTmpRect = new Rect();
            calculateItemDecorationsForChild(view, mTmpRect);

//            layoutDecorated(view, 0, totalHeight, width, totalHeight + height);
//            totalHeight += height;

            if (i % 2 == 0) { //当i能被2整除时，是左，否则是右。
                //左
                layoutDecoratedWithMargins(view, 0, totalHeight, DisplayUtils.getScreenWidth() / 2,
                        totalHeight + height);
            } else {
                //右，需要换行
                layoutDecoratedWithMargins(view, DisplayUtils.getScreenWidth() / 2, totalHeight,
                        DisplayUtils.getScreenWidth(), totalHeight + height);
                totalHeight = totalHeight + height;
            }
        }

    }

    @Override
    public boolean canScrollVertically() {
        return true;
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int travel = dy;
        if (verticalScrollOffset + dy < 0) {
            travel = -verticalScrollOffset;
        } else if (verticalScrollOffset + dy > totalHeight - getVerticalSpace()) {
            travel = totalHeight - getVerticalSpace() - verticalScrollOffset;
        }
        verticalScrollOffset += travel;
        offsetChildrenVertical(-travel);
        return travel;
    }

    private int getVerticalSpace() {
        return getHeight() - getPaddingBottom() - getPaddingTop();
    }

    @Override
    public boolean canScrollHorizontally() {
        return super.canScrollHorizontally();
    }

    @Override
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.scrollHorizontallyBy(dx, recycler, state);
    }

}
