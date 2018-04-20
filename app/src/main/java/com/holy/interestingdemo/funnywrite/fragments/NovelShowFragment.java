package com.holy.interestingdemo.funnywrite.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.mainInfo.BaseFragment;


public class NovelShowFragment extends BaseFragment {

    public static final String TAG = "NovelShowFragment";

    private String novelId;
    private String action;

    private TextView showSession,showPage,showNovel,nextPage;

    public NovelShowFragment() {
        // Required empty public constructor
    }

    /**
     * 静态实例化方法
     * @param novelId 小说ID
     * @param action 动作
     * @return 当前fragment
     */
    public static NovelShowFragment newInstance(String novelId, String action) {
        NovelShowFragment fragment = new NovelShowFragment();
        Bundle args = new Bundle();
        args.putString("id", novelId);
        args.putString("action", action);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            novelId = getArguments().getString("id");
            action = getArguments().getString("action");
        }
    }


    @Override
    public View setInflateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_novel_show, container, false);
    }

    @Override
    public void initViews(View view) {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void doSth() {
        getData();

    }

    /**
     * 获取数据
     */
    private void getData(){

    }


}
