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
public class AndroidRobotView extends View {
    private Paint paint;
    public AndroidRobotView(Context context) {
        super(context);
        initView();
    }

    public AndroidRobotView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public AndroidRobotView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.reset();
        paint.setColor(0xFFA4C739);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(3);
        //头部小辫子
        float[] pts = {150,50,200,80,320,50,270,80};
        canvas.drawLines(pts,paint);
        //头部
        RectF oval = new RectF(140,60,330,220);
        canvas.drawArc(oval,0,-180,true,paint);
        //眼睛
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);
        canvas.drawCircle(200,110,8,paint);
        canvas.drawCircle(270,110,8,paint);
        //身体
        paint.reset();
        paint.setColor(0xFFA4C739);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(3);
        canvas.drawRect(140,150,330,300,paint);
        RectF rect_body = new RectF(140,280,330,310);
        canvas.drawRoundRect(rect_body,20,20,paint);
        //腿
        RectF rect_leg_left = new RectF(170,280,210,390);
        RectF rect_leg_right = new RectF(260,280,300,390);
        canvas.drawRoundRect(rect_leg_left,20,20,paint);
        canvas.drawRoundRect(rect_leg_right,20,20,paint);
        //胳膊
        RectF rect_arm_left = new RectF(80,150,120,280);
        RectF rect_arm_right = new RectF(350,150,390,280);
        canvas.drawRoundRect(rect_arm_left,20,20,paint);
        canvas.drawRoundRect(rect_arm_right,20,20,paint);

        super.onDraw(canvas);
    }
}
