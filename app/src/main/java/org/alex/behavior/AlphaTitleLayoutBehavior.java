package org.alex.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.alex.floatindicator.R;

import org.alex.util.LogUtil;

/**
 * 作者：Alex
 * 时间：2016/9/21 12:57
 * 简述：渐变色的 标题
 * 致谢：http://www.jianshu.com/p/c196aeb8f04a
 */
public class AlphaTitleLayoutBehavior extends CoordinatorLayout.Behavior<RelativeLayout> {
    private float endOffset = 0;
    private Context context;
    private NestedScrollView nestedScrollView;
    private View child;
    private MyOnScrollChangeListener onScrollChangeListener;

    private boolean isFirst;

    public AlphaTitleLayoutBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        isFirst = true;
        onScrollChangeListener = new MyOnScrollChangeListener();
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, RelativeLayout child, View dependency) {
        this.child = child;
        if (isFirst) {
            isFirst = false;
            child.setAlpha(0F);
            endOffset = context.getResources().getDimensionPixelOffset(R.dimen.alpha_title_layout_height);
            if (nestedScrollView == null) {
                int childCount = parent.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = parent.getChildAt(i);
                    if (childAt instanceof NestedScrollView) {
                        nestedScrollView = (NestedScrollView) childAt;
                    }
                }
            }
            if (nestedScrollView != null) {
                nestedScrollView.setOnScrollChangeListener(onScrollChangeListener);
            }
        }
        return dependency instanceof NestedScrollView;
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, RelativeLayout child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    private final class MyOnScrollChangeListener implements NestedScrollView.OnScrollChangeListener {
        @Override
        public void onScrollChange(NestedScrollView nestedScrollView, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            float percent = scrollY / endOffset;
            if (percent > 1) {
                percent = 1f;
            }
            LogUtil.e("endOffset = " + endOffset + " scrollY = " + scrollY + " alpha = " + percent);
            /*0 全透明*/
            if (child != null) {
                child.setAlpha(percent);
            }
        }
    }

}