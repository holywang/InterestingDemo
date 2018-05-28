package com.holy.insidescrollpage.databean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DR on 2018/5/28.
 */

public class WebBean implements Serializable{

    /**
     * error : false
     * results : [{"_id":"5b06a111421aa97efda8652c","createdAt":"2018-05-24T19:25:05.458Z","desc":"前端工程师必备实用网站","publishedAt":"2018-05-25T10:30:37.805Z","source":"chrome","type":"前端","url":"https://www.jianshu.com/p/53a7da454057?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io","used":true,"who":"lijinshanmx"},{"_id":"5ae4c460421aa90ff76146d0","createdAt":"2018-05-24T10:57:59.251Z","desc":"基于Vue.js的强大的虚拟滚动条","publishedAt":"2018-05-24T11:03:54.588Z","source":"web","type":"前端","url":"https://github.com/wangyi7099/vuescroll","used":true,"who":null},{"_id":"5b03d7ac421aa967a299e503","createdAt":"2018-05-24T10:57:36.756Z","desc":"优雅的控制台日志Logger","images":["http://img.gank.io/934b87c4-8c7a-4115-b445-9e6d08d01d6e","http://img.gank.io/fcacd842-65c5-4e61-b41a-cc83a05079ea","http://img.gank.io/d72c9bbf-9dc4-4bb5-8491-3f9afa02de1b"],"publishedAt":"2018-05-24T11:03:54.588Z","source":"web","type":"前端","url":"https://github.com/klauscfhq/signale","used":true,"who":"lijinshanmx"},{"_id":"5a195cd3421aa90fef203561","createdAt":"2018-05-21T21:30:23.173Z","desc":"一个极度纯净的上传插件，支持多文件上传、上传速率动态控制、真实进度监控kb/s、分块生成MD5、分块上传、MD5校验秒传、暂停、取消等。","publishedAt":"2018-05-23T00:22:29.342Z","source":"web","type":"前端","url":"https://github.com/dianbaer/anyupload","used":true,"who":"电霸儿"},{"_id":"5b03d210421aa967a5d6b807","createdAt":"2018-05-22T16:17:20.193Z","desc":"Day.js 国人出品2KB时间日期库，Moment.js 的轻量化方案，拥有同样强大的 API 10000+star","images":["http://img.gank.io/47bd87ff-a214-4eab-90d5-afd0a041dbe9"],"publishedAt":"2018-05-23T00:22:29.342Z","source":"web","type":"前端","url":"https://github.com/iamkun/dayjs","used":true,"who":"iamkun"},{"_id":"5af2f736421aa97cc3314833","createdAt":"2018-05-09T21:27:18.364Z","desc":"React实战，一个天气预报应用 ","images":["http://img.gank.io/2ae7bf69-04f3-41c3-ab9d-162153624d75"],"publishedAt":"2018-05-22T23:12:09.999Z","source":"web","type":"前端","url":"https://github.com/alivebao/weather_app","used":true,"who":"Miao"},{"_id":"5af5104b421aa968ef2c2eda","createdAt":"2018-05-11T11:38:51.407Z","desc":"帮助你以 React 方式开发 AMP 的 webpack plugin","publishedAt":"2018-05-22T23:12:09.999Z","source":"web","type":"前端","url":"https://github.com/jimmy319/amp-react-renderer-plugin","used":true,"who":"CR Jimmy"},{"_id":"5afb3edf421aa97cc331483a","createdAt":"2018-05-16T04:11:11.546Z","desc":"一套React的UI组件库","publishedAt":"2018-05-22T10:30:57.698Z","source":"web","type":"前端","url":"https://rsuitejs.com/","used":true,"who":"Simon Guo"},{"_id":"5a195c80421aa90fe2f02c8b","createdAt":"2018-05-21T00:12:52.211Z","desc":"grain是一个极简的、组件式的RPC框架，灵活且适合渐进学习，可与任何框架整合。同时包含系统通用多线程模型与消息通讯、多对多关系的分布式锁、基于Servlet的HTTP框架、基于系统通用多线程模型的Websocket框架、支持行级锁的多线程锁等组件，按需选择组件，不绑架开发者。","publishedAt":"2018-05-21T01:11:33.975Z","source":"web","type":"前端","url":"https://github.com/dianbaer/grain","used":true,"who":"电霸儿"},{"_id":"5a195ca3421aa90fef20355f","createdAt":"2018-05-21T00:12:22.680Z","desc":"juggle是一个极简的、组件式的js框架。无依赖，完美闭包，灵活且适合渐进学习，可与任何框架整合。包含（支持冒泡的事件、Tween、MV框架、http、websocket、资源、模块）等组件，按需选择组件，不绑架开发者。","publishedAt":"2018-05-21T01:11:33.975Z","source":"web","type":"前端","url":"https://github.com/dianbaer/juggle","used":true,"who":"电霸儿"}]
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

    public static class ResultsBean implements Serializable{
        /**
         * _id : 5b06a111421aa97efda8652c
         * createdAt : 2018-05-24T19:25:05.458Z
         * desc : 前端工程师必备实用网站
         * publishedAt : 2018-05-25T10:30:37.805Z
         * source : chrome
         * type : 前端
         * url : https://www.jianshu.com/p/53a7da454057?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io
         * used : true
         * who : lijinshanmx
         * images : ["http://img.gank.io/934b87c4-8c7a-4115-b445-9e6d08d01d6e","http://img.gank.io/fcacd842-65c5-4e61-b41a-cc83a05079ea","http://img.gank.io/d72c9bbf-9dc4-4bb5-8491-3f9afa02de1b"]
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
