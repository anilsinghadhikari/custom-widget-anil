package com.android.watchoveryou.customwidgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.android.watchoveryou.R
import kotterknife.bindView

/**
 * Created by qainfotech on 11/8/17.
 */

class WOYProgressBarWidget : LinearLayout {
    private var mContext: Context? = null
    private var attrs: AttributeSet? = null

    //    private val continueBtn: Button by bindView(R.id.continueBtn)
    public val progressMsgTextView: TextView by bindView(R.id.progressMsgTextView)
    private val woyProgressBar: ProgressBar by bindView(R.id.woyProgressBar)
    private val woyprogressbartoplayout: LinearLayout by bindView(R.id.woyprogressbartoplayout)

    public constructor(context: Context) : super(context) {}

    public constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mContext = context
        this.attrs = attrs
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        init()
    }

    private fun init() {
        val inflater = mContext?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.woy_progress_bar_layout, this, true)


    }

    public fun show(msg: String) {
        this.visibility = View.VISIBLE
        setProgressMsg(msg)
    }

    public fun show() {
//        woyprogressbartoplayout.visibility = View.VISIBLE
//        progressMsgTextView.visibility = View.VISIBLE
//        woyProgressBar.visibility = View.VISIBLE

        this.visibility = View.VISIBLE
    }

    public fun hide() {
//        progressMsgTextView.visibility = View.GONE
//        woyProgressBar.visibility = View.GONE
//        woyprogressbartoplayout.visibility = View.GONE

        this.visibility = View.GONE
    }

    public fun setProgressMsg(msg: String) {
        progressMsgTextView.setText(msg)
    }


}