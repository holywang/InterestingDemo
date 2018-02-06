package com.holy.interestingdemo.funnywrite.bean;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by DR on 2018/2/6.
 */
@RealmClass
public class NovelArticleBean implements RealmModel {

    @PrimaryKey
    private int novelId;//主键ID
    private int novelChapter;//章
    private int novelQuarter;//节
    private String novelCotext;//文章正文

    public int getNovelId() {
        return novelId;
    }

    public void setNovelId(int novelId) {
        this.novelId = novelId;
    }

    public int getNovelChapter() {
        return novelChapter;
    }

    public void setNovelChapter(int novelChapter) {
        this.novelChapter = novelChapter;
    }

    public int getNovelQuarter() {
        return novelQuarter;
    }

    public void setNovelQuarter(int novelQuarter) {
        this.novelQuarter = novelQuarter;
    }

    public String getNovelCotext() {
        return novelCotext;
    }

    public void setNovelCotext(String novelCotext) {
        this.novelCotext = novelCotext;
    }


}
