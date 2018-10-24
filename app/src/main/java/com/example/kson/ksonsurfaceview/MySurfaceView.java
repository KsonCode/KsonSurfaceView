package com.example.kson.ksonsurfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/10/24
 * Description:
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback,Runnable{
    private SurfaceHolder mHolder;
    private Canvas mCanvas;
    private Paint mPaint;
    private Path mPath;
    private boolean isDrawing;//判断是否绘制的标识位

    public MySurfaceView(Context context) {
        this(context,null);
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mHolder = getHolder();
        mHolder.addCallback(this);//添加回调
        mPaint = new Paint();
        mPaint.setColor(Color.RED);//设置画笔颜色
        mPaint.setAntiAlias(true);//消除锯齿
        mPaint.setStyle(Paint.Style.STROKE);//设置画笔风格，不填充
        mPaint.setStrokeWidth(20);//设置画笔粗细

        mPath = new Path();//path对象
    }

    /**
     * 创建周期
     * @param holder
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        isDrawing = true;

        new Thread(this).start();



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();//用event获取
        int y = (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(x,y);//路径的起始点


                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("===",x+"");
                mPath.lineTo(x,y);//连线
                break;
            case MotionEvent.ACTION_UP:


                break;
        }
        return true;
    }

    /**
     * 改变
     * @param holder
     * @param format
     * @param width
     * @param height
     */
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    /**
     * 销毁
     * @param holder
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        isDrawing = false;
        holder.removeCallback(this);

    }

    /**
     * 子线程执行的方法
     */
    @Override
    public void run() {
        while (isDrawing){
            draws();
        }

    }

    /**
     * 绘制
     */
    private void draws() {
        mCanvas = mHolder.lockCanvas();//锁定画布
        mCanvas.drawColor(Color.WHITE);
        mCanvas.drawPath(mPath,mPaint);

        if (mCanvas!=null){
            mHolder.unlockCanvasAndPost(mCanvas);
        }
    }
}
