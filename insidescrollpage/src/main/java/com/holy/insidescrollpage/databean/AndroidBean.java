package com.holy.insidescrollpage.databean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DR on 2018/5/28.
 */

public class AndroidBean implements Serializable{

    /**
     * error : false
     * results : [{"_id":"5b069d89421aa97f0624f428","createdAt":"2018-05-25T10:27:08.275Z","desc":"android 仿头条 微信大图预览动画 双击缩放 保存至相册","publishedAt":"2018-05-25T10:30:37.805Z","source":"chrome","type":"Android","url":"https://github.com/cedear/GalleryView","used":true,"who":"lijinshanmx"},{"_id":"5b069da7421aa97f0624f429","createdAt":"2018-05-24T19:10:31.41Z","desc":"Android串口调试助手","images":["http://img.gank.io/243d3d35-749d-4018-a11d-94fe1090fe3b","http://img.gank.io/2bfcb09b-d610-40d9-b1f3-7ceea95d9c17","http://img.gank.io/62b32a52-4931-4dc1-81ed-0b3a9d0d39c0"],"publishedAt":"2018-05-25T10:30:37.805Z","source":"chrome","type":"Android","url":"https://github.com/licheedev/Android-SerialPort-Tool","used":true,"who":"lijinshanmx"},{"_id":"5b069db8421aa97f03088338","createdAt":"2018-05-25T10:22:58.503Z","desc":"一个轻量级的AOP(Android)应用框架","images":["http://img.gank.io/ce9c7a13-b6a8-444c-9959-24fe090e2bc8"],"publishedAt":"2018-05-25T10:30:37.805Z","source":"chrome","type":"Android","url":"https://github.com/xuexiangjys/XAOP","used":true,"who":"lijinshanmx"},{"_id":"5b069dca421aa97efda8652a","createdAt":"2018-05-25T10:22:33.931Z","desc":"一个轻松创建和添加设置（AKA首选项）到您的Android应用程序库","images":["http://img.gank.io/e4d66f03-17c5-42b3-a0a9-a204504fb65f","http://img.gank.io/fdeb0006-98bf-459d-8df7-07b5b6036320","http://img.gank.io/1b47e6b4-5d21-46d7-b643-54c520c1db78"],"publishedAt":"2018-05-25T10:30:37.805Z","source":"chrome","type":"Android","url":"https://github.com/or-dvir/EasySettings","used":true,"who":"lijinshanmx"},{"_id":"5b069df3421aa97f0308833c","createdAt":"2018-05-25T10:21:27.707Z","desc":"Flutter拖放列表的实现","images":["http://img.gank.io/7bc083e8-e861-41b7-b6d4-1010f9ce24e8"],"publishedAt":"2018-05-25T10:30:37.805Z","source":"chrome","type":"Android","url":"https://github.com/Norbert515/flutter_list_drag_and_drop","used":true,"who":"lijinshanmx"},{"_id":"5b069e11421aa97f0624f42b","createdAt":"2018-05-25T10:21:02.791Z","desc":"一个优雅的外观和易于使用的Android信息库。","publishedAt":"2018-05-25T10:30:37.805Z","source":"chrome","type":"Android","url":"https://github.com/yuvraj24/LiveSmashBar","used":true,"who":"lijinshanmx"},{"_id":"5b069e30421aa97f0624f42c","createdAt":"2018-05-25T10:20:38.88Z","desc":"一个计算器Dialog.","images":["http://img.gank.io/10a8174c-69f2-4926-a83b-529fc25dbe71","http://img.gank.io/73bd7926-ea5c-43cf-a300-7b58ac91ade6"],"publishedAt":"2018-05-25T10:30:37.805Z","source":"chrome","type":"Android","url":"https://github.com/maltaisn/calcdialoglib","used":true,"who":"lijinshanmx"},{"_id":"5b02ada4421aa97aa11c234c","createdAt":"2018-05-21T19:29:40.273Z","desc":"Computer Vision on Android with Kotlin and Tensorflow Lite","images":["http://img.gank.io/e45d1fad-1497-47e0-866c-8883efdf7856","http://img.gank.io/39a4f7c8-113f-4369-9078-4de87d0bbff8","http://img.gank.io/1643e374-0dbc-4c0e-9cc0-0526515770cf","http://img.gank.io/22d932f5-ac7c-45e5-98f3-56fa586819b8"],"publishedAt":"2018-05-24T11:03:54.588Z","source":"chrome","type":"Android","url":"https://github.com/eddywm/KTFLITE","used":true,"who":"lijinshanmx"},{"_id":"5b04c482421aa97f03088329","createdAt":"2018-05-24T10:55:45.184Z","desc":"时间选择器、省市区三级联动","publishedAt":"2018-05-24T11:03:54.588Z","source":"web","type":"Android","url":"https://github.com/Bigkoo/Android-PickerView","used":true,"who":"nan403"},{"_id":"5b061bdd421aa97efda86521","createdAt":"2018-05-24T09:56:45.611Z","desc":"XRouter 一个轻量级的Android路由框架，基于ARouter上进行改良，优化Fragment的使用，可结合XPage使用","publishedAt":"2018-05-24T11:03:54.588Z","source":"chrome","type":"Android","url":"https://blog.csdn.net/xuexiangjys/article/details/80414078","used":true,"who":"xuexiangjys"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean implements Serializable {
        /**
         * _id : 5b069d89421aa97f0624f428
         * createdAt : 2018-05-25T10:27:08.275Z
         * desc : android 仿头条 微信大图预览动画 双击缩放 保存至相册
         * publishedAt : 2018-05-25T10:30:37.805Z
         * source : chrome
         * type : Android
         * url : https://github.com/cedear/GalleryView
         * used : true
         * who : lijinshanmx
         * images : ["http://img.gank.io/243d3d35-749d-4018-a11d-94fe1090fe3b","http://img.gank.io/2bfcb09b-d610-40d9-b1f3-7ceea95d9c17","http://img.gank.io/62b32a52-4931-4dc1-81ed-0b3a9d0d39c0"]
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
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

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"_id\":\"")
                    .append(_id).append('\"');
            sb.append(",\"createdAt\":\"")
                    .append(createdAt).append('\"');
            sb.append(",\"desc\":\"")
                    .append(desc).append('\"');
            sb.append(",\"publishedAt\":\"")
                    .append(publishedAt).append('\"');
            sb.append(",\"source\":\"")
                    .append(source).append('\"');
            sb.append(",\"type\":\"")
                    .append(type).append('\"');
            sb.append(",\"url\":\"")
                    .append(url).append('\"');
            sb.append(",\"used\":")
                    .append(used);
            sb.append(",\"who\":\"")
                    .append(who).append('\"');
            sb.append(",\"images\":")
                    .append(images);
            sb.append('}');
            return sb.toString();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"error\":")
                .append(error);
        sb.append(",\"results\":")
                .append(results);
        sb.append('}');
        return sb.toString();
    }
}
