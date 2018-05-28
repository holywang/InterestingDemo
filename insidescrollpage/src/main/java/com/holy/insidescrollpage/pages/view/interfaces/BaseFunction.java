package com.holy.insidescrollpage.pages.view.interfaces;

import com.holy.insidescrollpage.databean.AndroidBean;
import com.holy.insidescrollpage.databean.FuLiBean;
import com.holy.insidescrollpage.databean.WebBean;

/**
 * Created by DR on 2018/5/28.
 */

public interface BaseFunction {
    void initView();
    void showProgress();
    void hideProgress();
    void toast(String info);

    void setAndroidList(AndroidBean data);
    void setFuliList(FuLiBean data);
    void setWebList(WebBean data);
    void clearData();
}
