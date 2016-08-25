package com.example.shacan.mydraw.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/8/25 0025.
 */
public class MyView extends View {

    //1、创建画笔
    private Paint paint;

    /**
     * 一个参数的：在自己new对象建立此View时调用，形如new **View(this)这种。
     *
     * @param context
     * @param attrs
     */
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    /**
     * 二个参数的：在xml中声明自定义View时调用，就是在main.xml里声明了<xx.xx.DrawView>这种
     *
     * @param context
     */
    public MyView(Context context) {
        super(context);
        initPaint();
    }

    /**
     * 三个参数的：也是在XML中声明自定义View时调用，但与两个参数的区别是这个加入了Style样式的引用，也就是说，
     * 如果你的 main.xml里<xx.xx.DrawView>中加入了style="@style/xxx.xml"，就会调用这个三参的方法。
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        /**
         * 设置画笔的样式(画直线)
         */
        //重置画笔
        paint.reset();
        //设置画笔的颜色
        paint.setColor(Color.RED);
        //设置画笔的粗细
        paint.setStrokeWidth(20);
        //设置抗锯齿
        paint.setAntiAlias(true);
        //绘制直线
        canvas.drawLine(10, 10, 300, 300, paint);
        /**
         * 设置画笔的样式(画圆)
         */
        //重置画笔
        paint.reset();
        //设置画笔的颜色
        paint.setColor(Color.GRAY);
        //设置画笔的粗细
        paint.setStrokeWidth(20);
        //设置抗锯齿
        paint.setAntiAlias(true);
        //设置画笔是否填充
        paint.setStyle(Paint.Style.STROKE);
        //画圆
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 150, paint);

        /**
         * 设置画笔的样式(画弧度)
         */
        //重置画笔
        paint.reset();
        //设置画笔的颜色
        paint.setColor(Color.GREEN);
        //设置画笔的粗细
        paint.setStrokeWidth(20);
        //设置抗锯齿
        paint.setAntiAlias(true);
        //设置画笔是否填充
        paint.setStyle(Paint.Style.STROKE);
        //画弧形
        RectF oval = new RectF(getWidth()/2-150,getHeight()/2-150,getWidth()/2+150,getHeight()/2+150);
        canvas.drawArc(oval,0,90,true,paint);

        /**
         * 设置画笔的样式(画弧度)
         */
        //重置画笔
        paint.reset();
        //设置画笔的颜色
        paint.setColor(Color.BLUE);
        //设置画笔的粗细
        paint.setStrokeWidth(10);
        //设置抗锯齿
        paint.setAntiAlias(true);
        //设置画笔是否填充
        paint.setStyle(Paint.Style.STROKE);
        //画正方形
        RectF oval1 = new RectF(getWidth()/2,getHeight()/2,getWidth()/2+150,getHeight()/2+150);
        canvas.drawRect(oval1,paint);

        super.onDraw(canvas);

    }
}
