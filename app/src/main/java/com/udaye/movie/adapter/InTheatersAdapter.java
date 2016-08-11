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
import com.udaye.movie.entity.TheatersMoive;
import com.udaye.movie.ui.main.MovieDetailActivity;
import com.udaye.tablet.superloadlibrary.*;
import com.udaye.tablet.superloadlibrary.CommonViewHolder;

/**
 * Created  on 16-6-6.
 * <p/>
 * 正在上映电影 - 数据适配器
 */
public class InTheatersAdapter extends com.udaye.tablet.superloadlibrary.RecyclerViewCommonAdapter<TheatersMoive.SubjectsEntity> {

    public InTheatersAdapter(List<TheatersMoive.SubjectsEntity> list, Context context) {
        super(context, list, R.layout.view_list_item_home);
    }

    public void update(List<TheatersMoive.SubjectsEntity> list) {
        mList = list;
        notifyDataSetChanged();
    }
/*

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_item_home, parent, false);
        PhotoViewHolder holder = new PhotoViewHolder(view);
        return holder;
    }
*/

   /* @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PhotoViewHolder photoViewHolder = (PhotoViewHolder) holder;
        final TheatersMoive.SubjectsEntity entity = mList.get(position);
        Glide.with(mContext)
                .load(mList.get(position).getImages().getLarge())
                .placeholder(android.R.color.white)
                .into(photoViewHolder.photo);
        photoViewHolder.name.setText(entity.getTitle());
        photoViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(MovieDetailActivity.getCallingIntent(mContext, entity.getId()));
            }
        });
    }*/

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onListBindViewHolder(CommonViewHolder holder, int position) {
        final TheatersMoive.SubjectsEntity entity = mList.get(position);
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

/*
    final class PhotoViewHolder extends RecyclerView.ViewHolder {

        ImageView photo;
        TextView name;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            photo = (ImageView) itemView.findViewById(R.id.photo);
            name = (TextView) itemView.findViewById(R.id.tv_movie_name);
        }
    }*/
}
