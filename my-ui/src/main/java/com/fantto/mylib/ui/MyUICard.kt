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
import com.fantto.mylib.foundation.theme.LocalMyUICornerRadius
import com.fantto.mylib.foundation.theme.LocalMyUIContentPadding

object MyUICard {

    @Composable
    fun Container(
        containerColor: MyUIColorGroup,
        modifier: Modifier = Modifier,
        cornerRadius: MyUICornerRadius? = null,
        contentPadding: MyUIPadding? = null,
        borderWidth: Dp = 1.dp,
        content: @Composable () -> Unit
    ) {
        val resolvedCornerRadius = cornerRadius ?: LocalMyUICornerRadius.current
        val resolvedContentPadding = contentPadding ?: LocalMyUIContentPadding.current
        val shape = resolvedCornerRadius.toShape()
        Column(
            modifier = modifier
                .clip(shape)
                .background(containerColor.container)
                .then(
                    containerColor.border?.let {
                        Modifier.border(
                            width = borderWidth,
                            color = it,
                            shape = shape
                        )
                    } ?: Modifier
                )
                .padding(
                    top = resolvedContentPadding.top,
                    bottom = resolvedContentPadding.bottom,
                    start = resolvedContentPadding.start,
                    end = resolvedContentPadding.end
                ),
            content = { content() }
        )
    }

    @Composable
    fun Container(
        containerColor: MyUIColorsGroup,
        modifier: Modifier = Modifier,
        cornerRadius: MyUICornerRadius? = null,
        contentPadding: MyUIPadding? = null,
        content: @Composable () -> Unit
    ) {
        val resolvedCornerRadius = cornerRadius ?: LocalMyUICornerRadius.current
        val resolvedContentPadding = contentPadding ?: LocalMyUIContentPadding.current
        val shape = resolvedCornerRadius.toShape()
        val gradient = Brush.linearGradient(colors = containerColor.containerGradient)
        Column(
            modifier = modifier
                .clip(shape)
                .background(brush = gradient)
                .padding(
                    top = resolvedContentPadding.top,
                    bottom = resolvedContentPadding.bottom,
                    start = resolvedContentPadding.start,
                    end = resolvedContentPadding.end
                ),
            content = { content() }
        )
    }

    @Composable
    fun Lively(
        containerColor: MyUIColorGroup,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        cornerRadius: MyUICornerRadius? = null,
        contentPadding: MyUIPadding? = null,
        borderWidth: Dp = 1.dp,
        content: @Composable () -> Unit
    ) {
        Column(
            modifier = modifier.myuiClickVfx(onClick = onClick),
            content = {
                Container(
                    containerColor = containerColor,
                    cornerRadius = cornerRadius,
                    contentPadding = contentPadding,
                    borderWidth = borderWidth,
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
        cornerRadius: MyUICornerRadius? = null,
        contentPadding: MyUIPadding? = null,
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
