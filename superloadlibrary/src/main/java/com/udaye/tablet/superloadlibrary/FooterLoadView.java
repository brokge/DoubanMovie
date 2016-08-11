package com.udaye.tablet.superloadlibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 加载更多 foot view
 * <p>
 * Created by brokge on 16/8/10.
 */
public class FooterLoadView extends RelativeLayout {
    protected State mState = State.Normal;
    private View mLoadingView;
    private View mNetworkErrorView;
    private View mTheEndView;
    private TextView mLoadingText;

    public FooterLoadView(Context context) {
        this(context, null);
    }

    public FooterLoadView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FooterLoadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate(context, R.layout.view_recylerview_footer, this);
        setState(State.Normal, true);
    }

    /**
     * 设置状态
     *
     * @param status
     * @param showView 是否展示当前View
     */
    public void setState(State status, boolean showView) {
        if (mState == status) {
            return;
        }
        mState = status;

        switch (status) {
            case Normal:
                setOnClickListener(null);
                if (mLoadingView != null) {
                    mLoadingView.setVisibility(GONE);
                }

                if (mTheEndView != null) {
                    mTheEndView.setVisibility(GONE);
                }
                if (mNetworkErrorView != null) {
                    mNetworkErrorView.setVisibility(GONE);
                }
                break;
            case Loading:
                setOnClickListener(null);
                if (mTheEndView != null) {
                    mTheEndView.setVisibility(GONE);
                }

                if (mNetworkErrorView != null) {
                    mNetworkErrorView.setVisibility(GONE);
                }

                if (mLoadingView == null) {
                    ViewStub viewStub = (ViewStub) findViewById(R.id.loading_viewstub);
                    mLoadingView = viewStub.inflate();
                    mLoadingText = (TextView) mLoadingView.findViewById(R.id.loading_text);
                } else {
                    mLoadingView.setVisibility(VISIBLE);
                }
                mLoadingView.setVisibility(showView ? VISIBLE : GONE);
                mLoadingText.setText(R.string.list_footer_loading);
                break;
            case TheEnd:
                setOnClickListener(null);
                if (mLoadingView != null) {
                    mLoadingView.setVisibility(GONE);
                }

                if (mNetworkErrorView != null) {
                    mNetworkErrorView.setVisibility(GONE);
                }

                if (mTheEndView == null) {
                    ViewStub viewStub = (ViewStub) findViewById(R.id.end_viewstub);
                    mTheEndView = viewStub.inflate();
                } else {
                    mTheEndView.setVisibility(VISIBLE);
                }

                mTheEndView.setVisibility(showView ? VISIBLE : GONE);
                break;
            case NetWorkError:
                if (mLoadingView != null) {
                    mLoadingView.setVisibility(GONE);
                }

                if (mTheEndView != null) {
                    mTheEndView.setVisibility(GONE);
                }

                if (mNetworkErrorView == null) {
                    ViewStub viewStub = (ViewStub) findViewById(R.id.network_error_viewstub);
                    mNetworkErrorView = viewStub.inflate();
                } else {
                    mNetworkErrorView.setVisibility(VISIBLE);
                }

                mNetworkErrorView.setVisibility(showView ? VISIBLE : GONE);
                break;
            default:

                break;
        }
    }

    public enum State {
        Normal/**正常*/
        , TheEnd/**加载到最底了*/
        , Loading/**加载中..*/
        , NetWorkError/**网络异常*/
    }

}
