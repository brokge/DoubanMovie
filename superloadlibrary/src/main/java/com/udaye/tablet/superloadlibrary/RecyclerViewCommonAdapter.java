package com.udaye.tablet.superloadlibrary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 */
public abstract class RecyclerViewCommonAdapter<T> extends RecyclerView.Adapter {

    public static final int HEADER_TYPE = Integer.MIN_VALUE;
    public static final int FOOTER_TYPE = Integer.MIN_VALUE + 1;

    protected List<T> mList;
    protected Context mContext;
    protected int layoutResId;

    private View headView;
    private View footView;

    private FooterLoadView mFooterLoadView;

    /**
     * @param mContext    上下文对象
     * @param list        数据List
     * @param layoutResId listItem 布局文件
     */
    public RecyclerViewCommonAdapter(Context mContext, List<T> list, int layoutResId) {
        this.mContext = mContext;
        this.mList = list;
        this.layoutResId = layoutResId;
    }

    /**
     * 添加一个List集合到数据集
     *
     * @param mList
     */
    public void addList(ArrayList<T> mList) {
        hideFootProgress();
        this.mList.addAll(mList);
        notifyDataSetChanged();
    }

    /**
     * 清空所有数据
     */
    public void clear() {
        this.mList.clear();
        removeFootView();
        removeHeadView();
        notifyDataSetChanged();
    }

    /**
     * 添加一个headview
     *
     * @param headView
     */
    public void addHeadView(View headView) {
        this.headView = headView;
        notifyDataSetChanged();
    }

    /**
     * 添加一个尾部view
     * <p/>
     * 可以是自定义 也可以是默认的 loadmore view
     *
     * @param footView
     */
    public void addFootView(View footView) {
        this.footView = footView;
        notifyDataSetChanged();
    }

    /**
     * 移出头部view
     */
    public void removeHeadView() {
        this.headView = null;
        notifyDataSetChanged();
    }

    /**
     * 移出尾部view
     */
    public void removeFootView() {
        this.footView = null;
        notifyDataSetChanged();
    }

    /**
     * 加载更多
     */
    public void showFootProgress() {
        if (this.mFooterLoadView == null) {
            this.mFooterLoadView = new FooterLoadView(mContext);
        }
        this.mFooterLoadView.setState(FooterLoadView.State.Loading, true);
        addFootView(this.mFooterLoadView);
    }


    /**
     * 已经加载全部
     */
    public void showFootLoadEnd() {
        if (this.mFooterLoadView == null) {
            this.mFooterLoadView = new FooterLoadView(mContext);
        }
        this.mFooterLoadView.setState(FooterLoadView.State.TheEnd, true);
        addFootView(this.mFooterLoadView);
        autoHideFootView();
    }

    private void autoHideFootView() {
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                hideFootProgress();
            }
        }, 1000);
    }

    /**
     * 不显示footview
     */
    public void hideFootProgress() {
        this.footView = null;
        notifyDataSetChanged();
    }

    /**
     * 显示loadmore 出错
     *
     * @param onClickListener
     */
    public void showLoadError(View.OnClickListener onClickListener) {
        if (this.mFooterLoadView == null) {
            this.mFooterLoadView = new FooterLoadView(mContext);
        }
        this.mFooterLoadView.setState(FooterLoadView.State.NetWorkError, true);
        this.mFooterLoadView.setOnClickListener(onClickListener);
        addFootView(this.mFooterLoadView);
    }

    /**
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADER_TYPE) {
            return new HeaderViewHolder(headView);
        } else if (viewType == FOOTER_TYPE) {
            return new FooterViewHolder(footView);
        } else {
            View view = LayoutInflater.from(mContext).inflate(layoutResId, parent, false);
            return new CommonViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == HEADER_TYPE) {
        } else if (getItemViewType(position) == FOOTER_TYPE) {
        } else {
            onListBindViewHolder((CommonViewHolder) holder, position - getHeaderCount());
        }
    }

    /**
     * 返回总的条数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return getListCount() + getFooterCount() + getHeaderCount();
    }

    /**
     * 返回数据
     *
     * @param position
     * @return
     */
    protected T getItem(int position) {
        return this.mList.get(position);
    }

    /**
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if (position < getHeaderCount()) {
            // 头部view
            return HEADER_TYPE;
        } else if (position >= getItemCount() - getFooterCount()) {
            // 底部view
            return FOOTER_TYPE;
        } else {
            return super.getItemViewType(position);
        }
    }

    private int getHeaderCount() {
        return headView == null ? 0 : 1;
    }

    private int getFooterCount() {
        return footView == null ? 0 : 1;
    }

    public int getListCount() {
        return this.mList.size();
    }

    /**
     * 返回最后一条view 位置 不包括footview
     *
     * @return
     */
    public int getBottomPos() {
        return getListCount() + getHeaderCount() - 1;
    }

    /**
     * 列表数据操作
     *
     * @param holder
     * @param position
     */
    public abstract void onListBindViewHolder(CommonViewHolder holder, int position);

    public class HeaderViewHolder extends RecyclerView.ViewHolder {

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}