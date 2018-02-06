package com.holy.interestingdemo.funnywrite.bean;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by DR on 2018/2/6.
 */
@RealmClass
public class NovelInfoBean implements RealmModel {



    @PrimaryKey
    private int novelId;//主键ID
    private String novelName;//小说名称
    private NOVEL_TYPE novelType;//小说类型
    private String author;//作者
    private String description;//描述
    private String image;//缩略封面

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNovelId() {
        return novelId;
    }

    public void setNovelId(int novelId) {
        this.novelId = novelId;
    }

    public String getNovelName() {
        return novelName;
    }

    public void setNovelName(String novelName) {
        this.novelName = novelName;
    }

    public NOVEL_TYPE getNovelType() {
        return novelType;
    }

    public void setNovelType(NOVEL_TYPE novelType) {
        this.novelType = novelType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 小说类型
     */
    public enum NOVEL_TYPE {
        MO_HUAN("魔幻"),
        YAN_QING("言情"),
        KE_HUAN("科幻"),
        CHUAN_YUE("穿越"),
        YOU_XI("游戏");

        private String novelType;

        NOVEL_TYPE(String type) {
            this.novelType = type;
        }

        public String getNovelType() {
            return novelType;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"novelId\":")
                .append(novelId);
        sb.append(",\"novelName\":\"")
                .append(novelName).append('\"');
        sb.append(",\"novelType\":")
                .append(novelType);
        sb.append(",\"author\":\"")
                .append(author).append('\"');
        sb.append(",\"description\":\"")
                .append(description).append('\"');
        sb.append(",\"image\":\"")
                .append(image).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
