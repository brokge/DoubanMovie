package com.udaye.movie.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.udaye.movie.data.retrofit.RetrofitRepository;

/**
 * 基类
 * <p/>
 * Created on 16/6/28.
 */
public abstract class BaseActivity extends AppCompatActivity {
    RetrofitRepository mRepository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRepository = RetrofitRepository.getInstance(this);
    }

    /* protected void initActionBar() {
         ActionBar actionBar = getSupportActionBar();
         if (actionBar != null) {
             actionBar.setDisplayHomeAsUpEnabled(true);
         }
     }
 */
    abstract void initActionBar();

}
