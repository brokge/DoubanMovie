package com.udaye.movie.entity;

import java.util.ArrayList;

/**
 * Created on 16-6-6.
 *
 * 正在上映请求响应
 */
public class InTheatersRsp {

    /**
     {
     "title": "正在上映的电影-北京",
     "total": 39,
     "start": 0,
     "count": 20,
     "subjects": [<Subject>, ...],
     }
     */
    public String title;
    public int total;
    public int start;
    public int count;
    public ArrayList<Subject> subjects;
}
