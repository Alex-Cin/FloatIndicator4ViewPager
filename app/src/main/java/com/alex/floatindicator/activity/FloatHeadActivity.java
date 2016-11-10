package com.alex.floatindicator.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.alex.floatindicator.R;
import com.alex.floatindicator.adapter.ScoreRecyclerAdapter;
import com.alex.floatindicator.baseui.FIVActivity;
import com.alex.floatindicator.config.AppCon;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：alex
 * 时间：2016/8/3 17:55
 * 博客地址：http://www.jianshu.com/users/c3c4ea133871/subscriptions
 */
public class FloatHeadActivity extends FIVActivity{
    protected int pageindex = 1;
    /**加载类型：  首次加载  上拉加载  下拉刷新*/
    protected String loadType;

    private XRecyclerView xRecyclerView;
    private ScoreRecyclerAdapter adapter;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_float_head;
    }


    @Override
    public void onCreateData(Bundle bundle) {
        initView();
        loadJsonData();
    }

    /**
     * 初始化视图
     *
     * @time 2014-12-27    09:52
     */
    private void initView() {
        xRecyclerView = (XRecyclerView) findViewById(R.id.xrv);
        adapter = new ScoreRecyclerAdapter();
        xRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        xRecyclerView.setItemAnimator(new DefaultItemAnimator());
        xRecyclerView.setAdapter(adapter);
        xRecyclerView.setLoadingListener(new MyOnSwipeToLoadListener());

    }
    private final class MyOnSwipeToLoadListener implements XRecyclerView.LoadingListener {
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
            xRecyclerView.loadMoreComplete();
            xRecyclerView.refreshComplete();
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



}
