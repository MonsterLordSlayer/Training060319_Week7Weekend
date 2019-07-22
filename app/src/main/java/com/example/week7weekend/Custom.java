package com.example.week7weekend;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.RequiresApi;

public class Custom extends View {
    int radius;
    int fillColor;
    int posX;
    int posY;
    public Custom(Context context) {
        this(context, null);
    }

    public Custom(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Custom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Custom);
        radius = typedArray.getInt(R.styleable.Custom_radius, 30);
        fillColor = typedArray.getColor(R.styleable.Custom_fillColor, 0);
        posX = typedArray.getInt(R.styleable.Custom_positionX, 50);
        posY = typedArray.getInt(R.styleable.Custom_positionY, 50);

        typedArray.recycle();
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Custom(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint=new Paint();
        Log.d("TAG", "onDraw: "+radius+" "+posX);
        paint.setColor(fillColor);
        canvas.drawRect(posX, posY, posX+radius, posY+radius, paint );


    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getFillColor() {
        return fillColor;
    }

    public void setFillColor(int fillColor) {
        this.fillColor = fillColor;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }


}
