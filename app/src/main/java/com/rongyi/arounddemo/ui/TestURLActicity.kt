package com.rongyi.arounddemo.ui

import android.os.Bundle
import com.aitangba.swipeback.SwipeBackActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.Logger
import com.rongyi.arounddemo.R
import kotlinx.android.synthetic.main.activity_url_target.*

/**
 * Demo class
 *
 * @author yikwing
 * @date 2018/6/23
 */


@Route(path = "/ui/urlPairms")
class TestURLActicity : SwipeBackActivity() {

    @JvmField
    @Autowired
    var name = ""

    @JvmField
    @Autowired
    var age = 0

    @JvmField
    @Autowired(name = "sex")
    var gender: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_url_target)

        Logger.d("当前页面是:" + this@TestURLActicity::class.java.name)

        ARouter.getInstance().inject(this)

        testTitle.text = "$name - $age - $gender"

    }

    /**
     *
     * @return Boolean 是否需要滑动返回
     * */
    override fun supportSlideBack(): Boolean = false


    /**
     *
     * @return Boolean 能否返回至本Activity
     * */
    override fun canBeSlideBack(): Boolean {
        return super.canBeSlideBack()
    }

}
