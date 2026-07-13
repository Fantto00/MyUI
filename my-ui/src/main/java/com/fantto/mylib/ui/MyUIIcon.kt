package com.fantto.mylib.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fantto.mylib.animation.MyUIActivateVfx.myuiClickVfx
import com.fantto.mylib.foundation.color.MyUIColorGroup
import com.fantto.mylib.foundation.color.MyUIColorsGroup

object MyUIIcon {

    @Composable
    fun Round(
        icon: ImageVector,
        modifier: Modifier = Modifier,
        size: Dp = 24.dp,
        containerSize: Dp = 40.dp,
        containerColor: MyUIColorGroup,
        contentDescription: String? = null,
        onClick: (() -> Unit)? = null
    ) {
        val clickableModifier = if (onClick != null) {
            modifier.myuiClickVfx(onClick = onClick)
        } else modifier

        Box(
            modifier = clickableModifier
                .size(containerSize)
                .clip(CircleShape)
                .background(containerColor.container),
            contentAlignment = Alignment.Center
        ) {
            androidx.compose.material3.Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                modifier = Modifier.size(size),
                tint = containerColor.content
            )
        }
    }

    @Composable
    fun RoundGradient(
        icon: ImageVector,
        modifier: Modifier = Modifier,
        size: Dp = 24.dp,
        containerSize: Dp = 40.dp,
        colorsGroup: MyUIColorsGroup,
        contentDescription: String? = null,
        onClick: (() -> Unit)? = null
    ) {
        val clickableModifier = if (onClick != null) {
            modifier.myuiClickVfx(onClick = onClick)
        } else modifier
        val gradient = Brush.linearGradient(colors = colorsGroup.containerGradient)

        Box(
            modifier = clickableModifier.size(containerSize),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(containerSize)
                    .clip(CircleShape)
                    .background(brush = gradient),
                contentAlignment = Alignment.Center
            ) {
                androidx.compose.material3.Icon(
                    imageVector = icon,
                    contentDescription = contentDescription,
                    modifier = Modifier.size(size),
                    tint = colorsGroup.content
                )
            }
        }
    }
}
