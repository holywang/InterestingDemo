package com.holy.interestingdemo.designpattern.factorypattern.factorys;

import android.content.Context;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.designpattern.factorypattern.base.INovels;
import com.holy.interestingdemo.designpattern.factorypattern.son.ChuanyueNovel;
import com.holy.interestingdemo.designpattern.factorypattern.son.DushiNovel;
import com.holy.interestingdemo.designpattern.factorypattern.son.KehuanNovel;
import com.holy.interestingdemo.designpattern.factorypattern.son.MohuanNovel;
import com.holy.interestingdemo.designpattern.factorypattern.son.YanqingNovel;
import com.holy.interestingdemo.designpattern.factorypattern.son.YouxiNovel;

import java.util.Arrays;

/**
 * Created by DR on 2018/4/16.
 */

public class NovelFactory {

    /**
     * 创建产品
     * @param clz Class
     * @param <T> 产品实现类
     * @return 产品实现类
     */
    public static <T extends INovels> T createNovel(Class<T> clz) {
        T result = null;
        try {
            result = (T) Class.forName(clz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取具体工厂产品
     * @param context
     * @param type
     * @return
     */
    public static INovels getNovelByType(Context context ,String type){

        String[] types = context.getResources().getStringArray(R.array.novel_type);
        if (type.equals(types[0])){
            return createNovel(MohuanNovel.class);
        }else if (type.equals(types[1])){
            return createNovel(YanqingNovel.class);
        }else if (type.equals(types[2])){
            return createNovel(KehuanNovel.class);
        }else if (type.equals(types[3])){
            return createNovel(ChuanyueNovel.class);
        }else if (type.equals(types[4])){
            return createNovel(YouxiNovel.class);
        }else if (type.equals(types[5])){
            return createNovel(DushiNovel.class);
        }else{
            return null;
        }
    }
}
