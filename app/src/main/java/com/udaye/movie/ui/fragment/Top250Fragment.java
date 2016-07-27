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
import com.udaye.movie.adapter.Top250Adapter;
import com.udaye.movie.entity.Top250Bean;
import com.udaye.movie.util.RecyclerViewUtil.GridMarginDecoration;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * top 250 fragement
 * <p/>
 * Created  on 16/7/12.
 */
public class Top250Fragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    RecyclerView recyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    Top250Adapter top250Adapter;

    List<Top250Bean.SubjectsBean> mList;

    public static Top250Fragment newInstance() {

        Bundle args = new Bundle();

        Top250Fragment fragment = new Top250Fragment();
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
                getResources().getDimensionPixelSize(R.dimen.grid_item_spacing)));
        recyclerView.setHasFixedSize(true);
        setPreLoadData();
    }


    @Override
    public void onRefresh() {
        requestData(0, 50);
    }

    public void setPreLoadData() {
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
                requestData(0, 20);
            }
        });
    }


    private void requestData(int start, int count) {
        mRepository.getTop250Movie(start, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Top250Bean>() {
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
                    public void onNext(Top250Bean top250Bean) {
                        if (top250Bean != null) {
                            mList = top250Bean.getSubjects();
                            if (top250Adapter == null) {
                                top250Adapter = new Top250Adapter(getContext(), mList);
                                recyclerView.setAdapter(top250Adapter);
                            } else {
                                top250Adapter.update((ArrayList<Top250Bean.SubjectsBean>) mList);
                            }
                        }
                    }
                });
    }

}

