package com.holy.interestingdemo.mainInfo.interfaces;

import android.view.View;

/**
 * Created by DR on 2018/1/27.
 */

public interface RecyclerViewOnItemClick {

    void onItemClick(View view, int position, Object data);
    void OnItemLongClick(View view, int position, Object data);
}
