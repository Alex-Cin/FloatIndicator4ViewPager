package com.alex.floatindicator.adapter;

import android.view.View;
import android.webkit.WebView;

import com.alex.floatindicator.R;
import com.chad.adapter.BaseViewHolder;
import com.chad.adapter.SingleRecyclerAdapter;


/**
 * 作者：Alex
 * 时间：2016/9/20 14:47
 * 简述：
 */
public class BeforeGameInfoStatioAdapter extends SingleRecyclerAdapter<String> {

    @Override
    public int getLayoutResId() {
        return R.layout.item_before_game_info_station;
    }

    @Override
    protected void onConvert(BaseViewHolder holder, String s, int i) {
        WebView webView = holder.findView(R.id.wv);
        String url = "http://news.baidu.com/";
        //url = "https://www.baidu.com/";
        webView.loadUrl(url);
        /*背景透明*/
        webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
		/*背景透明*/
        webView.setBackgroundColor(0);
    }
}
