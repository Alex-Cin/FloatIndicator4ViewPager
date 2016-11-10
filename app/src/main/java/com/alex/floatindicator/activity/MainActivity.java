package com.alex.floatindicator.activity;

import android.os.Bundle;
import android.view.View;

import com.alex.floatindicator.R;
import com.alex.floatindicator.baseui.FIVActivity;

import org.alex.util.VirtualKeyUtil;

/**
 * 作者：alex
 * 时间：2016/8/3 17:43
 * 博客地址：http://www.jianshu.com/users/c3c4ea133871/subscriptions
 */
public class MainActivity extends FIVActivity {

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreateData(Bundle bundle) {
    }

    @Override
    public void onClick(View v) {
        if (R.id.bt_1 == v.getId()) {
            startActivity(FloatIndicatorActivity.class);
        } else if (R.id.bt_1_1 == v.getId()) {
            startActivity(SwipeRefreshFloatIndicatorActivity.class);
        } else if (R.id.bt_2 == v.getId()) {
            startActivity(FloatHeadActivity.class);
        } else if (R.id.bt_3 == v.getId()) {
            startActivity(AlphaTitleActivity.class);
        } else if (R.id.bt_4 == v.getId()) {
            startActivity(FadeTitleActivity.class);
        } else if (R.id.bt_5 == v.getId()) {
            VirtualKeyUtil.hideVirtualKey(this, false);
        } else if (R.id.bt_6 == v.getId()) {
            VirtualKeyUtil.showVirtualKey(this);
        }
    }
}
