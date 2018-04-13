package com.holy.interestingdemo.eventbusdemo;

/**
 * Created by DR on 2018/4/13.
 * EventBus定义事件
 */
public class MessageEvent {

    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
