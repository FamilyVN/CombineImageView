package com.tuananh.combineimageview.custom

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * Created by FRAMGIA\vu.tuan.anh on 25/01/2018.
 */
class TransparentCircle : View {
    private lateinit var bm: Bitmap
    private lateinit var cv: Canvas
    private lateinit var eraser: Paint
    private var color: Int = 0

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        eraser = Paint()
        eraser.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        eraser.isAntiAlias = true
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        if((w > 0 && h > 0) && (w != oldw || h != oldh)) {
            bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
            cv = Canvas(bm)
        }
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onDraw(canvas: Canvas) {
        val w = width.toFloat()
        val h = height.toFloat()
        val radius = if(w > h) h / 2 else w / 2
        bm.eraseColor(Color.TRANSPARENT)
        cv.drawColor(getColor())
        cv.drawCircle(w / 2, h / 2, radius, eraser)
        canvas.drawBitmap(bm, 0f, 0f, null)
        super.onDraw(canvas)
    }

    fun getColor(): Int {
        return color
    }

    fun setColor(color: Int) {
        this.color = color
    }
}