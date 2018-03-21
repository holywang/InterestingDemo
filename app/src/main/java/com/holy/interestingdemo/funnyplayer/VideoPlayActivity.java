package com.holy.interestingdemo.funnyplayer;

import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.funnyplayer.presenter.VideoPlayerPresenter;
import com.holy.interestingdemo.funnyplayer.view.IVideoPlay;
import com.holy.interestingdemo.utils.L;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class VideoPlayActivity extends PlayerBaseActivity
        implements
        TextureView.SurfaceTextureListener,
        MediaPlayer.OnPreparedListener,
        IVideoPlay,
        SeekBar.OnSeekBarChangeListener

{

    private final static String TAG = "VideoPlayActivity";
    private Button backBtn, lastBtn, pauseBtn, nextBtn;
    private TextureView playerTextureView;
    private SeekBar videoProgress;
    private TextView timeText;

    private MediaPlayer mediaPlayer;
    private SurfaceTexture mTexture;
    private SurfaceHolder holder;
    private Surface surface;
    private VideoPlayerPresenter videoPlayerPresenter;

    private Intent dataIntent;
    private Timer mTimer;
    private TimerTask mTimerTask;

    private boolean onPauseFlag = false;
    private int pauseProgress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        setDefaultSetting();
        initView();
        setListener();
    }

    private void setDefaultSetting() {
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
        videoPlayerPresenter = new VideoPlayerPresenter(this, dataIntent.getStringExtra("url"));

    }

    private void initView() {
        backBtn = findViewById(R.id.video_player_back);
        playerTextureView = findViewById(R.id.player_texture_view);
        lastBtn = findViewById(R.id.video_player_last);
        pauseBtn = findViewById(R.id.video_player_pause);
        nextBtn = findViewById(R.id.video_player_next);
        videoProgress = findViewById(R.id.video_player_progress);
        timeText = findViewById(R.id.video_player_time);
    }

    private void setListener() {
        backBtn.setOnClickListener(view -> finish());
        playerTextureView.setSurfaceTextureListener(this);
        videoProgress.setOnSeekBarChangeListener(this);
        pauseBtn.setOnClickListener(view -> pause());
        lastBtn.setOnClickListener(view -> videoPlayerPresenter.last(view));
        nextBtn.setOnClickListener(view -> videoPlayerPresenter.next(view));


    }

    @Override
    public void mediaPlay(String url) {
        try {
            if (mediaPlayer == null) {
                mTexture = playerTextureView.getSurfaceTexture();
                surface = new Surface(mTexture);
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setDataSource(url);
                mediaPlayer.setSurface(surface);
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(this);
                mediaPlayer.setOnVideoSizeChangedListener((mediaPlayer, width, height) -> {
                    if (width == 0 || height == 0) {
                        return;
                    }
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                            (playerTextureView.getHeight() * width) / height,
                            playerTextureView.getHeight()
                    );
                    playerTextureView.setLayoutParams(lp);
                });
                mediaPlayer.setLooping(true);

                videoProgress.setMax(mediaPlayer.getDuration());
            }
        } catch (IllegalArgumentException | SecurityException | IllegalStateException | IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void mediaRelease() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public void showSnackBar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
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
            videoPlayerPresenter.startNewVideo();

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
            mediaPlayer = null;
        }
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
        videoPlayerPresenter.startNewVideo();
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

    /**
     * 播放暂停/续播
     */
    private void pause() {
        if (onPauseFlag == false) {
            mediaPlayer.pause();
            onPauseFlag = true;
            pauseProgress = mediaPlayer.getCurrentPosition();
            pauseBtn.setText("restart");
        } else {
            mediaPlayer.seekTo(pauseProgress + 1);
            mediaPlayer.start();
            onPauseFlag = false;
            pauseBtn.setText("pause");
        }
        L.i(TAG,"Duration :--->"+mediaPlayer.getDuration());
        L.i(TAG, "CurrentPosition :--->"+mediaPlayer.getCurrentPosition());
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.seekTo(seekBar.getProgress());
            mediaPlayer.start();
        }
    }


}
