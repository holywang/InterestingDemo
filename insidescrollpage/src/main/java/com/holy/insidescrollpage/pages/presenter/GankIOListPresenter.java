package com.holy.insidescrollpage.pages.presenter;

import com.holy.insidescrollpage.databean.AndroidBean;
import com.holy.insidescrollpage.databean.FuLiBean;
import com.holy.insidescrollpage.databean.WebBean;
import com.holy.insidescrollpage.pages.model.DataModel;
import com.holy.insidescrollpage.pages.model.IDataImpl;
import com.holy.insidescrollpage.pages.view.interfaces.BaseFunction;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DR on 2018/5/28.
 */

public class GankIOListPresenter {

    private DataModel dataModel;
    private BaseFunction baseFunction;

    private static int androidPage = 1;
    private static int fuliPage = 1;
    private static int webPage = 1;

    public static int finishFlag = 0;


    public GankIOListPresenter(BaseFunction baseFunction) {
        this.baseFunction = baseFunction;
        dataModel = new IDataImpl();
    }

    /**
     * 加载页面布局
     */
    public void initView() {
        baseFunction.initView();
    }

    /**
     * 刷新数据
     */
    public void refresh() {
        baseFunction.clearData();
        getDefaultData();
    }

    /**
     * 获取所有数据
     */
    public void getDefaultData() {
        baseFunction.showProgress();
        Observable<AndroidBean> androidObs = dataModel.getAndroidData(1, 10);
        Observable<FuLiBean> fuliObs = dataModel.getFuliData(1, 10);
        Observable<WebBean> webObs = dataModel.getWebData(1, 10);
        Observable.merge(androidObs, fuliObs, webObs)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        baseFunction.hideProgress();
                        baseFunction.toast("部分数据异常");
                    }

                    @Override
                    public void onNext(Object obj) {
                        if (obj instanceof AndroidBean) {
                            finishFlag += 1;
                            baseFunction.setAndroidList((AndroidBean) obj);
                        } else if (obj instanceof FuLiBean) {
                            finishFlag += 1;
                            baseFunction.setFuliList((FuLiBean) obj);
                        } else if (obj instanceof WebBean) {
                            finishFlag += 1;
                            baseFunction.setWebList((WebBean) obj);
                        }

                        if (finishFlag == 3) {
                            baseFunction.hideProgress();
                            finishFlag = 0;
                        }
                    }
                });
    }

    public void addAndroidData() {
        androidPage += 1;
        dataModel.getAndroidData(androidPage, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AndroidBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(AndroidBean androidBean) {
                        baseFunction.setAndroidList(androidBean);
                    }
                });

    }

    public void addFuliData() {
        fuliPage += 1;
        dataModel.getFuliData(fuliPage, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<FuLiBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(FuLiBean fuLiBean) {
                        baseFunction.setFuliList(fuLiBean);
                    }
                });
    }

    public void addWebData() {
        webPage += 1;
        dataModel.getWebData(webPage, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WebBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(WebBean webBean) {
                        baseFunction.setWebList(webBean);
                    }
                });
    }


}
