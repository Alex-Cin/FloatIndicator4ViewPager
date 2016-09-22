package com.alex.floatindicator.fragment;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alex.floatindicator.R;
import com.alex.floatindicator.adapter.ScoreRecyclerAdapter;
import com.alex.floatindicator.config.AppCon;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("InflateParams")
public class BeforeGameScoreFragment extends Fragment {
    protected int pageindex = 1;
    /**加载类型：  首次加载  上拉加载  下拉刷新*/
    protected String loadType;
    protected View rootView;

    private XRecyclerView xRecyclerView;
    private ScoreRecyclerAdapter adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadType = AppCon.loadFirst;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_game_before_score, null);
            initView();
            loadJsonData();
        }
        /*过滤Fragment重叠，如果是 Fragment嵌套Fragment，不能加这个*/
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    /**
     * 初始化视图
     *
     * @time 2014-12-27    09:52
     */
    private void initView() {
        xRecyclerView = (XRecyclerView) rootView.findViewById(R.id.xrv);
        adapter = new ScoreRecyclerAdapter(getContext());
        xRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        xRecyclerView.setItemAnimator(new DefaultItemAnimator());
        xRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallBeat);
        xRecyclerView.setLoadingListener(new MyLoadListener());
        xRecyclerView.setAdapter(adapter);
    }

    private final class MyLoadListener implements XRecyclerView.LoadingListener {
        @Override
        public void onRefresh()
        {
            loadType = AppCon.loadRefresh;
            pageindex = 1;
            new LoadTadk().execute();
        }
        @Override
        public void onLoadMore()
        {
            loadType = AppCon.loadMore;
            pageindex++;
            new LoadTadk().execute();
        }
    }


    private final class LoadTadk extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params)
        {
            SystemClock.sleep(1500);
            return null;
        }
        @Override
        protected void onPostExecute(Void result)
        {
            xRecyclerView.refreshComplete();
            xRecyclerView.loadMoreComplete();
            super.onPostExecute(result);
        }

    }

    private void loadJsonData() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add("我是数据 " + i);
        }
        adapter.addItem(list);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if ((rootView != null) && (rootView.getParent() != null)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
    }

}
