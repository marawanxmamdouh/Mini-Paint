package dev.marawanxmamdouh.minipaint

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import androidx.core.content.res.ResourcesCompat

private lateinit var extraCanvas: Canvas
private lateinit var extraBitmap: Bitmap

class MyCanvas(context: Context) : View(context) {
    private val backgroundColor = ResourcesCompat.getColor(resources, R.color.colorBackground, null)

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeight)
        if (::extraBitmap.isInitialized) extraBitmap.recycle()
        extraBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        extraCanvas = Canvas(extraBitmap)
        extraCanvas.drawColor(backgroundColor)
    }
}