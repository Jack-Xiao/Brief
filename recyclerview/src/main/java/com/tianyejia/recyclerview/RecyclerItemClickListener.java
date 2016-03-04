package com.tianyejia.recyclerview;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Jack on 16/3/4.
 */
public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
    private OnItemClickListener mListener;
    GestureDetector mGestureDector;

    public interface OnItemClickListener{
        public void OnItemClick(View view,int position);
    }

    public RecyclerItemClickListener(Context context,OnItemClickListener listener){
        mListener = listener;
        mGestureDector = new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }


    @Override
    public boolean onInterceptTouchEvent(android.support.v7.widget.RecyclerView rv, MotionEvent e) {
        View childView = rv.findChildViewUnder(e.getX(),e.getY());
        //这里可以扩展
        if(childView instanceof ImageView || childView instanceof Button){
            return false;
        }
        if(childView !=null && mListener !=null && mGestureDector.onTouchEvent(e)){
            mListener.OnItemClick(childView,rv.getChildAdapterPosition(childView));
            return true;
        }
        return false;
    }

    @Override
    public void onTouchEvent(android.support.v7.widget.RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
