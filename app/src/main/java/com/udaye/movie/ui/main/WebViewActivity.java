package com.udaye.movie.ui.main;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.udaye.movie.R;
import com.udaye.movie.widget.ObservableScrollView;
import com.udaye.movie.widget.ObservableScrollViewCallbacks;
import com.udaye.movie.widget.ObservableWebView;
import com.udaye.movie.widget.ScrollState;

/**
 * 通过链接加载网页
 * <p/>
 * Created  on 2014/12/16.
 */
public class WebViewActivity extends BaseActivity {
    private ObservableWebView mWebView;
    private ObservableScrollView mScrollView;
    private View mHeaderView;
    private Toolbar mToolbarView;
    private String mUrl;
    private String mTitle;
    private ProgressBar mProgressBar;
    private boolean mFirstScroll;
    private boolean mDragging;
    private int mBaseTranslationY;
    private Button mButtonPre;

    /**
     * 初始化参数
     */
    private void initArguments() {
        Bundle bundle = getIntent().getExtras();
        mUrl = bundle.getString("url");
        mTitle = bundle.getString("title");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initArguments();
        setContentView(R.layout.web_view);
        initActionBar();
        mWebView = (ObservableWebView) findViewById(R.id.webview_webview);
        mScrollView = (ObservableScrollView) findViewById(R.id.scroll);
        mScrollView.setScrollViewCallbacks(mScrollViewScrollCallbacks);
        mHeaderView = findViewById(R.id.header);
        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
        mButtonPre = (Button) findViewById(R.id.button_pre);
        mProgressBar.setMax(100);

        initWebView();
    }

    @Override
    void initActionBar() {
        mToolbarView = (Toolbar) findViewById(R.id.awesome_toolbar);
        setSupportActionBar(mToolbarView);
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
     * 初始化WebView控件
     */
    private void initWebView() {
        mWebView.setScrollViewCallbacks(mWebViewScrollCallbacks);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // WebViewActivity.this.setProgress(newProgress);
                mProgressBar.setProgress(newProgress);
            }
        });
        mWebView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(WebViewActivity.this, "Oh no! " + description, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mProgressBar.setVisibility(View.GONE);
            }
        });
        mWebView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                try {
                    Uri uri = Uri.parse(url);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(intent, 0);
                    }
                } catch (ActivityNotFoundException ex) {
                }
            }
        });

        mWebView.loadUrl(mUrl);
    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()) {
              /*  case R.id.action_edit:
                    msg += "Click edit";
                    break;
                case R.id.action_share:
                    msg += "Click share";
                    break;
                case R.id.action_settings:
                    msg += "Click setting";*/
                //break;
            }
            if (!msg.equals("")) {
                Toast.makeText(WebViewActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 为了让toolbar有menu的特性，这些不能够去掉
        // getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    private ObservableScrollViewCallbacks mScrollViewScrollCallbacks = new ObservableScrollViewCallbacks() {
        @SuppressLint("NewApi")
        @Override
        public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
            if (mDragging) {
                int toolbarHeight = mToolbarView.getHeight();
                if (mFirstScroll) {
                    mFirstScroll = false;
                    float currentHeaderTranslationY = mHeaderView.getTranslationY();
                    if (-toolbarHeight < currentHeaderTranslationY && toolbarHeight < scrollY) {
                        mBaseTranslationY = scrollY;
                    }
                }
                int headerTranslationY = Math.min(0, Math.max(-toolbarHeight, -(scrollY - mBaseTranslationY)));
                mHeaderView.animate().cancel();
                mHeaderView.setTranslationY(headerTranslationY);

            }
        }

        @Override
        public void onDownMotionEvent() {
        }

        @SuppressLint("NewApi")
        @Override
        public void onUpOrCancelMotionEvent(ScrollState scrollState) {
            mDragging = false;
            mBaseTranslationY = 0;
            float headerTranslationY = mHeaderView.getTranslationY();
            int toolbarHeight = mToolbarView.getHeight();
            if (scrollState == ScrollState.UP) {
                if (toolbarHeight < mScrollView.getCurrentScrollY()) {
                    if (headerTranslationY != -toolbarHeight) {
                        mHeaderView.animate().cancel();
                        mHeaderView.animate().translationY(-toolbarHeight).setDuration(200).start();
                    }
                }
            } else if (scrollState == ScrollState.DOWN) {
                if (toolbarHeight < mScrollView.getCurrentScrollY()) {
                    if (headerTranslationY != 0) {
                        mHeaderView.animate().cancel();
                        mHeaderView.animate().translationY(0).setDuration(200).start();
                    }
                }
            }
        }
    };
    private ObservableScrollViewCallbacks mWebViewScrollCallbacks = new ObservableScrollViewCallbacks() {
        @Override
        public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        }

        @Override
        public void onDownMotionEvent() {
            mFirstScroll = mDragging = true;
        }

        @Override
        public void onUpOrCancelMotionEvent(ScrollState scrollState) {
        }
    };

    //对返回按钮的处理，如果没有当前web访问历史为空的话，则连着按两次销毁当前activity
    int i = 0;

    @Override
    public boolean onKeyDown(int keyCoder, KeyEvent event) {
        if (mWebView.canGoBack() && keyCoder == KeyEvent.KEYCODE_BACK) {
            i = 0;
            mWebView.goBack();   //goBack()表示返回webView的上一页面
            return true;
        } else if (!mWebView.canGoBack() && keyCoder == KeyEvent.KEYCODE_BACK) {
            i++;
            if (i == 1) {
                Toast.makeText(WebViewActivity.this, "再次点击退出当前页面", Toast.LENGTH_SHORT).show();
            }
            if (i == 2) {
                i = 0;
                finish();
            }
        }
        return false;
    }

    public static void start(Context context, String url, String content) {
        Intent starter = new Intent(context, WebViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        bundle.putString("title", content);
        starter.putExtras(bundle);
        context.startActivity(starter);
    }

}
