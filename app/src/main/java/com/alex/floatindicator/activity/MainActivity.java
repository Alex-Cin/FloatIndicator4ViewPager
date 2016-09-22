package com.alex.floatindicator.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alex.floatindicator.R;

/**
 * 作者：alex
 * 时间：2016/8/3 17:43
 * 博客地址：http://www.jianshu.com/users/c3c4ea133871/subscriptions
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_1).setOnClickListener(this);
        findViewById(R.id.bt_2).setOnClickListener(this);
        findViewById(R.id.bt_3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (R.id.bt_1 == v.getId()) {
            intent = new Intent(this, FloatIndicatorActivity.class);
            startActivity(intent);

        } else if (R.id.bt_2 == v.getId()) {
            intent = new Intent(this, FloatHeadActivity.class);
            startActivity(intent);
        } else if (R.id.bt_3 == v.getId()) {
            intent = new Intent(this, AlphaTitleActivity.class);
            startActivity(intent);
        }

    }
}
