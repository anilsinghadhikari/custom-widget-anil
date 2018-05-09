package com.android.watchoveryou.customwidgets

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.anilcustomwidget.customwidgetlibrary.R
import kotterknife.bindView

/**
 * Created by qainfotech on 30/8/17.
 */

class RecyclerViewWidget : LinearLayout {
    private var mContext: Context? = null
    private var attrs: AttributeSet? = null

    private val generalRecyclerView: RecyclerView by bindView(R.id.generalRecyclerView)
    private val progressWidget: WOYProgressBarWidget by bindView(R.id.progressWidget)
    private val erroWidget: WOYErrorWidget by bindView(R.id.erroWidget)

    public constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mContext = context
        this.attrs = attrs
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        init()
    }

    private var value: String = "no"

    private fun init() {
        val inflater = mContext?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.recycler_view_widget, this, true)


    }


    fun showProgress() {
        progressWidget?.visibility = View.VISIBLE
    }

    fun hideProgress() {
        progressWidget?.visibility = View.GONE
    }

    fun showProgress(msg: String) {
        if (TextUtils.isEmpty(msg)) {
            showProgress()
        }
    }

    fun hideError() {
        erroWidget?.visibility = View.GONE
    }

    fun showError(msg: String) {
        erroWidget?.visibility = View.VISIBLE
        erroWidget.setErrorMSg(msg)
        generalRecyclerView?.visibility=View.GONE
    }

    fun showRecyclerView() {
        generalRecyclerView?.visibility = View.VISIBLE
        hideProgress()
        hideError()
    }

    fun hideList(){
        generalRecyclerView?.visibility = View.GONE
    }

    fun setUpLayoutManager(){
        generalRecyclerView?.layoutManager=LinearLayoutManager(mContext)
    }

    fun getRecyclerView(): RecyclerView {
        return generalRecyclerView
    }

}