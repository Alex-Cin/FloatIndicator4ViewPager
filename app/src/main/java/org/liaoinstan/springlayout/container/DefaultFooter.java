package org.liaoinstan.springlayout.container;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alex.floatindicator.R;


/**
 * Created by Administrator on 2016/3/21.
 */
@SuppressWarnings("all")
public class DefaultFooter extends BaseFooter {
    private Context context;
    private int rotationSrc;
    private TextView footerTitle;
    public DefaultFooter(Context context){
        this.context = context;
    }

    @Override
    public View getView(LayoutInflater inflater, ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.liaoinstan_springview_default_footer, viewGroup, true);
        footerTitle = (TextView) view.findViewById(R.id.default_footer_title);
        return view;
    }

    @Override
    public void onPreDrag(View rootView) {
    }

    @Override
    public void onDropAnim(View rootView, int dy) {
    }

    @Override
    public void onLimitDes(View rootView, boolean upORdown) {
        if (upORdown) {
            footerTitle.setText("松开载入更多");
        } else {
            footerTitle.setText("上拉加载更多");
        }
    }

    @Override
    public void onStartAnim() {
        footerTitle.setVisibility(View.VISIBLE);
        footerTitle.setText("正在加载");
        //footerProgressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFinishAnim() {
        footerTitle.setText("上拉加载更多");
        footerTitle.setVisibility(View.VISIBLE);
    }
}