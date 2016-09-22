package com.alex.floatindicator.activity;

import android.webkit.WebView;

import com.alex.floatindicator.R;

import org.alex.mvcapp.baseui.BaseActivity;

/**
 * 作者：Alex
 * 时间：2016/9/22 16:51
 * 简述：
 * 启动者：
 * ------------{@link MainActivity}
 */
public class FadeTitleActivity extends BaseActivity {
    @Override
    public int getLayoutResId() {
        return R.layout.activity_fade_title;
    }

    @Override
    public void onCreateData() {
        super.onCreateData();
        WebView webView = findView(R.id.wv);
        webView.loadUrl("http://www.jianshu.com/users/c3c4ea133871/latest_articles");
    }
}
