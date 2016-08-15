package com.udaye.movie.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import com.udaye.movie.R;
import com.udaye.movie.entity.CommonBean;
import com.udaye.movie.ui.main.MovieDetailActivity;
import com.udaye.library.pullloadlibrary.CommonViewHolder;

/**
 * Created  on 16-6-6.
 * <p/>
 * 即将上映电影
 */
public class CommingSoonAdapter extends com.udaye.library.pullloadlibrary.RecyclerViewCommonAdapter<CommonBean.SubjectsBean> {


    public CommingSoonAdapter(List<CommonBean.SubjectsBean> list, Context context) {
        super(context, list, R.layout.view_list_item_home);
    }

    public void update(List<CommonBean.SubjectsBean> list) {
        addList((ArrayList<CommonBean.SubjectsBean>) list);
    }

    @Override
    public void onListBindViewHolder(CommonViewHolder holder, int position) {
        final CommonBean.SubjectsBean entity = mList.get(position);
        Glide.with(mContext)
                .load(mList.get(position).getImages().getLarge())
                .placeholder(android.R.color.white)
                .into((ImageView) holder.getView(R.id.photo));
        holder.setText(R.id.tv_movie_name, entity.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(MovieDetailActivity.getCallingIntent(mContext, entity.getId()));
            }
        });
    }

   /* public void refreshData(ArrayList<T> data) {
        ArrayList<T> newData = new ArrayList<>();
        newData.addAll(data);

        mData.clear();
        mData.addAll(newData);
        notifyDataSetChanged();
    }*/

}
