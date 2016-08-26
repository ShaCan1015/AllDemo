package com.example.shacan.mydraw2.Widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/8/26 0026.
 */
public class OlympicView extends View {
    private Paint paint;
    public OlympicView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }
    public OlympicView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public OlympicView(Context context) {
        super(context);
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
         * 蓝圈
         */
        paint.reset();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8);
        canvas.drawCircle(120,120,80,paint);
        /**
         * 黄圈
         */
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(240,120,80,paint);
        /**
         * 黑圈
         */
        paint.setColor(Color.BLACK);
        canvas.drawCircle(360,120,80,paint);
        /**
         * 绿圈
         */
        paint.setColor(Color.GREEN);
        canvas.drawCircle(180,240,80,paint);
        /**
         * 绿圈
         */
        paint.setColor(Color.RED);
        canvas.drawCircle(300,240,80,paint);
        super.onDraw(canvas);
    }
}
