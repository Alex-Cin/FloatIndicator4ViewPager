package com.alex.floatindicator.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.alex.floatindicator.R;
import com.alex.floatindicator.baseui.FIVActivity;
import com.alex.floatindicator.fragment.BeforeGameDataFragment;
import com.alex.floatindicator.fragment.BeforeGameInfoStationFragment;
import com.alex.floatindicator.fragment.BeforeGameScoreFragment;

import org.alex.adapter.TitleFragmentPagerAdapter;
import org.hellojp.tabsindicator.TabsIndicator;

/**
 * @link https://github.com/loonggg/CoordinatorLayoutDemo
 */
public class FloatIndicatorActivity extends FIVActivity {
    private LinearLayout headLayout;
    private ViewPager viewPager;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_float_indicator;
    }

    @Override
    public boolean canAutoBindClickListener() {
        return false;
    }

    @Override
    public void onCreateData(Bundle bundle) {
        setContentView(R.layout.activity_float_indicator);
        AppBarLayoutOnOffsetChangedListener onOffsetChangedListener = new AppBarLayoutOnOffsetChangedListener();
        ViewOnClickListener onClickListener = new ViewOnClickListener();
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.ab_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.vp);
        headLayout = (LinearLayout) findViewById(R.id.layout_head);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.co_to_layout);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(onClickListener);
        appBarLayout.addOnOffsetChangedListener(onOffsetChangedListener);
        TitleFragmentPagerAdapter adapter = new TitleFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        adapter.addFm(new BeforeGameDataFragment(), new BeforeGameScoreFragment(), new BeforeGameInfoStationFragment());
        adapter.addTitle("赛前数据", "赛前情评分", "赛前情报站");

        TabsIndicator tabsIndicator = (TabsIndicator) findViewById(R.id.ti);
        tabsIndicator.setViewPager(0, viewPager);
    }

    private final class ViewOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    }

    private final class AppBarLayoutOnOffsetChangedListener implements AppBarLayout.OnOffsetChangedListener {
        @Override
        public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
            if (verticalOffset <= -headLayout.getHeight() / 2) {
                collapsingToolbarLayout.setTitle("Alex");
            } else {
                collapsingToolbarLayout.setTitle("");
            }
        }
    }
}
