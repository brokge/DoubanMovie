package com.udaye.library.pullloadlibrary;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;

/**
 * 基类
 * <p/>
 * Created by brokge on 16/8/11.
 */
public class SuperRecyclerView extends RecyclerView {

    private OnLoadMoreListener onLoadMoreListener;

    public SuperRecyclerView(Context context) {
        super(context);
    }

    public SuperRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SuperRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
        this.addOnScrollListener(null);
    }

    @Override
    public void addOnScrollListener(OnScrollListener listener) {
        if (listener == null) {
            listener = new OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    //当前RecyclerView显示出来的最后一个的item的position
                    int lastPosition = -1;
                    //当前状态为停止滑动状态SCROLL_STATE_IDLE时
                    if (newState == RecyclerView.SCROLL_STATE_IDLE && onLoadMoreListener != null) {
                        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                        if (layoutManager instanceof GridLayoutManager) {
                            //通过LayoutManager找到当前显示的最后的item的position
                            lastPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                        } else if (layoutManager instanceof LinearLayoutManager) {
                            lastPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                            //因为StaggeredGridLayoutManager的特殊性可能导致最后显示的item存在多个，所以这里取到的是一个数组
                            //得到这个数组后再取到数组中position值最大的那个就是最后显示的position值了
                            int[] lastPositions = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
                            ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(lastPositions);
                            lastPosition = findMax(lastPositions);
                        }
                        //时判断界面显示的最后item的position是否等于itemCount总数-1也就是最后一个item的position
                        //如果相等则说明已经滑动到最后了
                        if (lastPosition == ((RecyclerViewCommonAdapter) recyclerView.getAdapter()).getBottomPos()) {
                            onLoadMoreListener.onLoadMore((SuperRecyclerView) recyclerView);
                        }
                    }
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                   /* if (onLoadMoreListener != null) {
                        //得到当前显示的最后一个item的view
                        View lastChildView = recyclerView.getLayoutManager().getChildAt(recyclerView.getLayoutManager().getChildCount() - 1);
                        if (lastChildView != null) {
                            //得到lastChildView的bottom坐标值
                            int lastChildBottom = lastChildView.getBottom();
                            //得到Recyclerview的底部坐标减去底部padding值，也就是显示内容最底部的坐标
                            int recyclerBottom = recyclerView.getBottom() - recyclerView.getPaddingBottom();
                            //通过这个lastChildView得到这个view当前的position值
                            int lastPosition = recyclerView.getLayoutManager().getPosition(lastChildView);

                            //判断lastChildView的bottom值跟recyclerBottom
                            //判断lastPosition是不是最后一个position
                            //如果两个条件都满足则说明是真正的滑动到了底部
                            if (lastChildBottom == recyclerBottom && lastPosition == ((RecyclerViewCommonAdapter) recyclerView.getAdapter()).getBottomPos()) {
                                onLoadMoreListener.onLoadMore((SuperRecyclerView) recyclerView);
                                //Toast.makeText(RecyclerActivity.this, "滑动到底了", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }*/
                }
            };
        }
        super.addOnScrollListener(listener);
    }

    //找到数组中的最大值
    private int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }


    /**
     * 显示 加载更多view
     */
    public void showFootProgress() {
        try {
            RecyclerViewCommonAdapter recyclerViewCommonAdapter = (RecyclerViewCommonAdapter) getAdapter();
            if (recyclerViewCommonAdapter != null) {
                recyclerViewCommonAdapter.showFootProgress();
            }
        } catch (ClassCastException e) {

        }

    }

    /**
     * 显示加载完成view
     */
    public void showFootProgressEnd() {
        RecyclerViewCommonAdapter recyclerViewCommonAdapter = (RecyclerViewCommonAdapter) getAdapter();
        if (recyclerViewCommonAdapter != null) {
            recyclerViewCommonAdapter.showFootLoadEnd();
        }
    }

    /**
     * 隐藏加载更多view
     */
    public void hideFootProgress() {
        RecyclerViewCommonAdapter recyclerViewCommonAdapter = (RecyclerViewCommonAdapter) getAdapter();
        if (recyclerViewCommonAdapter != null) {
            recyclerViewCommonAdapter.hideFootProgress();
        }
    }


}
