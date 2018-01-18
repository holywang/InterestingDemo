package com.holy.interestingdemo.funnywrite.bean;

import java.io.Serializable;

/**
 * Created by DR on 2018/1/18.
 */

public class WritePageItemBean implements Serializable {

    private String name;
    private int pageNum;
    private String titleImage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"pageNum\":")
                .append(pageNum);
        sb.append(",\"titleImage\":\"")
                .append(titleImage).append('\"');
        sb.append('}');
        return sb.toString();
    }

}
