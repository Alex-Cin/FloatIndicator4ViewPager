package com.alex.floatindicator.adapter;

import android.content.Context;
import android.view.View;

import com.alex.floatindicator.R;

import org.alex.adapter.SingleRecyclerAdapter;
import org.alex.adapter.core.RecyclerViewHolder;


public class ScoreRecyclerAdapter extends SingleRecyclerAdapter<String> {


    public ScoreRecyclerAdapter(Context context) {
        super(context, R.layout.item_fragment_game_before_score);
    }

    @Override
    public void onConvert(RecyclerViewHolder recyclerViewHolder, int i) {

    }

    @Override
    public void onPositionClick(View view, int i) {

    }
}
