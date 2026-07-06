package com.fantto.myui.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.fantto.myui.foundation.property.MyUISpacing
import com.fantto.myui.foundation.property.MyUISpacings

object MyUISpacer {

    @Composable
    fun Height(
        height: Dp = MyUISpacings.M.base,
        modifier: Modifier = Modifier
    ) {
        Spacer(modifier = modifier.height(height))
    }

    @Composable
    fun Width(
        width: Dp = MyUISpacings.M.base,
        modifier: Modifier = Modifier
    ) {
        Spacer(modifier = modifier.width(width))
    }
}
