package com.fantto.mylib.animation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput

object MyUIActivateVfx {

    @Composable
    fun Modifier.myuiClickVfx(
        enabled: Boolean = true,
        onClick: () -> Unit
    ): Modifier {
        val interactionSource = remember { MutableInteractionSource() }
        val pressed = interactionSource.collectIsPressedAsState()
        val scale = animateFloatAsState(
            targetValue = if (pressed.value) 0.97f else 1f,
            animationSpec = tween(durationMillis = 80),
            label = "clickVfxScale"
        ).value

        return this
            .then(
                if (enabled) {
                    Modifier.clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = onClick
                    )
                } else Modifier
            )
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
    }

    @Composable
    fun rememberMyUIIntectionSource(): MutableInteractionSource =
        remember { MutableInteractionSource() }
}
