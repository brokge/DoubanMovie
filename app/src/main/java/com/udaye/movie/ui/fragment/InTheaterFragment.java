package com.udaye.movie.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import com.udaye.movie.R;
import com.udaye.movie.adapter.InTheatersAdapter;
import com.udaye.movie.entity.TheatersMoive;
import com.udaye.movie.util.RecyclerViewUtil.GridMarginDecoration;
import com.udaye.tablet.superloadlibrary.GridRecyclerView;
import com.udaye.tablet.superloadlibrary.OnLoadMoreListener;
import com.udaye.tablet.superloadlibrary.SuperRecyclerView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 正在热映
 * <p/>
 * Created on 16/6/27.
 */
public class InTheaterFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    GridRecyclerView mRecyclerView;
    GridLayoutManager mGridLayoutManager;
    InTheatersAdapter mTheaterAdapter;
    SwipeRefreshLayout mSwipeRefreshLayout;

    List<TheatersMoive.SubjectsEntity> mSubjectsEntities;

    public static InTheaterFragment newInstance() {
        Bundle args = new Bundle();
        InTheaterFragment fragment = new InTheaterFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intheater, null);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.srl_refresh_layout);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView = (GridRecyclerView) view.findViewById(R.id.recyclerview);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mGridLayoutManager = new GridLayoutManager(getActivity(), 3);
        mGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (position % 6) {
                    case 5:
                        return 3;
                    case 3:
                        return 2;
                    default:
                        return 1;
                }
            }
        });
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mRecyclerView.addItemDecoration(new GridMarginDecoration(
                getResources().getDimensionPixelSize(R.dimen.grid_item_spacing)));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(SuperRecyclerView recyclerView) {
                // recyclerView.showFootProgress();
            }
        });

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
        mRepository.gettheatersMovie("杭州")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<TheatersMoive.SubjectsEntity>>() {
                    @Override
                    public void onCompleted() {
                        if (mSwipeRefreshLayout != null && mSwipeRefreshLayout.isRefreshing()) {
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (mSwipeRefreshLayout != null && mSwipeRefreshLayout.isRefreshing()) {
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    }

                    @Override
                    public void onNext(List<TheatersMoive.SubjectsEntity> subjectsEntities) {
                        mSubjectsEntities = subjectsEntities;
                        if (mTheaterAdapter == null) {
                            mTheaterAdapter = new InTheatersAdapter(mSubjectsEntities, getActivity());
                            mRecyclerView.setAdapter(mTheaterAdapter);
                        } else {
                            mTheaterAdapter.update(mSubjectsEntities);
                        }

                    }
                });

    }

}
