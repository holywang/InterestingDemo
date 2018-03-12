package com.holy.interestingdemo.funnyplayer;

import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;

import com.holy.interestingdemo.R;

import java.io.IOException;

public class VideoPlayActivity extends PlayerBaseActivity implements TextureView.SurfaceTextureListener, MediaPlayer.OnPreparedListener{

    private Button backBtn;
    private TextureView playerTextureView;

    private MediaPlayer mediaPlayer;

    private Intent dataIntent;

    private SurfaceTexture mTexture;
    private SurfaceHolder holder;
    private Surface surface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        setDefaultSetting();
        initView();
        setListener();
    }

    private void setDefaultSetting(){
        dataIntent = getIntent();
        getWindow()
                .getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_IMMERSIVE
                                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    private void initView(){
        backBtn = findViewById(R.id.video_player_back);
        playerTextureView = findViewById(R.id.player_texture_view);

    }

    private void setListener(){
        backBtn.setOnClickListener(view -> {
            finish();
        });
        playerTextureView.setSurfaceTextureListener(this);
    }

    private void doPlay(){
        if (mediaPlayer == null) {
            mTexture = playerTextureView.getSurfaceTexture();
            surface = new Surface(mTexture);
            initMediaPlayer();
        }
    }

    private void initMediaPlayer(){
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(dataIntent.getStringExtra("url"));
            mediaPlayer.setSurface(surface);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setLooping(true);
        } catch (IllegalArgumentException | SecurityException | IllegalStateException | IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        try {
            if (mediaPlayer != null) {
                mediaPlayer.start(); //视频开始播放
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (playerTextureView.isAvailable()) {
            doPlay();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mTexture != null) {
            mTexture.release();  //停止视频的绘制线程
        }
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer =null;
        }
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
        doPlay();
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
