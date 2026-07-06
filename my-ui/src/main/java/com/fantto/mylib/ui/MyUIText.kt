package com.fantto.mylib.ui

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.fantto.mylib.foundation.typography.MyUITypography

@Composable
fun MyUIText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MyUITypography.TYPOGRAPHY.bodyLarge,
    color: Color = Color.Unspecified
) {
    Text(
        text = text,
        modifier = modifier,
        style = style,
        color = color
    )
}
