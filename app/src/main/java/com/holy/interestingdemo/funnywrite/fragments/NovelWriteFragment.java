package com.holy.interestingdemo.funnywrite.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.designpattern.factorypattern.base.INovelDetail;
import com.holy.interestingdemo.mainInfo.BaseFragment;
import com.holy.interestingdemo.utils.L;


public class NovelWriteFragment extends BaseFragment {

    public static final String TAG = "NovelWriteFragment";

    private String novelId;
    private INovelDetail novelDetail;
    private String action;

    public NovelWriteFragment() {
        // Required empty public constructor
    }


    public static NovelWriteFragment newInstance(INovelDetail novelDetail, String action) {
        NovelWriteFragment fragment = new NovelWriteFragment();
        Bundle args = new Bundle();
        args.putSerializable("data", novelDetail);
        args.putString("action", action);
        args.putString("id", null);
        fragment.setArguments(args);
        return fragment;
    }

    public static NovelWriteFragment newInstance(String novelId, String action) {
        NovelWriteFragment fragment = new NovelWriteFragment();
        Bundle args = new Bundle();
        args.putSerializable("data", null);
        args.putString("id", novelId);
        args.putString("action", action);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            novelDetail = (INovelDetail) getArguments().getSerializable("data");
            novelId = getArguments().getString("id");
            action = getArguments().getString("action");
        }
    }


    @Override
    public View setInflateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_novel_write, container, false);
    }

    @Override
    public void initViews(View view) {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void doSth() {

    }


}
