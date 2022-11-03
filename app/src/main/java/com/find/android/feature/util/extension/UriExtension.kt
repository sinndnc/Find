package com.find.android.feature.util.extension

import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri

fun Uri.convertToBitmap(context: Context): Bitmap {
    val source = ImageDecoder
        .createSource(context.contentResolver, this)
    return ImageDecoder.decodeBitmap(source)
}
