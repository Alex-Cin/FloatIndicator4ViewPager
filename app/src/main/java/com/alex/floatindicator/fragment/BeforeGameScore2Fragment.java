package com.alex.floatindicator.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alex.floatindicator.R;
import com.alex.floatindicator.adapter.ScoreRecyclerAdapter;
import com.alex.floatindicator.config.AppCon;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("InflateParams")
public class BeforeGameScore2Fragment extends Fragment {
    protected int pageindex = 1;
    /**加载类型：  首次加载  上拉加载  下拉刷新*/
    protected String loadType;
    protected View rootView;

    private RecyclerView recyclerView;
    private ScoreRecyclerAdapter adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadType = AppCon.loadFirst;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_game_before_score_2, null);
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
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv);
        adapter = new ScoreRecyclerAdapter();
        recyclerView.setAdapter(adapter);
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
