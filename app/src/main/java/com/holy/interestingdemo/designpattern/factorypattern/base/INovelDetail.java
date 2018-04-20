package com.holy.interestingdemo.designpattern.factorypattern.base;

import java.io.Serializable;

/**
 * Created by DR on 2018/4/17.
 */

public class INovelDetail implements Serializable {

    private String novelId;
    private String detailId;
    private String session;
    private String page;
    private String context;
    private int contextNum;


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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getNovelId() {
        return novelId;
    }

    public void setNovelId(String novelId) {
        this.novelId = novelId;
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public int getContextNum() {
        return contextNum;
    }

    public void setContextNum(int contextNum) {
        this.contextNum = contextNum;
    }

    /**
     * 生成一个DetailId
     * @return
     */
    public static String createDetailId(String novelID,String session) {
        StringBuilder sb = new StringBuilder();
        sb.append(novelID);
        sb.append(session);
        sb.append(System.currentTimeMillis());
        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"novelId\":\"")
                .append(novelId).append('\"');
        sb.append(",\"detailId\":\"")
                .append(detailId).append('\"');
        sb.append(",\"session\":\"")
                .append(session).append('\"');
        sb.append(",\"page\":\"")
                .append(page).append('\"');
        sb.append(",\"context\":\"")
                .append(context).append('\"');
        sb.append(",\"contextNum\":")
                .append(contextNum);
        sb.append('}');
        return sb.toString();
    }
}
