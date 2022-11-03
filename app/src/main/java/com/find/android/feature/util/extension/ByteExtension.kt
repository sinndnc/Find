package com.find.android.feature.util.extension

import android.graphics.Bitmap
import android.graphics.BitmapFactory

fun ByteArray.convertToBitmap(): Bitmap = BitmapFactory.decodeByteArray(this, 0, this.size)
