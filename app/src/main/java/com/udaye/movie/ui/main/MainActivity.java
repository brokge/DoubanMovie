package com.udaye.movie.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;

import com.udaye.movie.R;
import com.udaye.movie.ui.fragment.CommingSoonFragment;
import com.udaye.movie.ui.fragment.InTheaterFragment;
import com.udaye.movie.ui.fragment.Top250Fragment;
import com.udaye.movie.ui.fragment.UsBoxFragment;

public class MainActivity extends BaseActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initActionBar();
        mTabLayout = (TabLayout) findViewById(R.id.tl_channel_tabs);
        mViewPager = (ViewPager) findViewById(R.id.vp_channel_pager);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), this);
        mViewPager.setAdapter(fragmentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);
            //actionBar.setTitle(R.string.app_name);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_title_setting:
                //ToastUtil.showShortMessage(MainActivity.this, "设置");
                SettingActivity.start(MainActivity.this);
                break;
        }
        return true;
    }

    private static class FragmentAdapter extends FragmentStatePagerAdapter {
        private Context context;

        public FragmentAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return context.getString(R.string.tab_title_intheaters);
                case 1:
                    return context.getString(R.string.tab_title_comming_soon);
                case 2:
                    return context.getString(R.string.tab_title_top250);
                case 3:
                    return context.getString(R.string.tab_title_us_box);
                default:
                    return context.getString(R.string.tab_title_intheaters);
            }
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return InTheaterFragment.newInstance();
                case 1:
                    return CommingSoonFragment.newInstance();
                case 2:
                    return Top250Fragment.newInstance();
                case 3:
                    return UsBoxFragment.newInstance();
                default:
                    return InTheaterFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
