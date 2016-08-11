package com.udaye.tablet.superloadlibrary;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * 线性布局 RecyclerView
 * <p/>
 * Created by brokge on 16/8/10.
 */
public class LinearRecyclerView extends SuperRecyclerView {

    public LinearRecyclerView(Context context) {
        super(context);
    }

    public LinearRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LinearRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
