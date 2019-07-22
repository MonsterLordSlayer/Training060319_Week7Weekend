package com.example.week7weekend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Custom custom;
    CompoundView compoundView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        custom=findViewById(R.id.custom);
        compoundView=findViewById(R.id.cmpCompoundView);
        compoundView.setCounterOne(0);
        compoundView.setCounterTwo(0);
        OkHttpExample okHttpExample=new OkHttpExample();
        okHttpExample.getSyncResponse(this);

    }
}
