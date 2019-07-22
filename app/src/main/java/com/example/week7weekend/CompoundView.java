package com.example.week7weekend;

import android.app.Activity;
import android.content.Context;

import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CompoundView extends LinearLayout implements View.OnClickListener {
    TextView tvCounterOne;
    TextView tvCounterTwo;
    ImageView ivWorldBreaker;
    int alpha=0;
    int counterOneValue = 0;
    int counterTwoValue = 0;
    public CompoundView(Context context) {
        this(context, null);
    }

    public CompoundView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CompoundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    private void init() {
        inflate(getContext(), R.layout.compound_layout, this);
        ivWorldBreaker=findViewById(R.id.ivWorldBreaker);
        alpha=ivWorldBreaker.getImageAlpha();
        tvCounterOne = findViewById(R.id.tvCounterOne);
        tvCounterTwo = findViewById(R.id.tvCounterTwo);
        tvCounterOne.setOnClickListener(this);
        tvCounterTwo.setOnClickListener(this);
        ivWorldBreaker.setOnClickListener(this);
    }

    public void setCounterOne(int counter) {
        tvCounterOne.setText(String.valueOf(counter));
        counterOneValue = counter;
    }

    public void setCounterTwo(int counter) {
        tvCounterTwo.setText(String.valueOf(counter));
        counterTwoValue = counter;
    }

    public void addOneCounterOne() {
        tvCounterOne.setText(String.valueOf(counterOneValue++));
        alpha+=10;
        if (alpha>255){alpha=255;}
        ivWorldBreaker.setImageAlpha(alpha);

    }

    public void addOneCounterTwo() {

        tvCounterTwo.setText(String.valueOf(counterTwoValue++));
        alpha-=10;
        if (alpha<0){alpha=0;}
        ivWorldBreaker.setImageAlpha(alpha);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvCounterOne:
                addOneCounterOne();
                break;
            case R.id.tvCounterTwo:
                addOneCounterTwo();
                break;
            case R.id.ivWorldBreaker:
                getContext().startActivity(new Intent(getContext(), MapsActivity.class));
                Log.d("TAG", "onClick: ");
                ((MainActivity)getContext()).overridePendingTransition(R.anim.slide_right, R.anim.slide_left);
                break;
        }
    }
}
