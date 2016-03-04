package com.tianyejia.recyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

/**
 * Created by Jack on 16/3/4.
 */
public class RecyclerView extends android.support.v7.widget.RecyclerView{
    public RecyclerView(Context context) {
        super(context);
        initView(context);
    }

    public RecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public RecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    private void initView(Context context) {
        //init LinearLayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        //set the VERTICAL layout
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //set layout manager
        this.setLayoutManager(linearLayoutManager);
        //set item animator
        this.setItemAnimator(new DefaultItemAnimator());
        //keep recyclerview fixed size
        this.setHasFixedSize(true);
    }
}
