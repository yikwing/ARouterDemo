package com.rongyi.arounddemo

import android.os.Bundle
import android.support.v4.app.Fragment
import com.orhanobut.logger.Logger


/**
 * Demo class
 *
 * @author yikwing
 * @date 2018/6/23
 */
abstract class LazyFragment : Fragment() {

    private var isViewInitiated = false
    private var isVisibleToUser = false
    private var isDataInitiated = false

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Logger.d("onActivityCreated")

        isViewInitiated = true
        prepareFetchData()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)

        Logger.d("setUserVisibleHint=$isVisibleToUser")

        this.isVisibleToUser = isVisibleToUser
        prepareFetchData()
    }

    abstract fun fetchData()

    public fun prepareFetchData(forceUpdate: Boolean = false): Boolean {

        Logger.d("$isVisibleToUser +$isViewInitiated+$isDataInitiated+$forceUpdate ")

        if (isVisibleToUser && isViewInitiated && (!isDataInitiated || forceUpdate)) {
            fetchData()
            isDataInitiated = true
            return true
        }
        return false
    }

}