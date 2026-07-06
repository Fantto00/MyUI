package com.fantto.myui.foundation.property

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class MyUISpacing(
    val small: Dp = 0.dp,
    val base: Dp,
    val large: Dp = 0.dp
) {
    companion object {
        fun create(base: Dp): MyUISpacing {
            val small = if (base < 20.dp) base * 0.5f else base * 0.5f
            val large = base * 2f
            return MyUISpacing(small = small, base = base, large = large)
        }
    }
}
