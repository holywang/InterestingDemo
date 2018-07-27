package com.holy.interestingdemo.tabItem.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.holy.insidescrollpage.constant.GankIOApis;
import com.holy.insidescrollpage.databean.FuLiBean;
import com.holy.insidescrollpage.interfaces.NetWork;
import com.holy.interestingdemo.R;
import com.holy.interestingdemo.tabItem.fragments.home.HomeAdapter;
import com.holy.netmodule.Net;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String DEFAULT_NUMBER = "defaultNumber";
    private static final String DEFAULT_PAGE = "defaultPage";

    private static final int DEFAULT = 0;
    private static final int LOAD_MORE = 1;
    private static final int REFRESH = 2;

    // TODO: Rename and change types of parameters
    private int page;
    private int number;

    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private HomeAdapter adapter;

    List<FuLiBean.ResultsBean> datalist;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(DEFAULT_NUMBER, param1);
        args.putString(DEFAULT_PAGE, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            number = Integer.parseInt(getArguments().getString(DEFAULT_NUMBER));
            page = Integer.parseInt(getArguments().getString(DEFAULT_PAGE));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        refreshLayout = view.findViewById(R.id.list_refresh_view);
        recyclerView = view.findViewById(R.id.home_list_view);

        refreshLayout.setOnRefreshListener(refreshListener);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2
                , StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(layoutManager);
//      recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        getData(number, page, DEFAULT);


        return view;
    }

    private void getData(int number, int page, int setAdapterType) {
        new Net().get(NetWork.class, GankIOApis.FULI_API)
                .getFuLiInfo(number, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<FuLiBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("HomeFragment", "onCompleted: ", null);
                        if (datalist != null) switch (setAdapterType) {
                            case DEFAULT:
                                adapter = new HomeAdapter(getContext(), datalist);
                                recyclerView.setAdapter(adapter);
                                break;
                            case LOAD_MORE:
                                adapter.loadMore(datalist, () -> refreshLayout.setRefreshing(false));
                            case REFRESH:
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(FuLiBean fuLiBean) {
                        Log.e("HomeFragment", "onNext: ", null);
//                        recyclerView.setLayoutManager(new HomeLayoutManager());
                        datalist = fuLiBean.getResults();
                    }
                });
    }

    private SwipeRefreshLayout.OnRefreshListener refreshListener = () -> {
        page = page + 1;
        getData(number, page, LOAD_MORE);
    };


}
