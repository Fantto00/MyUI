package com.fantto.myui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fantto.mylib.foundation.color.MyUIColor
import com.fantto.mylib.foundation.color.MyUIColorGroup
import com.fantto.mylib.foundation.property.MyUICornerRadius
import com.fantto.mylib.foundation.property.MyUIPadding
import com.fantto.mylib.foundation.property.MyUISpacings
import com.fantto.mylib.foundation.property.MyUIWidth
import com.fantto.mylib.foundation.theme.MyUITheme
import com.fantto.mylib.foundation.typography.MyUITypography
import com.fantto.mylib.ui.MyUICard
import com.fantto.mylib.ui.MyUIDivider
import com.fantto.mylib.ui.MyUISpacer
import com.fantto.mylib.ui.MyUIText

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyUITheme {
                ComponentShowcase()
            }
        }
    }
}

@Composable
fun ComponentShowcase() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MyUISpacings.M.base),
        verticalArrangement = Arrangement.spacedBy(MyUISpacings.L.base),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyUIText(
            text = "MyUI 组件展示",
            style = MyUITypography.TYPOGRAPHY.titleLarge
        )

        MyUISpacer.Height(MyUISpacings.S.base)

        MyUICard.Container(
            containerColor = MyUIColorGroup(
                container = MyUIColor.SURFACE,
                content = MyUIColor.ON_SURFACE,
                border = MyUIColor.DIVIDER
            ),
            cornerRadius = MyUICornerRadius.create(12.dp),
            contentPadding = MyUIPadding.all(16.dp)
        ) {
            MyUIText(
                text = "MyUICard.Container",
                style = MyUITypography.TYPOGRAPHY.titleMedium
            )
            MyUISpacer.Height(MyUISpacings.S.base)
            MyUIText(
                text = "这是一个带圆角的纯色卡片容器，支持自定义圆角和边框。",
                style = MyUITypography.TYPOGRAPHY.bodyMedium
            )
        }

        MyUIDivider(
            thickness = MyUIWidth.NORMAL,
            color = MyUIColor.DIVIDER
        )

        MyUIText(
            text = "MyUIIcon.Round",
            style = MyUITypography.TYPOGRAPHY.titleMedium
        )
        MyUIText(
            text = "★",
            modifier = Modifier.padding(MyUISpacings.S.base),
            style = MyUITypography.TYPOGRAPHY.titleLarge,
            color = MyUIColor.PRIMARY
        )

        MyUISpacer.Height(MyUISpacings.S.base)

        MyUIText(
            text = "MyUISpacer",
            style = MyUITypography.TYPOGRAPHY.titleMedium
        )
        MyUISpacer.Height(MyUISpacings.L.base)

        MyUIDivider(
            thickness = MyUIWidth.NORMAL,
            color = MyUIColor.DIVIDER
        )

        MyUIText(
            text = "MyUIDivider",
            style = MyUITypography.TYPOGRAPHY.titleMedium
        )

        MyUISpacer.Height(MyUISpacings.S.base)
    }
}
