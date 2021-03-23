package com.hofit.hofitcellcomtest.ui.base

import android.graphics.Point
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.hofit.hofitcellcomtest.R
import com.hofit.hofitcellcomtest.extentions.show

abstract class BaseActivity : AppCompatActivity(), BaseView {

    private var mProgressBarLayout : View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView()
        initDependencies()

        getPresenter()?.apply {
            onStart()
        }
    }

    private fun setContentView() {
        val size = Point()
        windowManager.defaultDisplay.getSize(size)

        val root: View = layoutInflater.inflate(R.layout.activity_base, null)
        setContentView(root)

        val content: View = layoutInflater.inflate(getLayoutResource(), null)
        val mContentContainer = findViewById<ViewGroup>(R.id.content_container)
        mProgressBarLayout = findViewById(R.id.progressBarContent)
        mContentContainer.addView(content)
    }

    override fun displayProgressBar() {
        mProgressBarLayout?.show(true)
    }

    override fun hideProgressbar() {
        mProgressBarLayout?.show(false)
    }

    abstract fun initDependencies()
    abstract fun getLayoutResource() : Int

    override fun getActivity() : BaseActivity{
        return this
    }

    abstract fun getPresenter() : BasePresenter<*>?
}
