package com.holy.interestingdemo.funnywrite.event;

import com.holy.interestingdemo.designpattern.factorypattern.base.INovelDetail;

/**
 * Created by DR on 2018/4/19.
 * NovelListFragment向Activity发送的事件
 */

public class NovelListFragmentEvent {
    private String action;
    private INovelDetail data;
    private boolean ifNone;

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

    public boolean isIfNone() {
        return ifNone;
    }

    public void setIfNone(boolean ifNone) {
        this.ifNone = ifNone;
    }
}
