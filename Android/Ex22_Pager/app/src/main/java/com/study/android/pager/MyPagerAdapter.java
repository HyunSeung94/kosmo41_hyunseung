package com.study.android.pager;

import android.view.ViewGroup;

interface MyPagerAdapter {
    void destoryItem(ViewGroup container, int position, Object object);
}
