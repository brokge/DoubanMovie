package com.udaye.movie.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import com.udaye.movie.R;
import com.udaye.movie.adapter.CommingSoonAdapter;
import com.udaye.movie.entity.CommonBean;
import com.udaye.movie.util.RecyclerViewUtil.GridMarginDecoration;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 即将上映
 * <p/>
 * Created on 16/6/27.
 */
public class CommingSoonFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    RecyclerView mRecyclerView;
    GridLayoutManager mGridLayoutManager;
    CommingSoonAdapter mCommingSoonAdapter;
    SwipeRefreshLayout mSwipeRefreshLayout;

    List<CommonBean.SubjectsBean> mSubjectsEntities;

    public static CommingSoonFragment newInstance() {
        Bundle args = new Bundle();
        CommingSoonFragment fragment = new CommingSoonFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_commingsoon, null);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.srl_refresh_layout);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mGridLayoutManager = (GridLayoutManager) mRecyclerView.getLayoutManager();
        mGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (position % 4) {
                    case 0:
                        return 3;
                    default:
                        return 1;
                }
            }
        });
        mRecyclerView.addItemDecoration(new GridMarginDecoration(
                getResources().getDimensionPixelSize(R.dimen.grid_item_spacing)));
        mRecyclerView.setHasFixedSize(true);

        setPreLoadData();
    }

    @Override
    public void onRefresh() {
        requestDefaultData();
    }

    public void setPreLoadData() {
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
                requestDefaultData();
            }
        });
    }

    private void requestDefaultData() {
        mRepository.getCommingSoonMovie(0, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<CommonBean.SubjectsBean>>() {
                    @Override
                    public void onCompleted() {
                        if (mSwipeRefreshLayout != null && mSwipeRefreshLayout.isRefreshing()) {
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        if (mSwipeRefreshLayout != null && mSwipeRefreshLayout.isRefreshing()) {
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    }

                    @Override
                    public void onNext(List<CommonBean.SubjectsBean> subjectsBeen) {
                        mSubjectsEntities = subjectsBeen;
                        if (mCommingSoonAdapter == null) {
                            mCommingSoonAdapter = new CommingSoonAdapter(mSubjectsEntities, getActivity());
                            mRecyclerView.setAdapter(mCommingSoonAdapter);
                        } else {
                            mCommingSoonAdapter.update(mSubjectsEntities);
                        }
                    }
                });
    }
}
