package org.alex.behavior;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * 作者：Alex
 * 时间：2016/9/22 17:14
 * 简述：依赖于 AppBarLayout  进行 伸缩
 */

public class BottomLayoutBehavior extends CoordinatorLayout.Behavior<RelativeLayout> {
    private int defaultDependencyTop = -1;

    public BottomLayoutBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, RelativeLayout child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, RelativeLayout child, View dependency) {
        if (defaultDependencyTop == -1) {
            defaultDependencyTop = dependency.getTop();
        }
        child.setTranslationY(-dependency.getTop() + defaultDependencyTop);
        return true;
    }

}
