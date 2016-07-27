package com.udaye.movie.adapter;

import android.content.Context;
import android.view.View;

import java.util.List;

import com.udaye.movie.R;
import com.udaye.movie.entity.UsBoxBean;
import com.udaye.movie.ui.main.MovieDetailActivity;

/**
 * 北美排行榜
 * <p/>
 * Created  on 16/7/12.
 */
public class UsBoxAdapter extends RecyclerViewCommonAdapter<UsBoxBean.SubjectsBean> {
    /**
     * @param mContext 上下文对象
     * @param list     数据List
     */
    public UsBoxAdapter(Context mContext, List<UsBoxBean.SubjectsBean> list) {
        super(mContext, list, R.layout.view_rank_item);
    }

    @Override
    public void onListBindViewHolder(CommonViewHolder holder, int position) {
        final UsBoxBean.SubjectsBean subjectsBean = getItem(position);
        holder.setText(R.id.tv_rank, String.valueOf(subjectsBean.getRank()));
        holder.setText(R.id.tv_movie_name, String.valueOf(subjectsBean.getSubject().getTitle()));
        holder.setText(R.id.tv_movie_score, String.format(mContext.getString(R.string.tip_score), String.valueOf(subjectsBean.getSubject().getRating().getAverage())));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(MovieDetailActivity.getCallingIntent(mContext, subjectsBean.getSubject().getId()));
            }
        });

    }
}