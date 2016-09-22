package org.liaoinstan.springlayout.container;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.alex.floatindicator.R;

/**
 * Created by Administrator on 2016/3/21.
 */
@SuppressWarnings("all")
public class DefaultHeader extends BaseHeader {
    private Context context;
    private int arrowSrc;

    private long freshTime;

    private final int ROTATE_ANIM_DURATION = 180;
    private RotateAnimation mRotateUpAnim;
    private RotateAnimation mRotateDownAnim;

    private TextView headerTitle;
    private TextView headerTime;
    private ImageView headerArrow;

    public DefaultHeader(Context context) {
        this(context, R.drawable.liaoinstan_springlayout_arrow);
    }

    public DefaultHeader(Context context, int arrowSrc) {
        this.context = context;
        this.arrowSrc = arrowSrc;
        mRotateUpAnim = new RotateAnimation(0.0f, -180.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mRotateUpAnim.setDuration(ROTATE_ANIM_DURATION);
        mRotateUpAnim.setFillAfter(true);
        mRotateDownAnim = new RotateAnimation(-180.0f, 0.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mRotateDownAnim.setDuration(ROTATE_ANIM_DURATION);
        mRotateDownAnim.setFillAfter(true);
    }

    @Override
    public View getView(LayoutInflater inflater, ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.liaoinstan_springview_default_header, viewGroup, true);
        headerTitle = (TextView) view.findViewById(R.id.default_header_title);
        headerTime = (TextView) view.findViewById(R.id.default_header_time);
        headerArrow = (ImageView) view.findViewById(R.id.default_header_arrow);
        headerArrow.setImageResource(arrowSrc);
        return view;
    }

    @Override
    public void onPreDrag(View rootView) {
        if (freshTime == 0) {
            freshTime = System.currentTimeMillis();
        } else {
            int m = (int) ((System.currentTimeMillis() - freshTime) / 1000 / 60);
            if (m >= 1 && m < 60) {
                headerTime.setText(m + "分钟前");
            } else if (m >= 60) {
                int h = m / 60;
                headerTime.setText(h + "小时前");
            } else if (m > 60 * 24) {
                int d = m / (60 * 24);
                headerTime.setText(d + "天前");
            } else if (m == 0) {
                headerTime.setText("刚刚");
            }
        }
    }
    /**
     * 手指拖动控件过程中的回调，用户可以根据拖动的距离添加拖动过程动画
     * @param dy 拖动距离，下拉为+，上拉为-
     */
    @Override
    public void onDropAnim(View rootView, int dy) {

    }

    /**
     * 手指拖动控件过程中每次抵达临界点时的回调，用户可以根据手指方向设置临界动画
     * @param upOrDown 是上拉还是下拉
     */
    @Override
    public void onLimitDes(View rootView, boolean upOrDown) {
        //headerArrow.setVisibility(View.VISIBLE);
        if (!upOrDown) {
            headerTitle.setText("松开刷新数据");
            if (headerArrow.getVisibility() == View.VISIBLE){
                headerArrow.startAnimation(mRotateUpAnim);
            }
        } else {
            headerTitle.setText("下拉刷新");
            if (headerArrow.getVisibility() == View.VISIBLE){
                headerArrow.startAnimation(mRotateDownAnim);
            }
        }
    }

    /**
     * 拉动超过临界点后松开时回调
     */
    @Override
    public void onStartAnim() {
        freshTime = System.currentTimeMillis();
        headerTitle.setText("正在刷新");
        headerArrow.setVisibility(View.INVISIBLE);
        headerArrow.clearAnimation();
    }

    /**
     * 头(尾)已经全部弹回时回调
     */
    @Override
    public void onFinishAnim() {
        headerArrow.setVisibility(View.VISIBLE);
    }
}