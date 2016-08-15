package com.udaye.movie.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import com.udaye.movie.R;
import com.udaye.movie.entity.MovieDetailBean;
import com.udaye.movie.util.RecyclerViewUtil.GridMarginDecoration;
import com.udaye.library.pullloadlibrary.CommonViewHolder;
import com.udaye.library.pullloadlibrary.RecyclerViewCommonAdapter;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created on 16-6-6.
 * <p/>
 * 电影详情页面
 */
public class MovieDetailActivity extends BaseActivity {

    private static final String INTENT_KEY_MOVIE_ID = "id";
    private ImageView bgImageView;
    private CollapsingToolbarLayout collapsingToolbar;
    private RecyclerView rvList;
    private TextView tvSummary;

    private RatingBar rbMovieLevel;
    private TextView tvMovieLevelInfo;
    private TextView tvMovieInfo;

    public static Intent getCallingIntent(Context context, String id) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(INTENT_KEY_MOVIE_ID, id);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        initActionBar();

        collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        bgImageView = (ImageView) findViewById(R.id.backdrop);
        tvSummary = (TextView) findViewById(R.id.tv_summary);
        tvMovieInfo = (TextView) findViewById(R.id.tv_movie_info);
        rbMovieLevel = (RatingBar) findViewById(R.id.rb_movie_level);
        tvMovieLevelInfo = (TextView) findViewById(R.id.tv_movie_level_info);
        rvList = (RecyclerView) findViewById(R.id.rv_horizontal_view);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvList.setLayoutManager(layoutManager);
        rvList.addItemDecoration(new GridMarginDecoration(
                getResources().getDimensionPixelSize(R.dimen.grid_item_spacing)));
        getMovieDetail(getIntent());
    }

    @Override
    void initActionBar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        getMovieDetail(intent);
    }

    /**
     * 获取电影咨询 详情
     */
    private void getMovieDetail(Intent intent) {
        String movieId = intent.getStringExtra(INTENT_KEY_MOVIE_ID);
        if (!TextUtils.isEmpty(movieId)) {
            mRepository.getMovieDetail(Integer.parseInt(movieId))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<MovieDetailBean>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(MovieDetailBean movieDetailBean) {
                            if (movieDetailBean != null) {
                                loadBackdrop(movieDetailBean.getImages().getLarge());
                                MovieDetailBean.RatingBean ratingBean = movieDetailBean.getRating();
                                if (ratingBean != null) {
                                    float averageLevel = (float) movieDetailBean.getRating().getAverage();
                                    rbMovieLevel.setRating(averageLevel / 2);
                                    tvMovieLevelInfo.setText(String.format(" %s 分", String.valueOf(averageLevel)));
                                }
                                collapsingToolbar.setTitle(movieDetailBean.getTitle());
                                //collapsingToolbar.setExpandedTitleColor(MovieDetailActivity.this.getResources().getColor(R.color.colorPrimary));
                                tvSummary.setText(movieDetailBean.getSummary());

                                loadBaseInfo(movieDetailBean);

                                ArtAdapter artAdapter = new ArtAdapter(MovieDetailActivity.this, movieDetailBean.getCasts());
                                rvList.setAdapter(artAdapter);

                            }
                        }
                    });
        }
    }

    /**
     * 加载影片信息
     *
     * @param movieDetailBean
     */
    private void loadBaseInfo(MovieDetailBean movieDetailBean) {
        StringBuilder stringBuilder = new StringBuilder();
        List<MovieDetailBean.DirectorsBean> directorsBeanList = movieDetailBean.getDirectors();

        if (directorsBeanList != null && directorsBeanList.size() > 0) {
            stringBuilder.append("导演:");
            boolean isFirst = true;
            for (MovieDetailBean.DirectorsBean directorsBean : directorsBeanList) {
                if (!isFirst) {
                    stringBuilder.append("/");
                }
                stringBuilder.append(directorsBean.getName());
                isFirst = false;
            }
            stringBuilder.append("\n");
        }

        List<String> genres = movieDetailBean.getGenres();
        stringBuilder = listToString("类型:", genres, stringBuilder);

        stringBuilder.append("上映日期:");
        stringBuilder.append(movieDetailBean.getYear());
        stringBuilder.append("\n");

        List<String> countries = movieDetailBean.getCountries();
        stringBuilder = listToString("制片国家/地区:", countries, stringBuilder);

        List<String> akrs = movieDetailBean.getAka();
        if (akrs != null && akrs.size() > 3) {
            akrs = akrs.subList(0, 2);
        }
        stringBuilder = listToString("又名:", akrs, stringBuilder);

        tvMovieInfo.setText(stringBuilder.toString());
    }

    private StringBuilder listToString(String title, List<String> list, StringBuilder stringBuilder) {
        if (list != null && list.size() > 0) {
            stringBuilder.append(title);
            boolean isFirst = true;
            for (String string : list) {
                if (!isFirst) {
                    stringBuilder.append("/");
                }
                stringBuilder.append(string);
                isFirst = false;
            }

            stringBuilder.append("\n");
        }
        return stringBuilder;
    }

    private void loadBackdrop(String url) {
        Glide.with(this).load(url).centerCrop().into(bgImageView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
        }
        return true;
    }

    private class ArtAdapter extends RecyclerViewCommonAdapter<MovieDetailBean.CastsBean> {

        public ArtAdapter(Context context, List<MovieDetailBean.CastsBean> data) {
            super(context, data, R.layout.view_list_cast_item);
        }

        @Override
        public void onListBindViewHolder(CommonViewHolder holder, int position) {
            final MovieDetailBean.CastsBean castsBean = getItem(position);
            if (castsBean != null) {
                if (castsBean.getAvatars() != null) {
                    ImageView castImageView = holder.getView(R.id.iv_cast_image);
                    Glide.with(mContext).load(castsBean.getAvatars().getLarge()).placeholder(android.R.color.white).into(castImageView);
                    //holder.loadImageUrl(mContext, R.id.iv_cast_image, castsBean.getAvatars().getLarge());
                } else {
                    holder.setImageRes(R.id.iv_cast_image, R.drawable.default_large);
                }
                holder.setText(R.id.tv_cast_name, castsBean.getName());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CelebrityActivity.start(mContext, castsBean.getId());
                    }
                });
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mRepository != null) {
        }
    }
}
