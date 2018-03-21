package com.holy.interestingdemo.funnyplayer.view;

import android.view.View;

/**
 * Created by DR on 2018/3/21.
 */

public interface IVideoPlay {
    /**
     *媒体播放
     */
    void mediaPlay(String url);

    /**
     * mediaPlayer释放资源
     */
    void mediaRelease();

    /**
     * 展示提示消息
     * @param view view对象
     * @param message 展示的信息
     */
    void showSnackBar(View view,String message);
}
