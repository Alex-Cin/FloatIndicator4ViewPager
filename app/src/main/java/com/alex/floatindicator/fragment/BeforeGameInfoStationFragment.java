package com.alex.floatindicator.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alex.floatindicator.R;

import org.alex.callback.SimpleWebViewClient;
import org.alex.helper.WebViewHelper;
import org.alex.view.NestedWebView;

@SuppressLint("InflateParams")
public class BeforeGameInfoStationFragment extends Fragment {
    protected View rootView;

    protected NestedWebView webView;
    /**
     * ViewPager 的 子控件，ListView 或者 ScrollView 滑动到了
     */
    private boolean isChildOnTop;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_game_before_info_station, null);
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
        webView = (NestedWebView) rootView.findViewById(R.id.wv);
        WebViewHelper.Builder.getInstance().build().attachToWebView(webView);
        webView.loadUrl("http://www.jianshu.com/users/c3c4ea133871/latest_articles");
        webView.setWebViewClient(new SimpleWebViewClient());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if ((rootView != null) && (rootView.getParent() != null)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
    }


}
