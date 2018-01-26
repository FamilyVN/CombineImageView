package com.tuananh.combineimageview

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

/**
 * Created by FRAMGIA\vu.tuan.anh on 26/01/2018.
 */
fun loadLinkNoAnim(context: Context, link: String?, defaultImg: Drawable?,
                   imageView: ImageView) {
    Glide.with(context)
            .load(link)
            .diskCacheStrategy(DiskCacheStrategy.RESULT)
            .fitCenter()
//            .placeholder(defaultImg)
//            .error(defaultImg)
            .dontAnimate()
            .into(imageView)
}