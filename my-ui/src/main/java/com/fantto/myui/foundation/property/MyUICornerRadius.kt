package com.fantto.myui.foundation.property

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class MyUICornerRadius(
    val topStart: Dp = 0.dp,
    val topEnd: Dp = 0.dp,
    val bottomStart: Dp = 0.dp,
    val bottomEnd: Dp = 0.dp
) {
    companion object {
        fun create(
            topStart: Dp = 0.dp,
            topEnd: Dp = 0.dp,
            bottomStart: Dp = 0.dp,
            bottomEnd: Dp = 0.dp
        ): MyUICornerRadius = MyUICornerRadius(
            topStart = topStart,
            topEnd = topEnd,
            bottomStart = bottomStart,
            bottomEnd = bottomEnd
        )
    }

    fun all(value: Dp): MyUICornerRadius = copy(
        topStart = value, topEnd = value,
        bottomStart = value, bottomEnd = value
    )

    fun top(value: Dp): MyUICornerRadius = copy(topStart = value, topEnd = value)
    fun bottom(value: Dp): MyUICornerRadius = copy(bottomStart = value, bottomEnd = value)
    fun start(value: Dp): MyUICornerRadius = copy(topStart = value, bottomStart = value)
    fun end(value: Dp): MyUICornerRadius = copy(topEnd = value, bottomEnd = value)
}
