package com.example.kson.ksonsurfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/10/24
 * Description:
 */
public class MyView extends ViewGroup {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int totalWidth = 0;//最终宽度
        int totalHeight = 0;//最终确定的子view大小


//        int size = getChildCount();
//        if (size>0){
//            for (int i = 0; i < size; i++) {
//                View view = getChildAt(i);
//                totalHeight+=view.getMeasuredHeight();
////                view.getHeight();
//                measureChild(view,widthMeasureSpec,heightMeasureSpec);
//            }
//        }

        switch (widthMode){
            case MeasureSpec.EXACTLY:
                totalWidth = widthSize;
                break;
            case MeasureSpec.AT_MOST:
                totalWidth = 1000;//处理主要逻辑
                break;
//            case MeasureSpec.UNSPECIFIED://不确定大小
//                totalWidth = widthSize;
//                break;

        }
        switch (heightMode){
            case MeasureSpec.EXACTLY:
                totalHeight = heightSize;
                break;
            case MeasureSpec.AT_MOST:
                totalHeight = 1000;//处理主要逻辑
                break;
//            case MeasureSpec.UNSPECIFIED://不确定大小
//                totalWidth = widthSize;
//                break;

        }


        setMeasuredDimension(totalWidth,totalHeight);


//        requestLayout();//请求布局：重新测量一遍或几遍，layout重新布局
//        invalidate();//走draw方法：主线程
//        postInvalidate();//draw方法，子线程

        //





    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left = 0;
        int top = 0;
        int right = 0;
        int bottom = 0;
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).layout(left,top,right,bottom);
        }
    }

    @Override
    protected void onVisibilityChanged(@NonNull View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
    }


}
