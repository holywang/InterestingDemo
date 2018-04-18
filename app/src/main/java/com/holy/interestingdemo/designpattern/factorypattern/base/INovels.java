package com.holy.interestingdemo.designpattern.factorypattern.base;

import java.io.Serializable;

/**
 * Created by DR on 2018/4/16.
 */

public abstract class INovels implements Serializable{

    private String novel_id;
    private String novel_name;
    private String novel_author;
    private String novel_style;
    private String novel_description;
    private String novel_image;

    public String getNovel_id() {
        return novel_id;
    }

    public void setNovel_id(String novel_id) {
        this.novel_id = novel_id;
    }

    public String getNovel_name() {
        return novel_name;
    }

    public void setNovel_name(String novel_name) {
        this.novel_name = novel_name;
    }

    public String getNovel_author() {
        return novel_author;
    }

    public void setNovel_author(String novel_author) {
        this.novel_author = novel_author;
    }

    public String getNovel_style() {
        return novel_style;
    }

    public void setNovel_style(String novel_style) {
        this.novel_style = novel_style;
    }

    public String getNovel_description() {
        return novel_description;
    }

    public void setNovel_description(String novel_description) {
        this.novel_description = novel_description;
    }

    public String getNovel_image() {
        return novel_image;
    }

    public void setNovel_image(String novel_image) {
        this.novel_image = novel_image;
    }

    public abstract String desc();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"novel_id\":\"")
                .append(novel_id).append('\"');
        sb.append(",\"novel_name\":\"")
                .append(novel_name).append('\"');
        sb.append(",\"novel_author\":\"")
                .append(novel_author).append('\"');
        sb.append(",\"novel_style\":\"")
                .append(novel_style).append('\"');
        sb.append(",\"novel_description\":\"")
                .append(novel_description).append('\"');
        sb.append(",\"novel_image\":\"")
                .append(novel_image).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
