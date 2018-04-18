package com.holy.interestingdemo.views;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.utils.L;

/**
 * Created by DR on 2018/4/17.
 */

public class NovelInputText extends AppCompatEditText {

    public static final String TAG = "NovelInputText";

//        <attr name="infoHint" format="string" />
//        <attr name="infoHintColor" format="reference|color" />
//        <attr name="infoTextColor" format="reference|color" />
//        <attr name="infoTextSize" format="dimension" />
//        <attr name="infoRowSpacing" format="dimension" />
//        <attr name="underLine" format="reference|color" />
    private String infoHint;
    private int infoHintColor;
    private int infoTextColor;
    private int underLine;
    private float infoTextSize;
    private float infoRowSpacing;

    private static String resultStr  =  "";

    private Rect mBound;
    private Paint textPaint,underLinePaint;


    public NovelInputText(Context context) {
        this(context, null);
    }

    public NovelInputText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NovelInputText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.NovelInputText, defStyleAttr, 0);

        infoHint = ta.getString(R.styleable.NovelInputText_infoHint);
        infoHintColor = ta.getColor(R.styleable.NovelInputText_infoHintColor, Color.BLACK);
        infoTextColor = ta.getColor(R.styleable.NovelInputText_infoTextColor, Color.BLACK);
        underLine =ta.getColor(R.styleable.NovelInputText_underLine,0);
        infoTextSize = ta.getDimension(R.styleable.NovelInputText_infoTextSize,0);
        infoRowSpacing =ta.getDimension(R.styleable.NovelInputText_infoRowSpacing,0);

        ta.recycle();

        textPaint = new Paint();
        textPaint.setTextSize(infoTextSize);
        textPaint.setColor(infoHintColor);
        textPaint.setLetterSpacing(50);
        textPaint.setTextAlign(Paint.Align.LEFT);



        underLinePaint = new Paint();
        underLinePaint.setColor(underLine);

        this.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                L.i(TAG,"s = "+s+"||start = "+start+"||count = "+count+"||after = "+after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                L.i(TAG,"s = "+s+"||start = "+start+"||count = "+count+"||before = "+before);

                resultStr = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                L.i(TAG,"s = "+s);
                resultStr = s.toString();
            }
        });

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int x = getPaddingLeft();
        //dy 代表的是：高度的一半到 baseLine的距离
        Paint.FontMetricsInt fontMetrics = textPaint.getFontMetricsInt();
        // top 是一个负值 bottom 是一个正值 top，bttom的值代表是 bottom是baseLine到文字底部的距离（正值）
        // 必须要清楚的，可以自己打印就好
        int dy = (fontMetrics.bottom - fontMetrics.top)/2 - fontMetrics.bottom;
        int baseLine = getHeight()/2 + dy;

        canvas.drawText(infoHint,x,baseLine,textPaint);
        canvas.drawLine(0,0,0,0,underLinePaint);

    }

    public String getInputText(){
        return resultStr;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
