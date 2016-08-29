package com.example.shacan.customprogressbar.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/8/29 0029.
 */
public class MyRing extends View {
    private Paint paint;
    /**
     * 圆心的x,y坐标
     */
    private int cx;
    private int cy;
    /**
     * 圆环的半径
     */
    private float radius;
    /**
     * 线条的宽度
     */
    private float strokWidth;
    /**
     *初始透明的
     */
    private int nextAlpha = 255;

    public MyRing(Context context) {
        super(context);
    }

    public MyRing(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        initPaint();
    }

    private void initPaint() {
        //初始化画笔
        this.radius = 0;
        this.strokWidth = 0;
        this.nextAlpha = 255;
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokWidth);
        paint.setAlpha(nextAlpha);//0--255,0表示全透明

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /***
         * 绘制圆环
         */
        canvas.drawCircle(cx,cy,radius,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){//点击获取圆环的中心
            cx = (int) event.getX();//getX()表示Widget相对于自身左上角X的坐标
            cy = (int) event.getY();
            //初始化画笔
            initPaint();
            handler.sendEmptyMessage(0);
        }
        return true;
    }
    /**
     * 刷新状态
     */
    private void flushState(){
        this.radius += 10;
        this.strokWidth = radius/4;
        this.nextAlpha -=20;
        paint.setStrokeWidth(strokWidth);
        if (nextAlpha <= 0 ){
            nextAlpha = 0;
        }
        paint.setAlpha(nextAlpha);
        //刷新界面 执行onDraw()方法
        invalidate();
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            flushState();
            if (paint.getAlpha() != 0){
                handler.sendEmptyMessageDelayed(0,100);
            }
        }
    };

    /**
     * 大小测量按系统默认规则
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
