package com.example.daopeng1.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * description:
 *
 * @auther icuihai
 * @Email:icuihai@aliyun.com
 * @url: weibo.com/icuihai
 * @since 2016/11/7.
 */

public class MyView extends View{
    private int startX=720,startY=200;//起始点
    private int centerX=720,centerY=600;//圆心
    private int r=centerY-startY;//半径
    private String[]str= {"击杀","生存","助攻","物理","魔法","防御","金钱"};
    private int dimension;//文字大小
    private float xA,xB,xC,xD,xE,xF,xG;//x轴坐标
    private float yA,yB,yC,yD,yE,yF,yG;//y轴坐标
    private static final int TEXTSIZE=20;
    private float y1,y2,y3,y4,y5,y6,y7,x1,x2,x3,x4,x5,x6,x7;//能力值坐标
    private float pre1=0.2f,pre2=0.2f,pre3=0.2f,pre4=0.2f,pre5=0.2f,pre6=0.2f,pre7=0.2f;//百分率

    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }
    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.textSize);
        dimension = (int) typedArray.getDimension(R.styleable.textSize_textsize, TEXTSIZE);
        typedArray.recycle();
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    private void initView(){
        initData();
    }
    private void initData() {
        //首先A点坐标(其实用不到)
        xA=startX;
        yA=startY;
        //先求出B点的坐标
        xB= (float) (centerX+Math.sin(Math.toRadians(360/7))*r);
        yB= (float) (centerY-Math.cos(Math.toRadians(360/7))*r);
        //在求出C点坐标
        xC= (float) (startX+Math.sin(Math.toRadians(360/7*1.5))*r);
        yC= (float) (centerY+Math.cos(Math.toRadians(360/7*1.5))*r);
        //Log.i("TAG",""+xC+"---"+yC);
        //在求出D点坐标
        xD= (float) (startX+Math.sin(Math.toRadians(360/7/2))*r);
        yD= (float) (centerY+Math.cos(Math.toRadians(360/7/2))*r);
        //于D点水平对称的E点坐标
        xE=(float) (centerX-Math.sin(Math.toRadians(360/7/2))*r);
        yE= (float) (centerY+Math.cos(Math.toRadians(360/7/2))*r);
        //与C点水平对称点的坐标F
        xF= (float) (centerX-Math.sin(Math.toRadians(360/7*1.5))*r);
        yF= (float) (centerY+Math.cos(Math.toRadians(360/7*1.5))*r);
        //与B点水平对称点的坐标G
        xG= (float) (centerX-Math.sin(Math.toRadians(360/7))*r);
        yG= (float) (centerY-Math.cos(Math.toRadians(360/7))*r);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        Paint paint=new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(2);
        for (int i = 0; i < 7; i++) {
            canvas.drawLine(startX,startY,centerX,centerY,paint);
            canvas.rotate((float) 360/7,centerX,centerY);
        }
        canvas.restore();
        //画AB之间的直线
        canvas.drawLine(startX,startY,xB,yB,paint);
        //画BC之间的直线
        canvas.drawLine(xB,yB,xC,yC,paint);
        //画BD之间的直线
        canvas.drawLine(xC,yC,xD,yD,paint);
        //画DE之间的直线
        canvas.drawLine(xD,yD,xE,yE,paint);
        //画EF之间的直线
        canvas.drawLine(xE,yE,xF,yF,paint);
        //画FG之间的直线
        canvas.drawLine(xF,yF,xG,yG,paint);
        //画FA之间的直线
        canvas.drawLine(xG,yG,startX,startY,paint);
        //画内多变形
        canvas.drawLine(startX,centerY-r/2,(xB+startX)/2,yB+(centerY-yB)/2,paint);
        canvas.drawLine((xB+startX)/2,yB+(centerY-yB)/2,(startX+xC)/2,(centerY+yC)/2,paint);
        canvas.drawLine((startX+xC)/2,(centerY+yC)/2,(startX+xD)/2,(centerY+yD)/2,paint);
        canvas.drawLine((startX+xD)/2,(centerY+yD)/2,(startX+xE)/2,(centerY+yE)/2,paint);
        canvas.drawLine((startX+xE)/2,(centerY+yE)/2,(startX+xF)/2,(centerY+yF)/2,paint);
        canvas.drawLine((startX+xF)/2,(centerY+yF)/2,(startX+xG)/2,(centerY+yG)/2,paint);
        canvas.drawLine((startX+xG)/2,(centerY+yG)/2,startX,centerY-r/2,paint);
        canvas.drawLine((startX+xG)/2,(centerY+yG)/2,startX,centerY-r/2,paint);

        //画文字
        Paint paint1=new Paint();
        paint1.setTextSize(50);
        paint1.setColor(Color.RED);
        paint1.setAntiAlias(true);//设置坑锯齿
        paint1.setDither(true);//设置抗抖动
        paint1.setTextAlign(Paint.Align.CENTER);
        //
        int padd=40;
        canvas.drawText(str[0],startX,startY-padd,paint1);
        canvas.drawText(str[1],xB+padd,yB-padd,paint1);
        canvas.drawText(str[2],xC+padd,yC+padd,paint1);
        canvas.drawText(str[3],xD+padd,yD+padd,paint1);
        canvas.drawText(str[4],xE-padd,yE+padd,paint1);
        canvas.drawText(str[5],xF-padd,yF+padd,paint1);
        canvas.drawText(str[6],xG-padd,yG-padd,paint1);

        //绘制能力
        Path mPath = new Path();
        Paint mPaint =new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(8);

        //顺时针依次
        x1=startX;
        y1= (centerY-(pre1*r));

        x2= (float) (startX+Math.sin(Math.toRadians(360/7))*pre2*r);
        y2= (float) (centerY-Math.cos(Math.toRadians(360/7))*pre2*r);

        x3= (float) (startX+Math.sin(Math.toRadians(180-360/7*2))*pre3*r);
        y3= (float) (centerY+Math.cos(Math.toRadians(180-360/7*2))*pre3*r);

        x4= (float) (startX+Math.sin(Math.toRadians(180-360/7*3))*r*pre4);
        y4= (float) (centerY+Math.cos(Math.toRadians(180-360/7*3))*r*pre4);

        x5= (float) (centerX-Math.sin(Math.toRadians(180-360/7*3))*r*pre5);
        y5= (float) (centerY+Math.cos(Math.toRadians(180-360/7*3))*r*pre5);

        x6= (float) (centerX-Math.sin(Math.toRadians(180-360/7*2))*r*pre6);
        y6= (float) (centerY+Math.cos(Math.toRadians(180-360/7*2))*r*pre6);

        x7= (float) (centerX-Math.sin(Math.toRadians(360/7))*r*pre7);
        y7= (float) (centerY-Math.sin(Math.toRadians(90-360/7))*r*pre7);

        mPath.moveTo(x7,y7);//把起点设置为7点可以使图形封闭
        mPath.lineTo(x1,y1);
        mPath.lineTo(x2,y2);
        mPath.lineTo(x3,y3);
        mPath.lineTo(x4,y4);
        mPath.lineTo(x5,y5);
        mPath.lineTo(x6,y6);
        mPath.lineTo(x7,y7);

        // 绘制路径
        canvas.drawPath(mPath, mPaint);
        //mPath.close(); //封闭曲线
        invalidate();

    }
    public void setNum1(float num){
        pre1=num;
    }
    public void setNum2(float num){
        pre2=num;
    }
    public void setNum3(float num){
        pre3=num;
    }
    public void setNum4(float num){
        pre4=num;
    }
    public void setNum5(float num){
        pre5=num;
    }
    public void setNum6(float num){
        pre6=num;
    }
    public void setNum7(float num){
        pre7=num;
    }


}
