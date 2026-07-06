package com.fantto.mylib.foundation.property

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object MyUISpacings {
    val XXS = MyUISpacing.create(4.dp)
    val XS = MyUISpacing.create(8.dp)
    val S = MyUISpacing.create(12.dp)
    val M = MyUISpacing.create(16.dp)
    val L = MyUISpacing.create(24.dp)
    val XL = MyUISpacing.create(32.dp)
    val XXL = MyUISpacing.create(48.dp)

    fun get(spacing: MyUISpacing): Dp = spacing.base
}
