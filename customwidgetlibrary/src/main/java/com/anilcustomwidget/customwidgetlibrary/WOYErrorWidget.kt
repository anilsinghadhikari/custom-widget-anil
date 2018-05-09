package com.android.watchoveryou.customwidgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.android.watchoveryou.R
import kotterknife.bindView

/**
 * Created by qainfotech on 11/8/17.
 */

class WOYErrorWidget : LinearLayout {
    private var mContext: Context? = null
    private var attrs: AttributeSet? = null

    public val errorMsgTextView: TextView by bindView(R.id.errorMsgTextView)
    private val woyErrortoplayout: LinearLayout by bindView(R.id.woyErrortoplayout)

    public constructor(context: Context) : super(context) {}

    public constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mContext = context
        this.attrs = attrs
        init()
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

    }

    private fun init() {
        val inflater = mContext?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.woy_error_widget_layout, this, true)

    }

    public fun show(msg: String) {
        this.visibility=View.VISIBLE
        errorMsgTextView.setText(msg)
    }

    public fun hide() {
        this.visibility=View.GONE
    }

    public fun setErrorMSg(msg: String) {
        show(msg)
    }


}