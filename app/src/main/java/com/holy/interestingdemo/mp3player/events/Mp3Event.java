package com.holy.interestingdemo.mp3player.events;

/**
 * Created by DR on 2018/4/13.
 * MP3的分发事件
 */

public class Mp3Event {

    private int flag;

    /**
     * 构造方法
     * @param flag 传入标识
     *             1：播放
     *             2：暂停
     *             3：上一曲
     *             4：下一曲
     *             5：停止
     *             6:更换展示信息
     */
    public Mp3Event(int flag){
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
