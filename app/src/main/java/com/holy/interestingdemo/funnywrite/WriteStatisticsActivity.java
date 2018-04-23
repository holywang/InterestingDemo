package com.holy.interestingdemo.funnywrite;

import android.graphics.Color;
import android.view.View;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.mainInfo.BaseActivity;
import com.holy.interestingdemo.utils.L;
import com.holy.interestingdemo.views.statistics.PieChart;

public class WriteStatisticsActivity extends BaseActivity {
    private static final String TAG = "WriteStatisticsActivity";

    private PieChart pieChart;


    @Override
    public void toSetContentView() {
        setContentView(R.layout.activity_write_statistics);
    }

    @Override
    public void initViews() {
        pieChart = findViewById(R.id.statistics_pie_view);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void doSth() {
        pieChart.add(35.2f, Color.RED, "红色部分")
                .add(40.2f, Color.GREEN, "绿色部分")
                .add(39f, Color.BLUE, "蓝色部分")
                .add(31.2f, Color.YELLOW, "黄色部分")
                .add(29.7f, Color.GRAY, "灰色部分");
        L.i(TAG,"add finish");
    }

    @Override
    public void onClick(View v) {

    }
}
