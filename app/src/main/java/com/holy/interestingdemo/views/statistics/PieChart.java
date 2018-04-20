package com.holy.interestingdemo.views.statistics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.holy.interestingdemo.utils.L;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DR on 2018/4/19.
 */

public class PieChart extends View {
    public static final String TAG = "PieChart";

    private List<PieItem> pieList;//数据：内容的一个集合

    private int mWidth, mHeight;//宽高

    private float mStartAngle = 0;//饼图的初始角度

    public PieChart(Context context) {
        this(context, null);
    }

    public PieChart(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PieChart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public PieChart(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        pieList = new ArrayList<>();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        L.i(TAG, "list size : " + pieList.size());
        if (pieList.size() == 0) {
            return;
        }

        float currentStartAngle = mStartAngle;                    // 当前起始角度
        canvas.translate(mWidth / 2, mHeight / 2);                // 将画布坐标原点移动到中心位置
        float r = (float) (Math.min(mWidth, mHeight) / 2 * 0.8);  // 饼状图半径
        RectF rect = new RectF(-r, -r, r, r);// 饼状图绘制区域

        for (int i = 0; i < pieList.size(); i++) {
            float f = pieList.get(i).getNum();
            float radian = getRadian(f);

            canvas.drawArc(
                    rect,
                    currentStartAngle,
                    radian,
                    true,
                    setPiePaint(pieList.get(i).getColor(), 10f));

            currentStartAngle += radian;
        }

    }

    /**
     * 获取整个列表所有数值之和
     *
     * @return
     */
    private float getAllValue() {
        float sum = 0;
        for (int i = 0; i < pieList.size(); i++) {
            sum += pieList.get(i).getNum();
        }
        return sum;
    }

    /**
     * 获取弧度
     *
     * @param input
     * @return
     */
    private float getRadian(float input) {
        float i =(input / getAllValue()) * 360 ;
        return i;
    }

    /**
     * 设置饼图扇形的画笔
     *
     * @param color
     * @param stroke
     * @return
     */
    private Paint setPiePaint(
            int color,
            float stroke
    ) {

        Paint p = new Paint();
        p.setColor(color);
        p.setStyle(Paint.Style.FILL);
        p.setStrokeWidth(stroke);
        p.setAntiAlias(true);

        return p;
    }

    /** 从这里开始是暴露到外部的方法 *********************************************************************************************************************************************/

    /**
     * 添加一个扇面
     *
     * @param value 值
     * @param color 颜色
     * @param desc  描述
     * @return 返回自己以便连续添加
     */
    public PieChart add(float value, int color, String desc) {
        PieItem item = new PieItem();
        item.setColor(color);
        item.setDesc(desc);
        item.setNum(value);
        pieList.add(item);
        invalidate();
        return this;
    }

    /**
     * 对外暴露获取数据接口
     *
     * @return 数据list
     */
    public List<PieItem> getPieList() {
        return pieList;
    }

    class PieItem {
        private int color;
        private String desc;
        private float num;

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public float getNum() {
            return num;
        }

        public void setNum(float num) {
            this.num = num;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"color\":")
                    .append(color);
            sb.append(",\"desc\":\"")
                    .append(desc).append('\"');
            sb.append(",\"num\":")
                    .append(num);
            sb.append('}');
            return sb.toString();
        }
    }
}
