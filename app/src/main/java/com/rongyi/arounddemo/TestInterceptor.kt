package com.rongyi.arounddemo

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor

/**
 * Demo class
 *
 * @author yikwing
 * @date 2018/6/23
 */


@Interceptor(priority = 8, name = "测试用拦截器")
class TestInterceptor : IInterceptor {
    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        if (postcard?.path == "/ui/text") {
            //如果是跳到BActivity，就加个数据
            postcard.withString("extra", "我是在拦截器中附加的参数")
        }

        //继续跳转
        callback!!.onContinue(postcard)

        //终止跳转
        //callback.onInterrupt(null)

        //抛出异常
        // callback.onInterrupt(RuntimeException("我觉得有点异常"))

        // onContinue和onInterrupt至少需要调用其中一种，否则不会继续路由
    }

    override fun init(context: Context?) {
        // 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次
        Log.e("@@", "拦截器初始化")
    }
}