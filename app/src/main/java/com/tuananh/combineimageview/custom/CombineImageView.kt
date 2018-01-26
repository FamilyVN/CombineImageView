package com.tuananh.combineimageview.custom

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.tuananh.combineimageview.R
import com.tuananh.combineimageview.loadLinkNoAnim
import kotlinx.android.synthetic.main.layout_combine_image.view.*

/**
 * Created by FRAMGIA\vu.tuan.anh on 17/01/2018.
 */
class CombineImageView : FrameLayout {
    private var color: Int = 0
    private var defaultResId: Int = 0

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        val attributes = context.theme.obtainStyledAttributes(attrs, R.styleable.CombineImageView, 0, 0)
        try {
            color = attributes.getColor(R.styleable.CombineImageView_backgroundcolorview, Color.WHITE)
        } finally {
            attributes.recycle()
        }
        init()
    }

    open fun setDefaultRes(@DrawableRes resId: Int) {
        this.defaultResId = resId
    }

    private fun init() {
        LayoutInflater.from(context).inflate(R.layout.layout_combine_image, this, true)
        transparentCircle.setColor(color)
    }

    open fun setListImageResource(listId: MutableList<Int>?) {
        var drawable: Drawable? = null
        if(defaultResId != 0) {
            drawable = ContextCompat.getDrawable(context, defaultResId)
        }
        if(listId == null || listId.isEmpty()) {
            if(drawable == null) {
                drawable = ContextCompat.getDrawable(context, R.mipmap.ic_launcher)
            }
            topLeftImage.visibility = View.VISIBLE
            bottomLeftImage.visibility = View.GONE
            rightContainer.visibility = View.GONE
            divViewLeft.visibility = View.GONE
            divViewRight.visibility = View.GONE
            divViewVertical.visibility = View.GONE
            topLeftImage.setImageDrawable(drawable)
            return
        }
        when(listId.size) {
            1 -> {
                if(drawable == null) {
                    drawable = ContextCompat.getDrawable(context, R.mipmap.ic_launcher)
                }
                topLeftImage.visibility = View.VISIBLE
                bottomLeftImage.visibility = View.GONE
                rightContainer.visibility = View.GONE
                divViewLeft.visibility = View.GONE
                divViewRight.visibility = View.GONE
                divViewVertical.visibility = View.GONE
                topLeftImage.setImageDrawable(drawable)
                topLeftImage.setImageResource(listId[0])
            }
            2 -> {
                if(drawable == null) {
                    drawable = ContextCompat.getDrawable(context, R.mipmap.ic_launcher)
                }
                topLeftImage.visibility = View.VISIBLE
                bottomLeftImage.visibility = View.GONE
                topRightImage.visibility = View.VISIBLE
                bottomRightImage.visibility = View.GONE
                rightContainer.visibility = View.GONE
                divViewLeft.visibility = View.GONE
                divViewRight.visibility = View.GONE
                divViewVertical.visibility = View.GONE
                //                topLeftImage.setImageDrawable(drawable)
                topLeftImage.setImageResource(listId[0])
                //                topRightImage.setImageDrawable(drawable)
                topRightImage.setImageResource(listId[1])
            }
            3 -> {
            }
            4 -> {

            }
        }
    }

    open fun setListImage(listUrl: MutableList<String>?) {
        var drawable: Drawable? = null
        if(defaultResId != 0) {
            drawable = ContextCompat.getDrawable(context, defaultResId)
        }
        if(listUrl == null || listUrl.isEmpty()) {
            if(drawable == null) {
                drawable = ContextCompat.getDrawable(context, R.mipmap.ic_launcher)
            }
            topLeftImage.visibility = View.VISIBLE
            bottomLeftImage.visibility = View.GONE
            rightContainer.visibility = View.GONE
            divViewLeft.visibility = View.GONE
            divViewRight.visibility = View.GONE
            divViewVertical.visibility = View.GONE
            loadLinkNoAnim(context, null, drawable, topLeftImage)
            return
        }
        when(listUrl.size) {
            1 -> {
                if(drawable == null) {
                    drawable = ContextCompat.getDrawable(context, R.mipmap.ic_launcher)
                }
                topLeftImage.visibility = View.VISIBLE
                bottomLeftImage.visibility = View.GONE
                rightContainer.visibility = View.GONE
                divViewLeft.visibility = View.GONE
                divViewRight.visibility = View.GONE
                divViewVertical.visibility = View.GONE
                loadLinkNoAnim(context, listUrl[0], drawable, topLeftImage)
            }
            2 -> {
                if(drawable == null) {
                    drawable = ContextCompat.getDrawable(context, R.mipmap.ic_launcher)
                }
                topLeftImage.visibility = View.VISIBLE
                bottomLeftImage.visibility = View.GONE
                topRightImage.visibility = View.VISIBLE
                bottomRightImage.visibility = View.GONE
                rightContainer.visibility = View.GONE
                divViewLeft.visibility = View.GONE
                divViewRight.visibility = View.GONE
                divViewVertical.visibility = View.GONE
                loadLinkNoAnim(context, listUrl[0], drawable, topLeftImage)
                loadLinkNoAnim(context, listUrl[1], drawable, topRightImage)
            }
            3 -> {
            }
            4 -> {

            }
        }
    }
}