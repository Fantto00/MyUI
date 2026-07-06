package com.fantto.mylib.foundation.property

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class MyUIPadding private constructor(
    val top: Dp,
    val bottom: Dp,
    val start: Dp,
    val end: Dp
) {
    companion object {
        fun all(value: Dp): MyUIPadding =
            MyUIPadding(top = value, bottom = value, start = value, end = value)

        fun vertical(value: Dp): MyUIPadding =
            MyUIPadding(top = value, bottom = value, start = 0.dp, end = 0.dp)

        fun horizontal(value: Dp): MyUIPadding =
            MyUIPadding(top = 0.dp, bottom = 0.dp, start = value, end = value)

        fun builder() = Builder()
    }

    class Builder {
        private var top: Dp = 0.dp
        private var bottom: Dp = 0.dp
        private var start: Dp = 0.dp
        private var end: Dp = 0.dp

        fun top(value: Dp) = apply { this.top = value }
        fun bottom(value: Dp) = apply { this.bottom = value }
        fun start(value: Dp) = apply { this.start = value }
        fun end(value: Dp) = apply { this.end = value }

        fun build() = MyUIPadding(top = top, bottom = bottom, start = start, end = end)
    }
}
