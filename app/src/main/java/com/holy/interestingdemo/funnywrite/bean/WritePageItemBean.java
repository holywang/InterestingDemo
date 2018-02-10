package com.holy.interestingdemo.funnywrite.bean;

import java.io.Serializable;

/**
 * Created by DR on 2018/1/18.
 */

public class WritePageItemBean implements Serializable {

    private String novelId;
    private String name;
    private String type;
    private String titleImage;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"novelId\":\"")
                .append(novelId).append('\"');
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"type\":\"")
                .append(type).append('\"');
        sb.append(",\"titleImage\":\"")
                .append(titleImage).append('\"');
        sb.append('}');
        return sb.toString();
    }

    public String getNovelId() {
        return novelId;
    }

    public void setNovelId(String novelId) {
        this.novelId = novelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }
}
