package com.example.shacan.mynoteedittext.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.EditText;

import com.example.shacan.mynoteedittext.R;

/**
 * Created by Administrator on 2016/8/29 0029.
 */
public class noteEditTextView extends EditText {
    private int padding = 10;
    private final static int SPACING_LINE = 10;
    private int lineColor = Color.BLACK;
    private int lineStrokeWidth = 1;

    private Paint paint;

    public noteEditTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        init();
        //从xml布局文件中获取用户自定义的控件属性值
        TypedArray array =  context.obtainStyledAttributes(attrs, R.styleable.noteEditTextView);
        padding = (int) array.getDimension(R.styleable.noteEditTextView_padding,padding);
        lineColor = array.getColor(R.styleable.noteEditTextView_lineColor,lineColor);
        lineStrokeWidth = array.getInteger(R.styleable.noteEditTextView_lineStrokeWidth,lineStrokeWidth);
        //设置文字的内容填充
        setPadding(padding,0,padding,0);
    }

    private void init() {
        //设置文字从左上角开始
        setGravity(Gravity.TOP);
        //设置文本见得行距
        setLineSpacing(SPACING_LINE,1);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //抗锯齿
        paint.setAntiAlias(true);
        paint.setColor(lineColor);
        paint.setStrokeWidth(lineStrokeWidth);

        //获取控件的宽度和高度
        int viewHeight = getHeight();
        int viewWidth = getWidth();

        //获取线的高度（Y值）
        int lineHeight = this.getLineHeight();
        //获取当前整个屏幕上的横线的个数
        int pagelineCounts = viewHeight/lineHeight;
        for (int i = 0;i<pagelineCounts;i++){
            canvas.drawLine(padding,(i+1)*lineHeight,viewWidth - padding,(i+1)*lineHeight,paint);
        }

        // 当文字增加，超出一个屏幕，则会在每行文字的下方绘制分割线
        // 获取当前EditText中的文字的总行数
        int textLineCounts = getLineCount();
        // 额外需要绘制的横线的数量= 让总行数-一屏幕的行数
        int extraLineCount = textLineCounts - pagelineCounts;
        if (extraLineCount > 0){
            for (int i = pagelineCounts;i<textLineCounts;i++){
                //获取每行行高的方法2：取得每一行的基准Y坐标，并将每一行的界限值填写到mRect中去
                //init baseline = getLineBounds(i,mRect);
                //canvas.drawLine(padding, baseline + SPACING_LINE,viewWidthpadding, baseline + SPACING_LINE, paint);
                canvas.drawLine(padding, (i + 1) * lineHeight, viewWidth
                        - padding, (i + 1) * lineHeight, paint);
            }
        }
        // invalidate();
    }
}
