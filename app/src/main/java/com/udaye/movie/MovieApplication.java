package com.udaye.movie;

import android.app.Application;
import android.content.Context;

/**
 * Created  on 16-6-6.
 * <p/>
 * 应用入口
 */
public class MovieApplication extends Application {

    public static Context mContext;
    public static MovieApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        //
        mContext = getApplicationContext();
        mInstance = this;
    }
}
