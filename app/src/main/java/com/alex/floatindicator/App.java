package com.alex.floatindicator;


import android.graphics.Typeface;

import org.alex.baseui.BaseApp;
import org.alex.util.BaseUtil;
import org.alex.util.LogUtil;

import java.lang.reflect.Field;

/**
 * 作者：Alex
 * 时间：2016/9/20 14:36
 * 简述：
 */
public class App extends BaseApp {
    @Override
    public void onCreate() {
        super.onCreate();
        onCreateFont();
    }
    private void onCreateFont() {
        try {
            Typeface typeface = Typeface.createFromAsset(BaseUtil.app().getAssets(), "font/simkai.ttf");
            Field field_3 = Typeface.class.getDeclaredField("SANS_SERIF");
            field_3.setAccessible(true);
            field_3.set(null, typeface);
        } catch (Exception e) {
            LogUtil.e(e);
        }
    }
}
