package com.udaye.movie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 16-4-13.
 * <p/>
 * RecyclerView 数据适配器 - 基类
 */
public abstract class BaseRclViewAdapter<T> extends RecyclerView.Adapter {

    protected Context mContext;
    protected List<T> mData;
    private LayoutInflater mInflater;
    private int mLayoutResId;

    public BaseRclViewAdapter(Context context, List<T> data, int layoutResId) {
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mLayoutResId = layoutResId;
        if (data != null) {
            this.mData = data;
        } else {
            mData = new ArrayList<>();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(mLayoutResId, parent, false);
        return new CommonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onItemBindViewHolder(((CommonViewHolder) holder), position);
    }

    public abstract void onItemBindViewHolder(CommonViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public T getItem(int position) {
        return mData.get(position);
    }

    public void refreshData(ArrayList<T> data) {
        ArrayList<T> newData = new ArrayList<>();
        newData.addAll(data);

        mData.clear();
        mData.addAll(newData);
        notifyDataSetChanged();
    }
}
