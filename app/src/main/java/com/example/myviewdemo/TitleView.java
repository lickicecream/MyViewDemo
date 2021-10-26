package com.example.myviewdemo;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TitleView extends FrameLayout {
    private Button mLeftButton;
    private TextView mTitleText;
    public TitleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(getContext()).inflate(R.layout.title,this);
        mTitleText=(TextView) this.findViewById(R.id.title_text);
        mLeftButton=(Button) findViewById(R.id.button_left);
        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
    }

    public void setmLeftButton(String text) {
        mLeftButton.setText(text);
    }

    public void setmTitleText(String text) {
        mTitleText.setText(text);
    }
}
