package com.udaye.movie.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import com.udaye.movie.R;
import com.udaye.movie.adapter.UsBoxAdapter;
import com.udaye.movie.entity.UsBoxBean;
import com.udaye.movie.util.RecyclerViewUtil.GridMarginDecoration;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 北美排行榜
 * <p>
 * Created on 16/7/12.
 */
public class UsBoxFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    List<UsBoxBean.SubjectsBean> mList;
    RecyclerView recyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    UsBoxAdapter usBoxAdapter;

    public static UsBoxFragment newInstance() {

        Bundle args = new Bundle();
        UsBoxFragment fragment = new UsBoxFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top250, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_recyclerview);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.srl_refresh_layout);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView.addItemDecoration(new GridMarginDecoration(
                getResources().getDimensionPixelSize(R.dimen.grid_item_spacing_1)));
        recyclerView.setHasFixedSize(true);
        setPreLoadData();
    }


    @Override
    public void onRefresh() {
        requestData();
    }

    public void setPreLoadData() {
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
                requestData();
            }
        });
    }


    private void requestData() {
        mRepository.getUsBoxMovie()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UsBoxBean>() {
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
                    public void onNext(UsBoxBean usBoxBean) {
                        if (usBoxBean != null) {
                            mList = usBoxBean.getSubjects();
                            if (usBoxAdapter == null) {
                                usBoxAdapter = new UsBoxAdapter(getContext(), mList);
                                recyclerView.setAdapter(usBoxAdapter);
                            } else {
                                usBoxAdapter.update((ArrayList<UsBoxBean.SubjectsBean>) mList);
                            }
                        }
                    }
                });
    }
}
