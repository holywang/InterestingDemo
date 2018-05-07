package com.holy.interestingdemo.funnyplayer.presenter;

import android.content.Context;
import android.view.ViewGroup;

import com.holy.interestingdemo.funnyplayer.model.IPlayerListModel;
import com.holy.interestingdemo.funnyplayer.model.PlayerListModelImpl;
import com.holy.interestingdemo.funnyplayer.model.bean.PlayerBean;
import com.holy.interestingdemo.funnyplayer.view.IListVideoPlay;

import java.util.List;

/**
 * Created by DR on 2018/5/7.
 */

public class ListVideoPlayPresenter extends BasePresenter{
    private IListVideoPlay iActivity;
    private IPlayerListModel iPlayerListModel;

    public ListVideoPlayPresenter(IListVideoPlay iActivity){
        this.iActivity = iActivity;
        iPlayerListModel = PlayerListModelImpl.getInstance();
    }

    @Override
    public boolean showLoading(ViewGroup rootView) {
        iActivity.showLoading(rootView);
        return false;
    }

    public List<PlayerBean> getList(Context context){
        return iPlayerListModel.getPlayerList(context);
    }
}
