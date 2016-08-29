package com.example.shacan.customprogressbar.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.shacan.customprogressbar.R;

/**
 * Created by Administrator on 2016/8/29 0029.
 */
public class ProgressView extends View {
    public ProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //表示当前布局里面自定义view 中全部属性的个数
        int attributeCount = attrs.getAttributeCount();

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ProgressView);
        //获取自定义属性的默认值
        roundColor = array.getColor(R.styleable.ProgressView_roundColor,Color.BLUE);
        arcColor = array.getColor(R.styleable.ProgressView_arcColor,Color.RED);
        roundWidth = (int) array.getDimension(R.styleable.ProgressView_roundWidth,10);

        initPaint();
    }

    public ProgressView(Context context) {
        super(context);
        initPaint();
    }
    private Paint paint;
    //圆环默认的颜色
    private int roundColor = Color.BLUE;
    //圆环默认的宽度
    private int roundWidth = 10;
    //圆环是否填充
    private boolean isStyle = true;
    //弧默认的颜色
    private int arcColor = Color.RED;
    //弧默认的弧度
    private int myProgress = 30;
    //最大进度值
    private int maxProgress = 100;
    //是否有文字
    private boolean isText = true;
    //文字默认的颜色
    private int textColor = Color.GREEN;
    //文字的大小
    private int textSize = 50;

    /**
     * 初始化画笔
     */
    private void initPaint() {
        paint = new Paint();
    }

    public int getRoundColor() {
        return roundColor;
    }

    public void setRoundColor(int roundColor) {
        this.roundColor = roundColor;
    }

    public int getRoundWidth() {
        return roundWidth;
    }

    public void setRoundWidth(int roundWidth) {
        this.roundWidth = roundWidth;
    }

    public boolean isStyle() {
        return isStyle;
    }

    public void setStyle(boolean style) {
        isStyle = style;
    }

    public int getArcColor() {
        return arcColor;
    }

    public void setArcColor(int arcColor) {
        this.arcColor = arcColor;
    }

    public int getMyProgress() {
        return myProgress;
    }

    public int getMaxProgress() {
        return maxProgress;
    }

    public void setMaxProgress(int maxProgress) {
        this.maxProgress = maxProgress;
    }

    public boolean isText() {
        return isText;
    }

    public void setText(boolean text) {
        isText = text;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.reset();
        paint.setColor(roundColor);
        paint.setStyle(isStyle != true ? Paint.Style.FILL: Paint.Style.STROKE );
        paint.setAntiAlias(true);
        paint.setStrokeWidth(roundWidth);
        //画圆环
        float radius = (Math.min(getWidth(),getHeight())-roundWidth*2)/2;
        canvas.drawCircle(getWidth()/2,getHeight()/2,radius,paint);
        /**
         * 画进度弧
         */
        paint.setColor(arcColor);
        RectF oval = new RectF(getWidth()/2-radius,getHeight()/2-radius,getWidth()/2+radius,getHeight()/2+radius);
        canvas.drawArc(oval,0,360*myProgress/maxProgress,!isStyle,paint);
        /**
         * 设置文字
         */
        if (isText){
            paint.reset();
            paint.setColor(textColor);
            paint.setTextSize(textSize);
            paint.setAntiAlias(true);
            //文字的对齐方式
            paint.setTextAlign(Paint.Align.CENTER);
            String text = myProgress*100/maxProgress+"%";
            canvas.drawText(text,getWidth()/2,getHeight()/2+textSize/3,paint);
        }

    }
    /**
     * 设置进度条
     */
    public void setMyProgress(int myProgress){
        this.myProgress = myProgress;
        this.postInvalidate();//刷新界面
    }
}
