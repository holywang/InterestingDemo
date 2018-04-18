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
import com.holy.interestingdemo.views.NovelInputText;


public class NovelWriteFragment extends BaseFragment {

    public static final String TAG = "NovelWriteFragment";

    private NovelInputText novelInput;


    public NovelWriteFragment() {
        // Required empty public constructor
    }


    public static NovelWriteFragment newInstance(INovelDetail novelDetail, String param2) {
        NovelWriteFragment fragment = new NovelWriteFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }


    @Override
    public View setInflateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_novel_write, container, false);
    }

    @Override
    public void initViews(View view) {
        novelInput = view.findViewById(R.id.novel_input);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void doSth() {
        L.i(TAG,novelInput.getInputText());
    }


}
