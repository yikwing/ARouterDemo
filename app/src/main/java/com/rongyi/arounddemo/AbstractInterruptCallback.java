package com.rongyi.arounddemo;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;


public abstract class AbstractInterruptCallback implements NavigationCallback {
    @Override
    public void onFound(Postcard postcard) {

    }

    @Override
    public void onLost(Postcard postcard) {

    }

    @Override
    public void onArrival(Postcard postcard) {

    }

    @Override
    public abstract void onInterrupt(Postcard postcard);
}
