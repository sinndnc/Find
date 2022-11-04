package com.find.android.feature.util.extension

import android.graphics.*
import android.graphics.Bitmap.Config

fun ByteArray.convertToBitmap(): Bitmap {
    val bitmap = BitmapFactory.decodeByteArray(this, 0, this.size)
    return Bitmap.createScaledBitmap(bitmap, 90, 90, true)
}

fun Bitmap.getCroppedBitmap(): Bitmap? {
    val output = Bitmap.createBitmap(
        this.width,
        this.height, Config.ARGB_8888
    )
    val canvas = Canvas(output)
    val color = -0xbdbdbe
    val paint = Paint()
    val rect = Rect(0, 0, this.width, this.height)
    paint.isAntiAlias = true
    canvas.drawARGB(0, 0, 0, 0)
    paint.color = color
    canvas.drawCircle(
        (this.width / 2).toFloat(), (this.height / 2).toFloat(),
        (this.width / 2).toFloat(), paint
    )
    paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    canvas.drawBitmap(this, rect, rect, paint)
    return output
}