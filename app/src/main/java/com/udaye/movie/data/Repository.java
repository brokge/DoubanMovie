package com.udaye.movie.data;

import java.util.List;

import com.udaye.movie.entity.CelebrityBean;
import com.udaye.movie.entity.CommonBean;
import com.udaye.movie.entity.MovieDetailBean;
import com.udaye.movie.entity.TheatersMoive;
import com.udaye.movie.entity.Top250Bean;
import com.udaye.movie.entity.UsBoxBean;

import rx.Observable;

/**
 * 修改历史：
 */
public interface Repository {

    /**
     * 获取正在上映
     *
     * @param city
     * @return
     */
    Observable<List<TheatersMoive.SubjectsEntity>> gettheatersMovie(String city);


    /**
     * 获取即将上映的电影
     *
     * @param start
     * @param count
     * @return
     */
    Observable<CommonBean> getCommingSoonMovie(int start, int count);

    /**
     * 获取文章详情
     *
     * @param id id
     * @return
     */
    Observable<MovieDetailBean> getMovieDetail(int id);

    /**
     * 获取演员详情
     *
     * @param id
     * @return
     */
    Observable<CelebrityBean> getCelebrityDetail(int id);


    /**
     * top 250 电影
     *
     * @param start
     * @param count
     * @return
     */
    Observable<Top250Bean> getTop250Movie(int start, int count);

    /**
     * 北美排行榜
     *
     * @return
     */
    Observable<UsBoxBean> getUsBoxMovie();


}