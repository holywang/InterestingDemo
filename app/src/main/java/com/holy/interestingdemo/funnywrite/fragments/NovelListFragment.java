package com.holy.interestingdemo.funnywrite.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.designpattern.factorypattern.base.INovelDetail;
import com.holy.interestingdemo.designpattern.factorypattern.base.INovels;
import com.holy.interestingdemo.funnywrite.adapter.NovelDetailAdapter;
import com.holy.interestingdemo.funnywrite.database.DatabaseConstant;
import com.holy.interestingdemo.funnywrite.database.DatabaseManager;
import com.holy.interestingdemo.funnywrite.database.DatabaseUtils;
import com.holy.interestingdemo.funnywrite.event.NovelListFragmentEvent;
import com.holy.interestingdemo.mainInfo.BaseFragment;
import com.holy.interestingdemo.mainInfo.listener.RecyclerViewOnItemClickListener;
import com.holy.interestingdemo.mainInfo.listener.RecyclerViewUpLoadingListener;

import org.greenrobot.eventbus.EventBus;
import org.w3c.dom.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * created by holyWang at 2018/04/17
 */

public class NovelListFragment extends BaseFragment {

    private static final String NOVEL = "novel";


    private RecyclerView recyclerView;
    private NovelDetailAdapter adapter;

    private LinearLayoutManager mLayoutManager;

    private INovels novel;
    private List<INovelDetail> novelDetailList;


    public NovelListFragment() {
        // Required empty public constructor
    }

    /**
     * NovelListFragment的实例化方法
     *
     * @param novel
     * @return
     */
    public static NovelListFragment newInstance(INovels novel) {

        NovelListFragment fragment = new NovelListFragment();
        Bundle args = new Bundle();
        args.putSerializable("novel", novel);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            novel = (INovels) getArguments().getSerializable(NOVEL);
        }

    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }

    @Override
    public View setInflateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_novel_list, container, false);
    }

    @Override
    public void initViews(View view) {
        recyclerView = view.findViewById(R.id.novel_detail_list);

    }

    @Override
    public void setListener() {

    }

    @Override
    public void doSth() {
        novelDetailList = getListData(novel.getNovelId());
        if (novelDetailList.isEmpty()) return;
        if (novelDetailList.size() <= 0) return;
        adapter = new NovelDetailAdapter(getActivity(), novelDetailList);
        adapter.setOnItemClickListener(new RecyclerViewOnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, Object data) {
                if (data == null) {
                    addNewNovelDetail();
                    return;
                }
                final INovelDetail novelData = (INovelDetail) data;
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle("操作");
                dialog.setPositiveButton("阅读", (dialog1, which) -> toReadNovelDetail(novelData));
                dialog.setNegativeButton("修改", (dialog12, which) -> toUpdateNovelDetail(novelData));
                dialog.create().show();
            }
        });

        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }


    /**
     * 获取小说详情数据
     *
     * @return INovelDetail的列表
     */
    private List<INovelDetail> getListData(String novelId) {

        List<INovelDetail> list = new ArrayList<>();

//        DatabaseManager manager = new DatabaseManager(getActivity());
//        List<Map<String, String>> dataList = DatabaseUtils.getList(
//                manager.queryAll(DatabaseConstant.NOVEL_CONTEXT_TABLE),
//                DatabaseConstant.NOVEL_CONTEXT_TABLE);
//
//        for (Map<String, String> map : dataList) {
//            if (novelId.equals(map.get(DatabaseConstant.NOVEL_CONTEXT_ARRAY[0]))) {
//                INovelDetail novelDetail = new INovelDetail();
//                novelDetail.setNovel_id(map.get(DatabaseConstant.NOVEL_CONTEXT_ARRAY[0]));
//                novelDetail.setSession(map.get(DatabaseConstant.NOVEL_CONTEXT_ARRAY[1]));
//                novelDetail.setPage(map.get(DatabaseConstant.NOVEL_CONTEXT_ARRAY[2]));
//                novelDetail.setContext(new File(map.get(DatabaseConstant.NOVEL_CONTEXT_ARRAY[3])));
//                list.add(novelDetail);
//            }
//        }
//
//        return list;
        return getFakeData();
    }

    public List<INovelDetail> getFakeData() {

        List<INovelDetail> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            INovelDetail item = new INovelDetail();
            item.setNovelId("fake");
            item.setContext(null);
            item.setPage("王侯将相，宁有种乎");
            item.setSession("" + (i + 1));
            list.add(item);
        }

        return list;

    }

    /**
     * 新建一个NovelDetail
     */
    private void addNewNovelDetail() {
        EventBus.getDefault().postSticky(new NovelListFragmentEvent("add"));
    }

    private void toReadNovelDetail(INovelDetail data) {
        NovelListFragmentEvent readEvent = new NovelListFragmentEvent("read");
        readEvent.setData(data);
        EventBus.getDefault().postSticky(readEvent);
    }

    private void toUpdateNovelDetail(INovelDetail data) {
        NovelListFragmentEvent updateEvent = new NovelListFragmentEvent("update");
        updateEvent.setData(data);
        EventBus.getDefault().postSticky(updateEvent);
    }


}
