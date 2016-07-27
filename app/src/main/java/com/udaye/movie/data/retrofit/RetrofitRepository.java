package com.udaye.movie.data.retrofit;

import android.content.Context;

import java.util.List;

import com.udaye.movie.data.Repository;
import com.udaye.movie.entity.CelebrityBean;
import com.udaye.movie.entity.CommonBean;
import com.udaye.movie.entity.MovieDetailBean;
import com.udaye.movie.entity.TheatersMoive;
import com.udaye.movie.entity.Top250Bean;
import com.udaye.movie.entity.UsBoxBean;
import rx.Observable;
import rx.functions.Func1;

/**
 * 修改历史：
 */
public class RetrofitRepository implements Repository {

    private static RetrofitRepository mRetrofitRepository;
    private Context mContext;
    private MovieApiService mMovieApiService;

    private RetrofitRepository(Context mContext) {
        this.mContext = mContext;
        mMovieApiService = MovieApiService.Factory.createService(mContext);
    }

    public synchronized static RetrofitRepository getInstance(Context context) {
        if (mRetrofitRepository == null) {
            mRetrofitRepository = new RetrofitRepository(context);
        }
        return mRetrofitRepository;
    }

    @Override
    public Observable<List<TheatersMoive.SubjectsEntity>> gettheatersMovie(String city) {
        return mMovieApiService.getTheatersMovie(city)
                .map(new Func1<TheatersMoive, List<TheatersMoive.SubjectsEntity>>() {
                    @Override
                    public List<TheatersMoive.SubjectsEntity> call(TheatersMoive theatersMoive) {
                        return theatersMoive.getSubjects();
                    }
                });
    }

    @Override
    public Observable<List<CommonBean.SubjectsBean>> getCommingSoonMovie(int start, int count) {
        return mMovieApiService.getCommongSoonMovie(start, count)
                .map(new Func1<CommonBean, List<CommonBean.SubjectsBean>>() {
                    @Override
                    public List<CommonBean.SubjectsBean> call(CommonBean commonBean) {
                        return commonBean.getSubjects();
                    }
                });
    }

    @Override
    public Observable<MovieDetailBean> getMovieDetail(int id) {
        return mMovieApiService.getMovieDetail(id);/*map(new Func1<MovieDetailBean, MovieDetailBean>() {
            @Override
            public MovieDetailBean call(MovieDetailBean movieDetailBean) {
                return movieDetailBean;
            }
        });*/
    }

    @Override
    public Observable<CelebrityBean> getCelebrityDetail(int id) {
        return mMovieApiService.getCelebrityDetail(id);
    }

    @Override
    public Observable<Top250Bean> getTop250Movie(int start, int count) {
        return mMovieApiService.getTop250Movie(start, count);
    }

    @Override
    public Observable<UsBoxBean> getUsBoxMovie() {
        return mMovieApiService.getUsBoxMovie();
    }


}