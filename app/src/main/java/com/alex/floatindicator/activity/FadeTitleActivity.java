package com.alex.floatindicator.activity;

import android.os.Bundle;
import android.webkit.WebView;

import com.alex.floatindicator.R;
import com.alex.floatindicator.baseui.FIVActivity;

import org.alex.callback.SimpleWebViewClient;
import org.alex.helper.WebViewHelper;

/**
 * 作者：Alex
 * 时间：2016/9/22 16:51
 * 简述：
 * 启动者：
 * ------------{@link MainActivity}
 */
public class FadeTitleActivity extends FIVActivity {

    private WebViewHelper webViewHelper;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_fade_title;
    }

    @Override
    public void onCreateData(Bundle bundle) {
        WebView webView = findView(R.id.wv);
        webViewHelper = WebViewHelper.Builder.getInstance().build().attachToWebView(webView);
        webView.setWebViewClient(new SimpleWebViewClient());
        webView.loadUrl("http://www.jianshu.com/users/c3c4ea133871/latest_articles");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(webViewHelper!=null){
            webViewHelper.clearCache();
        }
    }
}
