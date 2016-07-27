package com.udaye.movie.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.CompoundButton;

import com.udaye.movie.R;
import com.udaye.movie.util.AppConfig;

/**
 * 设置页面
 * <p/>
 * Created on 16/7/4.
 */
public class SettingActivity extends BaseActivity {

    private SwitchCompat scIsSee, scIsCache;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initActionBar();
        scIsSee = (SwitchCompat) findViewById(R.id.sc_is_see);
        scIsCache = (SwitchCompat) findViewById(R.id.sc_is_cache);

        boolean isCache = AppConfig.getIsCache(this);
        scIsCache.setChecked(isCache);
        boolean isSee = AppConfig.getIsSee(this);
        scIsSee.setChecked(isSee);

        scIsSee.setOnCheckedChangeListener(onCheckedChangeListener);
        scIsCache.setOnCheckedChangeListener(onCheckedChangeListener);
    }


    @Override
    void initActionBar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    /**
     * 选择改变事件
     */
    private SwitchCompat.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.sc_is_cache:
                    AppConfig.setIsCache(SettingActivity.this, isChecked);
                    break;
                case R.id.sc_is_see:
                    AppConfig.setIsSee(SettingActivity.this, isChecked);
                    break;
            }
        }
    };


    public static void start(Context context) {
        Intent starter = new Intent(context, SettingActivity.class);
        context.startActivity(starter);
    }
}
