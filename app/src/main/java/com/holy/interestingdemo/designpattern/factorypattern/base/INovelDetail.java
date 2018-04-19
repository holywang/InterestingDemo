package com.holy.interestingdemo.designpattern.factorypattern.base;

import java.io.File;
import java.io.Serializable;

/**
 * Created by DR on 2018/4/17.
 */

public class INovelDetail implements Serializable{

    private String novel_id;
    private String session;
    private String page;
    private File context;

    public String getNovel_id() {
        return novel_id;
    }

    public void setNovel_id(String novel_id) {
        this.novel_id = novel_id;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public File getContext() {
        return context;
    }

    public void setContext(File context) {
        this.context = context;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"novel_id\":\"")
                .append(novel_id).append('\"');
        sb.append(",\"session\":\"")
                .append(session).append('\"');
        sb.append(",\"page\":\"")
                .append(page).append('\"');
        sb.append(",\"context\":")
                .append(context.getAbsolutePath());
        sb.append('}');
        return sb.toString();
    }
}
