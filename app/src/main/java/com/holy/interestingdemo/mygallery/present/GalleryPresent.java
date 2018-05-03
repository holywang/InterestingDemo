package com.holy.interestingdemo.mygallery.present;

import com.holy.interestingdemo.mygallery.model.DataModel;
import com.holy.interestingdemo.mygallery.model.IDataCallback;
import com.holy.interestingdemo.mygallery.model.IDataModel;
import com.holy.interestingdemo.mygallery.view.IImageShower;
import com.holy.interestingdemo.network.bean.FuliBean;

/**
 * Created by Administrator on 2018/4/17.
 */

public class GalleryPresent {

    private IDataModel dataModel;
    private IImageShower shower;

    public GalleryPresent(IImageShower shower){
        dataModel= new DataModel();
        this.shower = shower;
    }

    /**
     * 设置图片列表
     * @param number
     * @param page
     */
    public void setImageList(int number,int page){
        dataModel.getData(number, page, new IDataCallback() {
            @Override
            public <T> T returnData(Class<T> clz, T t) {
                if(t instanceof FuliBean){
                    shower.setImageFile(((FuliBean) t).getResults());
                }
                return null;
            }
        });

    }

    /**
     * 加载更多图片
     * @param number
     * @param page
     */
    public void addMoreImage(int number,int page){
        dataModel.getData(number, page, new IDataCallback() {
            @Override
            public <T> T returnData(Class<T> clz, T t) {
                if(t instanceof FuliBean){
                    shower.setImageFile(((FuliBean) t).getResults());
                }
                return null;
            }
        });
    }


}
