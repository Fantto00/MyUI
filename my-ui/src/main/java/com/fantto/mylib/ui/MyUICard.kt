package com.fantto.mylib.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fantto.mylib.animation.MyUIActivateVfx.myuiClickVfx
import com.fantto.mylib.foundation.color.MyUIColorGroup
import com.fantto.mylib.foundation.color.MyUIColorsGroup
import com.fantto.mylib.foundation.property.MyUICornerRadius
import com.fantto.mylib.foundation.property.MyUIPadding

object MyUICard {

    @Composable
    fun Container(
        containerColor: MyUIColorGroup,
        modifier: Modifier = Modifier,
        cornerRadius: MyUICornerRadius = MyUICornerRadius.create(12.dp),
        contentPadding: MyUIPadding = MyUIPadding.all(16.dp),
        content: @Composable () -> Unit
    ) {
        val shape = cornerRadius.toShape()
        Column(
            modifier = modifier
                .clip(shape)
                .background(containerColor.container)
                .then(
                    containerColor.border?.let {
                        Modifier.border(
                            width = 1.dp,
                            color = it,
                            shape = shape
                        )
                    } ?: Modifier
                )
                .padding(
                    top = contentPadding.top,
                    bottom = contentPadding.bottom,
                    start = contentPadding.start,
                    end = contentPadding.end
                ),
            content = { content() }
        )
    }

    @Composable
    fun Container(
        containerColor: MyUIColorsGroup,
        modifier: Modifier = Modifier,
        cornerRadius: MyUICornerRadius = MyUICornerRadius.create(12.dp),
        contentPadding: MyUIPadding = MyUIPadding.all(16.dp),
        content: @Composable () -> Unit
    ) {
        val shape = cornerRadius.toShape()
        val gradient = Brush.linearGradient(colors = containerColor.containerGradient)
        Column(
            modifier = modifier
                .clip(shape)
                .background(brush = gradient)
                .padding(
                    top = contentPadding.top,
                    bottom = contentPadding.bottom,
                    start = contentPadding.start,
                    end = contentPadding.end
                ),
            content = { content() }
        )
    }

    @Composable
    fun Lively(
        containerColor: MyUIColorGroup,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        cornerRadius: MyUICornerRadius = MyUICornerRadius.create(12.dp),
        contentPadding: MyUIPadding = MyUIPadding.all(16.dp),
        content: @Composable () -> Unit
    ) {
        Column(
            modifier = modifier.myuiClickVfx(onClick = onClick),
            content = {
                Container(
                    containerColor = containerColor,
                    cornerRadius = cornerRadius,
                    contentPadding = contentPadding,
                    content = content
                )
            }
        )
    }

    @Composable
    fun Lively(
        containerColor: MyUIColorsGroup,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        cornerRadius: MyUICornerRadius = MyUICornerRadius.create(12.dp),
        contentPadding: MyUIPadding = MyUIPadding.all(16.dp),
        content: @Composable () -> Unit
    ) {
        Column(
            modifier = modifier.myuiClickVfx(onClick = onClick),
            content = {
                Container(
                    containerColor = containerColor,
                    cornerRadius = cornerRadius,
                    contentPadding = contentPadding,
                    content = content
                )
            }
        )
    }

    @Composable
    private fun MyUICornerRadius.toShape(): Shape {
        return RoundedCornerShape(
            topStart = topStart,
            topEnd = topEnd,
            bottomEnd = bottomEnd,
            bottomStart = bottomStart
        )
    }
}
