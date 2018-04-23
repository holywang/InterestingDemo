package com.holy.interestingdemo.annotations;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.view.View;

import com.holy.interestingdemo.utils.L;

import java.lang.reflect.Field;

/**
 * BindView注册器
 * Created by DR on 2018/4/23.
 */

public class BindViewInstaller {
    public final static String TAG = "BindViewInstaller";

    /**
     * BindView 注解注册方法
     * @param context
     * @param decorView
     */
    public static void initBindView(Object context, View decorView) {

        Field[] fields = context.getClass().getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (int i = 0; i < fields.length; i++) {
                BindView bindView = fields[i].getAnnotation(BindView.class);
                if (bindView != null) {
                    int viewId = bindView.id();
                    fields[i].setAccessible(true);
                    try {
                        fields[i].set(context, decorView.findViewById(viewId));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            }
        }


    }

    public static void initBindView(Activity activity) {
        initBindView(activity, activity.getWindow().getDecorView());
    }

    @TargetApi(11)
    public static void initBindView(Fragment fragment) {
        initBindView(fragment, fragment.getActivity().getWindow().getDecorView());
    }

    public static void initBindView(View view) {
        if (view.getContext() instanceof Activity) {
            initBindView((Activity) view.getContext());
        }else{
            L.e(TAG,"the view have no root view",null);
        }
    }
}
