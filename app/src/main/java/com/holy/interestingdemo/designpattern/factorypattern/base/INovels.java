package com.holy.interestingdemo.designpattern.factorypattern.base;

import java.io.Serializable;

/**
 * Created by DR on 2018/4/16.
 */

public abstract class INovels implements Serializable{

    private String novelId;
    private String novelName;
    private String novelAuthor;
    private String novelStyle;
    private String novelDescription;
    private String novelImage;
    private int sessionNumber;
    private int pageNumber;
    private long codeNumber;

    public String getNovelId() {
        return novelId;
    }

    public void setNovelId(String novelId) {
        this.novelId = novelId;
    }

    public String getNovelName() {
        return novelName;
    }

    public void setNovelName(String novelName) {
        this.novelName = novelName;
    }

    public String getNovelAuthor() {
        return novelAuthor;
    }

    public void setNovelAuthor(String novelAuthor) {
        this.novelAuthor = novelAuthor;
    }

    public String getNovelStyle() {
        return novelStyle;
    }

    public void setNovelStyle(String novelStyle) {
        this.novelStyle = novelStyle;
    }

    public String getNovelDescription() {
        return novelDescription;
    }

    public void setNovelDescription(String novelDescription) {
        this.novelDescription = novelDescription;
    }

    public String getNovelImage() {
        return novelImage;
    }

    public void setNovelImage(String novelImage) {
        this.novelImage = novelImage;
    }

    public int getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(int sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public long getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(long codeNumber) {
        this.codeNumber = codeNumber;
    }

    public abstract String desc();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"novelId\":\"")
                .append(novelId).append('\"');
        sb.append(",\"novelName\":\"")
                .append(novelName).append('\"');
        sb.append(",\"novelAuthor\":\"")
                .append(novelAuthor).append('\"');
        sb.append(",\"novelStyle\":\"")
                .append(novelStyle).append('\"');
        sb.append(",\"novelDescription\":\"")
                .append(novelDescription).append('\"');
        sb.append(",\"novelImage\":\"")
                .append(novelImage).append('\"');
        sb.append(",\"sessionNumber\":")
                .append(sessionNumber);
        sb.append(",\"pageNumber\":")
                .append(pageNumber);
        sb.append(",\"codeNumber\":")
                .append(codeNumber);
        sb.append('}');
        return sb.toString();
    }
}
