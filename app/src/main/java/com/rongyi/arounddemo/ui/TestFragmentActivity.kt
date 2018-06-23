package com.rongyi.arounddemo.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.aitangba.swipeback.SwipeBackActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.rongyi.arounddemo.PageTestFragment
import com.rongyi.arounddemo.R
import kotlinx.android.synthetic.main.activity_fragment.*

/**
 * Demo class
 *
 * @author yikwing
 * @date 2018/6/23
 */

@Route(path = "/ui/fragment")
class TestFragmentActivity : SwipeBackActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)


        val adapter = MyPagerAdapter(supportFragmentManager)
        adapter.addFragment(PageTestFragment.newInstance(), "我的藏书")
        adapter.addFragment(PageTestFragment.newInstance(), "藏书统计")
        viewpager.adapter = adapter

        sliding_tabs.setupWithViewPager(viewpager)

    }

}


class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val mFragments = ArrayList<Fragment>()
    private val mFragmentTitles = ArrayList<String>()

    fun addFragment(fragment: Fragment, title: String) {
        mFragments.add(fragment)
        mFragmentTitles.add(title)
    }

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mFragmentTitles[position]
    }
}