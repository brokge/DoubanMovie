package com.udaye.tablet.superloadlibrary;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 *
 */
public class CommonViewHolder extends RecyclerView.ViewHolder {

    private final SparseArray<View> mViews;

    public CommonViewHolder(View itemView) {
        super(itemView);
        this.mViews = new SparseArray<View>();
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {

        View view = mViews.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public CommonViewHolder setText(int id, String text) {
        ((TextView) getView(id)).setText(text);
        return this;
    }

    public CommonViewHolder setVisibility(int id, int visibility) {
        getView(id).setVisibility(visibility);
        return this;
    }

    public CommonViewHolder setImageRes(int id, int res) {
        ((ImageView) getView(id)).setImageResource(res);
        return this;
    }




}