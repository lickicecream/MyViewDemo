package com.example.myviewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class MyListView extends ListView implements View.OnTouchListener, GestureDetector.OnGestureListener {

    private GestureDetector mGestureDetector;
    private View mDeleteButton;
    private ViewGroup mItemLayout;
    private int mSelectedItem;
    private OnDeleteListener mOnDeleteListener;
    private boolean mIsDeleteShown;

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mGestureDetector = new GestureDetector(getContext(), this);
        setOnTouchListener(this);
    }

    public void setOnDeleteListener(OnDeleteListener l){
        mOnDeleteListener=l;
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (mIsDeleteShown) {
            mItemLayout.removeView(mDeleteButton);
            mDeleteButton = null;
            mIsDeleteShown = false;
            return false;
        } else {
            return mGestureDetector.onTouchEvent(event);
        }
    }

    @Override
    public boolean onDown(MotionEvent e) {
        if (!mIsDeleteShown) {
            mSelectedItem = pointToPosition((int) e.getX(), (int) e.getY());
        }
        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (!mIsDeleteShown && Math.abs(velocityX) > Math.abs(velocityY)) {
            mDeleteButton = LayoutInflater.from(getContext()).inflate(R.layout.delete_button, null);
            mDeleteButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemLayout.removeView(mDeleteButton);
                    mDeleteButton = null;
                    mIsDeleteShown = false;
                    mOnDeleteListener.onDelete(mSelectedItem);
                }
            });
            mItemLayout = (ViewGroup) getChildAt(mSelectedItem - getFirstVisiblePosition());
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            params.addRule(RelativeLayout.CENTER_VERTICAL);
            mItemLayout.addView(mDeleteButton, params);
            mIsDeleteShown = true;
        }
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    public interface OnDeleteListener {
        void onDelete(int mSelectedItem);
    }
}
