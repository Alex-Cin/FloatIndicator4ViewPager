package org.alex.refreshlayout.callback;

/**
 * 作者：Alex
 * 时间：2016年11月22日
 * 简述：
 */

public abstract class OnFootViewChangerListener {
    /**
     * 加载更多，没有响应上拉加载
     */
    public abstract void onLoadingMoreNone();

    /**
     * 加载更多，到了临界状态
     */
    public abstract void onLoadingMoreCritical();

    /**
     * 加载更多，开始
     */
    public abstract void onLoadingMoreStart();

    /**
     * 加载更多，结束
     */
    public abstract void onLoadingMoreFinish();
}
