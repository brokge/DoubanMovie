package com.udaye.library.pullloadlibrary;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * 网格布局recyclerview
 * <p/>
 * Created by brokge on 16/8/10.
 */
public class GridRecyclerView extends SuperRecyclerView {

    public GridRecyclerView(Context context) {
        super(context);
    }

    public GridRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public GridRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setLayoutManager(LayoutManager layout) {
        super.setLayoutManager(layout);
        this.initLayoutManager();
    }

    private void initLayoutManager() {
        RecyclerView.LayoutManager manager = getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            final GridLayoutManager.SpanSizeLookup spanSizeLookup = gridManager.getSpanSizeLookup();
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                   /* return (getAdapter().getItemViewType(position) == RecyclerView.INVALID_TYPE || getAdapter().getItemViewType(position) == RecyclerView.INVALID_TYPE - 1)
                            ? gridManager.getSpanCount(): 1;*/
                    int count;
                    if ((getAdapter().getItemViewType(position) == RecyclerViewCommonAdapter.FOOTER_TYPE)) {
                        count = gridManager.getSpanCount();
                    } else {
                        count = spanSizeLookup == null ? 1 : spanSizeLookup.getSpanSize(position);
                    }
                    return count;
                }
            });
        }
    }
}
