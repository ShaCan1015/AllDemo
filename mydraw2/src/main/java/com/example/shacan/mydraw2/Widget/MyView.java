package com.example.shacan.mydraw2.Widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/8/26 0026.
 */
public class MyView extends View {
    private Paint paint;
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }
    public MyView(Context context) {
        super(context);
        initPaint();
    }
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
        paint.reset();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);

        /**
         * 画多条线
         */
//        float[] pts = {10,10,30,30,40,40,80,80};//pts表示：两个参数确定一个点 四个参数确定一条直线
//        canvas.drawLines(pts,paint);
        /**
         * 画点
         */
//        float []pts={10,10,100,100,200,200,400,400};
//        canvas.drawPoints(pts, 2, 4, paint);
//        canvas.drawPoints(pts, paint);
        /**
         *画矩形
         */
        RectF rect = new RectF(20,20,100,150);
//        canvas.drawRect(rect,paint);
        /**
         * 画圆角矩形
         */
//        canvas.drawRoundRect(rect,10,20,paint);
        /**
         * 画椭圆
         */
        canvas.drawOval(rect,paint);
        super.onDraw(canvas);
    }
}
