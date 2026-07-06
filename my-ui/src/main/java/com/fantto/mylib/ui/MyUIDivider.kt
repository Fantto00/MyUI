package com.fantto.mylib.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fantto.mylib.foundation.color.MyUIColor
import com.fantto.mylib.foundation.property.MyUIPadding
import com.fantto.mylib.foundation.property.MyUIWidth

@Composable
fun MyUIDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = MyUIWidth.NORMAL,
    color: Color = MyUIColor.DIVIDER,
    padding: MyUIPadding = MyUIPadding.all(0.dp)
) {
    androidx.compose.foundation.layout.Column(
        modifier = modifier.padding(
            top = padding.top,
            bottom = padding.bottom,
            start = padding.start,
            end = padding.end
        )
    ) {
        HorizontalDivider(
            thickness = thickness,
            color = color
        )
    }
}
