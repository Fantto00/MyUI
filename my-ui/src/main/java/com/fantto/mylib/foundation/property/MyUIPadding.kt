package com.fantto.mylib.foundation.property

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class MyUIPadding(
    val top: Dp = 0.dp,
    val bottom: Dp = 0.dp,
    val start: Dp = 0.dp,
    val end: Dp = 0.dp
) {
    companion object {
        fun all(value: Dp): MyUIPadding =
            MyUIPadding(top = value, bottom = value, start = value, end = value)

        fun vertical(value: Dp): MyUIPadding =
            MyUIPadding(top = value, bottom = value)

        fun horizontal(value: Dp): MyUIPadding =
            MyUIPadding(start = value, end = value)
    }
}
