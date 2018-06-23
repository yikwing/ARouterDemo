package com.rongyi.arounddemo

import android.view.View
import java.util.*

class OnLimitClickHelper(onLimitClickListener: OnLimitClickListener) : View.OnClickListener {
    private var lastClickTime: Long = 0
    private var onLimitClickListener: OnLimitClickListener? = null
    private val LIMIT_TIME = 300

    init {
        this.onLimitClickListener = onLimitClickListener
    }

    override fun onClick(v: View) {
        val curTime = Calendar.getInstance().timeInMillis
        if (curTime - lastClickTime > LIMIT_TIME) {
            lastClickTime = curTime
            onLimitClickListener?.onClick(v)
        }
    }

}
