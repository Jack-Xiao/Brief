package com.tianyejia.recyclerview;

import android.util.SparseArray;
import android.view.View;

/**
 * Created by Jack on 16/3/4.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private final SparseArray<View> views;
    private View convertView;
    /**
     * @param itemView
     */
    public RecyclerViewHolder(View itemView) {
        super(itemView);
        this.views = new SparseArray<>();
        this.convertView = convertView;
    }

    public <T extends View> T findViewById(int viewId){
        View view = views.get(viewId);
        if(view == null){
            view = convertView.findViewById(viewId);
            views.put(viewId,view);
        }
        return (T)view;
    }
}
