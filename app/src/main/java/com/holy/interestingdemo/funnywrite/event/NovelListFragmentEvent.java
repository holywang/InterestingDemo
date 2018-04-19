package com.holy.interestingdemo.funnywrite.event;

import com.holy.interestingdemo.designpattern.factorypattern.base.INovelDetail;

/**
 * Created by DR on 2018/4/19.
 * NovelListFragment向Activity发送的事件
 */

public class NovelListFragmentEvent {
    private String action;
    private INovelDetail data;

    public NovelListFragmentEvent(String action){
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public INovelDetail getData() {
        return data;
    }

    public void setData(INovelDetail data) {
        this.data = data;
    }
}
