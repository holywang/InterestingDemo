package com.holy.interestingdemo.funnywrite.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.designpattern.factorypattern.base.INovelDetail;
import com.holy.interestingdemo.designpattern.factorypattern.base.INovels;
import com.holy.interestingdemo.funnywrite.adapter.NovelDetailAdapter;
import com.holy.interestingdemo.funnywrite.database.DatabaseConstant;
import com.holy.interestingdemo.funnywrite.database.DatabaseManager;
import com.holy.interestingdemo.funnywrite.database.DatabaseUtils;
import com.holy.interestingdemo.mainInfo.BaseFragment;
import com.holy.interestingdemo.mainInfo.listener.RecyclerViewOnItemClickListener;
import com.holy.interestingdemo.mainInfo.listener.RecyclerViewUpLoadingListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * created by holyWang at 2018/04/17
 */

public class NovelListFragment extends BaseFragment {

    private static final String NOVEL = "novel";


    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private NovelDetailAdapter adapter;
    private LinearLayout defaultLayout;
    private Button addNewBtn;

    private LinearLayoutManager mLayoutManager;

    private INovels novel;
    private List<INovelDetail> novelDetailList;


    public NovelListFragment() {
        // Required empty public constructor
    }

    /**
     * NovelListFragment的实例化方法
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
    public View setInflateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_novel_list, container, false);
    }

    @Override
    public void initViews(View view) {
        refreshLayout = view.findViewById(R.id.novel_detail_list_refresh);
        recyclerView = view.findViewById(R.id.novel_detail_list);
        defaultLayout = view.findViewById(R.id.novel_detail_default);
        addNewBtn = view.findViewById(R.id.novel_detail_add_new);

        if (getListData(novel.getNovel_id()).size() == 0) {
            refreshLayout.setVisibility(View.GONE);
            defaultLayout.setVisibility(View.VISIBLE);
        } else {
            refreshLayout.setVisibility(View.VISIBLE);
            defaultLayout.setVisibility(View.GONE);
        }

    }

    @Override
    public void setListener() {

        addNewBtn.setOnClickListener(view -> addNewNovelDetail());

    }

    @Override
    public void doSth() {
        novelDetailList = getListData(novel.getNovel_id());
        refreshLayout.setColorSchemeResources(
                R.color.colorAccent, R.color.colorPrimary
        );
        if (novelDetailList.isEmpty()) return;
        if (novelDetailList.size() <= 0) return;

        adapter = new NovelDetailAdapter(getActivity(), getListData(novel.getNovel_id()));
        adapter.setOnItemClickListener(new RecyclerViewOnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, Object data) {
                if (data instanceof INovelDetail) {
                    INovelDetail novelData = (INovelDetail) data;
                }
            }
        });

        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        refreshLayout.setOnRefreshListener(() -> {
            Snackbar.make(refreshLayout, "刷新咯", Snackbar.LENGTH_SHORT).show();
        });
        recyclerView.addOnScrollListener(new RecyclerViewUpLoadingListener(mLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                Snackbar.make(refreshLayout, "加载了更多哦", Snackbar.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * 获取小说详情数据
     *
     * @return INovelDetail的列表
     */
    private List<INovelDetail> getListData(String novelId) {

        List<INovelDetail> list = new ArrayList<>();

        DatabaseManager manager = new DatabaseManager(getActivity());
        List<Map<String, String>> dataList = DatabaseUtils.getList(
                manager.queryAll(DatabaseConstant.NOVEL_CONTEXT_TABLE),
                DatabaseConstant.NOVEL_CONTEXT_TABLE);

        for (Map<String, String> map : dataList) {
            if (novelId.equals(map.get(DatabaseConstant.NOVEL_CONTEXT_ARRAY[0]))) {
                INovelDetail novelDetail = new INovelDetail();
                novelDetail.setNovel_id(map.get(DatabaseConstant.NOVEL_CONTEXT_ARRAY[0]));
                novelDetail.setSession(map.get(DatabaseConstant.NOVEL_CONTEXT_ARRAY[1]));
                novelDetail.setPage(map.get(DatabaseConstant.NOVEL_CONTEXT_ARRAY[2]));
                novelDetail.setContext(new File(map.get(DatabaseConstant.NOVEL_CONTEXT_ARRAY[3])));
                list.add(novelDetail);
            }
        }

        return list;
    }

    /**
     * 新建一个NovelDetail
     */
    private void addNewNovelDetail() {

    }


}
