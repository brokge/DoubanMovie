package com.udaye.movie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import com.udaye.movie.R;
import com.udaye.movie.entity.CelebrityBean;
import com.udaye.movie.ui.main.MovieDetailActivity;

/**
 * 参演作品详情
 * Created  on 16/7/4.
 */
public class CelebrityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    List<CelebrityBean.WorksBean> mList;

    public CelebrityAdapter(List<CelebrityBean.WorksBean> list, Context context) {
        mList = list;
        mContext = context;
    }

    public void update(List<CelebrityBean.WorksBean> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_item_work, parent, false);
        PhotoViewHolder holder = new PhotoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PhotoViewHolder photoViewHolder = (PhotoViewHolder) holder;
        final CelebrityBean.WorksBean entity = mList.get(position);
        Glide.with(mContext)
                .load(mList.get(position).getSubject().getImages().getLarge())
                .placeholder(android.R.color.white)
                .into(photoViewHolder.photo);
        photoViewHolder.name.setText(entity.getSubject().getTitle());
        photoViewHolder.roleView.setText(String.format(mContext.getString(R.string.tip_roller), entity.getRoles().get(0)));
        photoViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(MovieDetailActivity.getCallingIntent(mContext, entity.getSubject().getId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    final class PhotoViewHolder extends RecyclerView.ViewHolder {

        ImageView photo;
        TextView name, roleView;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            photo = (ImageView) itemView.findViewById(R.id.photo);
            name = (TextView) itemView.findViewById(R.id.tv_movie_name);
            roleView = (TextView) itemView.findViewById(R.id.tv_movie_role);
        }
    }
}
