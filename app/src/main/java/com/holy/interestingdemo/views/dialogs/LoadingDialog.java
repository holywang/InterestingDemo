package com.holy.interestingdemo.views.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.holy.interestingdemo.R;

/**
 * Created by DR on 2018/5/7.
 */

public class LoadingDialog extends Dialog {

    protected LoadingDialog(Context context) {
        super(context);
    }

    protected LoadingDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    protected LoadingDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public static class Builder {

        private View layout;
        private LoadingDialog dialog;

        public Builder(Context context){
            dialog = new LoadingDialog(context);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = inflater.inflate(R.layout.dialog_loading, null);
            dialog.addContentView(layout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }

        public LoadingDialog create(){
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(false);
            return dialog;
        }

    }

}
