package com.rongyi.arounddemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.orhanobut.logger.Logger


/**
 * Demo class
 *
 * @author yikwing
 * @date 2018/6/23
 */
class PageTestFragment : LazyFragment() {

    private lateinit var tv: TextView
    private var title: String? = null

    companion object {
        fun newInstance(): PageTestFragment {
            val fragment = PageTestFragment()
            val args = Bundle()
            args.putString("key_fragment_title", "test")
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.d("onCreate")
        title = arguments?.getString("key_fragment_title")

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Logger.d("onCreateView")
        tv = TextView(activity)
        tv.textSize = 40f

        tv.setOnClickListener {
            prepareFetchData(true)
        }

        return tv
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Logger.d("onViewCreated")
        tv.text = title
    }


    override fun fetchData() {
        Logger.d("网络请求")
    }
}