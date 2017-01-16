package com.alex.floatindicator.adapter;

import com.alex.floatindicator.R;
import com.chad.adapter.Holder;
import com.chad.adapter.SingleRecyclerAdapter;


public class ScoreRecyclerAdapter extends SingleRecyclerAdapter<String> {

    @Override
    public int getLayoutResId() {
        return R.layout.item_fragment_game_before_score;
    }

    @Override
    protected void onConvert(Holder holder, String result, int position) {

    }

}
