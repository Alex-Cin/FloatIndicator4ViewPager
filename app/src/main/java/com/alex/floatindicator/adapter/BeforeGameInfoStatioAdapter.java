package com.alex.floatindicator.adapter;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;

import com.alex.floatindicator.R;

import org.alex.adapter.SingleRecyclerAdapter;
import org.alex.adapter.core.RecyclerViewHolder;

/**
 * 作者：Alex
 * 时间：2016/9/20 14:47
 * 简述：
 */
public class BeforeGameInfoStatioAdapter extends SingleRecyclerAdapter<String> {
    public BeforeGameInfoStatioAdapter(Context context) {
        super(context,R.layout.item_before_game_info_station);
    }

    @Override
    public void onConvert(RecyclerViewHolder holder, int i) {

        WebView webView = holder.findView(R.id.wv);
        String url = "http://news.baidu.com/";
        //url = "https://www.baidu.com/";
        webView.loadUrl(url);
		/*背景透明*/
        webView.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
		/*背景透明*/
        webView.setBackgroundColor(0);
    }

    @Override
    public void onPositionClick(View view, int i) {

    }
}
