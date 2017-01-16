package com.alex.floatindicator.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alex.floatindicator.R;
import com.alex.floatindicator.adapter.ScoreRecyclerAdapter;
import com.alex.floatindicator.config.AppCon;

import org.alex.helper.RecyclerViewHelper;
import org.alex.helper.itemdecoration.SimpleItemDecoration;
import org.alex.helper.recycler.LayoutType;
import org.alex.refreshlayout.RefreshLayout;
import org.alex.refreshlayout.callback.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("InflateParams")
public class BeforeGameScoreFragment extends Fragment {
    protected int pageindex = 1;
    /**
     * 加载类型：  首次加载  上拉加载  下拉刷新
     */
    protected String loadType;
    protected View rootView;
    private Handler handler;
    private RefreshLayout refreshLayout;

    private int loadMore;
    private ScoreRecyclerAdapter adapter;
    private TextView tvFoot;

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
        RecyclerView recyclerview = (RecyclerView) rootView.findViewById(R.id.rv);
        RecyclerViewHelper.Builder.getInstance().layoutManager(LayoutType.VLinearLayout).build().attachToRecyclerView(recyclerview);
        SimpleItemDecoration.Builder.getInstance().backgroundColor("#F9F9F9").color("#EEEEEE").dividerSize(4).build().attachToRecyclerView(recyclerview);
        adapter = new ScoreRecyclerAdapter();
        recyclerview.setAdapter(adapter);
        handler = new android.os.Handler(Looper.getMainLooper());
        refreshLayout = (RefreshLayout) rootView.findViewById(R.id.srl);
        refreshLayout.setOnRefreshListener(new MyOnRefreshListener());
        refreshLayout.autoRefresh();
        View footView =  LayoutInflater.from(getContext()).inflate(R.layout.swipe_refresh_default_footer, null);
        tvFoot = (TextView) footView.findViewById(R.id.default_footer_title);
        tvFoot.setText("加载中");
        adapter.addFootView(footView);
        refreshLayout.setFootView(tvFoot);
    }

    private final class MyOnRefreshListener implements OnRefreshListener {

        /**
         * Called when a swipe gesture triggers a refresh.
         */
        @Override
        public void onRefresh() {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    loadMore = 0;
                    adapter.refreshItem(getList5());
                    refreshLayout.setLoadMoreEnabled(true);
                    refreshLayout.stopRefreshLayout();
                }
            }, 2000);
        }

        @Override
        public void onLoadMore() {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //adapter.addItem("我是 loadMore " + (loadMore++));
                    //adapter.addItem("我是 loadMore " + (loadMore++));
                    refreshLayout.setLoadMoreFailLabel("没有更多数据");
                    refreshLayout.setLoadMoreEnabled(false);
                    refreshLayout.stopRefreshLayout();
                }
            }, 2000);
        }
    }


    private List<String> getList5() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add("你好 " + i);
        }
        return list;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if ((rootView != null) && (rootView.getParent() != null)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
    }

}
