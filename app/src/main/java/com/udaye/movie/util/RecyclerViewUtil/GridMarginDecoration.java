package com.udaye.movie.util.RecyclerViewUtil;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * GridMargin
 * <p/>
 * Created  on 16/6/27.
 */
public class GridMarginDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public GridMarginDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.top = space;
        outRect.right = space;
        outRect.bottom = space;
    }
}