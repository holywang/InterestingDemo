package com.holy.interestingdemo.funnyplayer.model.bean;

/**
 * Created by DR on 2018/3/5.
 */

public class PlayerBean {
    private long id;
    private String name;
    private String title;
    private String type;
    private String url;
    private long duration;
    private float size;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"title\":\"")
                .append(title).append('\"');
        sb.append(",\"type\":\"")
                .append(type).append('\"');
        sb.append(",\"url\":\"")
                .append(url).append('\"');
        sb.append(",\"duration\":")
                .append(duration);
        sb.append(",\"size\":")
                .append(size);
        sb.append('}');
        return sb.toString();
    }
}
