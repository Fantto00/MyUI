package com.fantto.myui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fantto.myui.foundation.color.MyUIColor
import com.fantto.myui.foundation.color.MyUIColorGroup
import com.fantto.myui.foundation.property.MyUICornerRadius
import com.fantto.myui.foundation.property.MyUIPadding
import com.fantto.myui.foundation.property.MyUISpacings
import com.fantto.myui.foundation.property.MyUIWidth
import com.fantto.myui.ui.MyUICard
import com.fantto.myui.ui.MyUIDivider
import com.fantto.myui.ui.MyUISpacer
import com.fantto.myui.ui.MyUIText
import com.fantto.myui.foundation.theme.MyUITheme

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
            style = com.fantto.myui.foundation.typography.MyUITypography.TYPOGRAPHY.titleLarge
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
                style = com.fantto.myui.foundation.typography.MyUITypography.TYPOGRAPHY.titleMedium
            )
            MyUISpacer.Height(MyUISpacings.S.base)
            MyUIText(
                text = "这是一个带圆角的纯色卡片容器，支持自定义圆角和边框。",
                style = com.fantto.myui.foundation.typography.MyUITypography.TYPOGRAPHY.bodyMedium
            )
        }

        MyUIDivider(
            thickness = MyUIWidth.NORMAL,
            color = MyUIColor.DIVIDER
        )

        MyUIText(
            text = "MyUIIcon.Round",
            style = com.fantto.myui.foundation.typography.MyUITypography.TYPOGRAPHY.titleMedium
        )
        MyUIText(
            text = "★",
            modifier = Modifier.padding(MyUISpacings.S.base),
            style = com.fantto.myui.foundation.typography.MyUITypography.TYPOGRAPHY.titleLarge,
            color = MyUIColor.PRIMARY
        )

        MyUISpacer.Height(MyUISpacings.S.base)

        MyUIText(
            text = "MyUISpacer",
            style = com.fantto.myui.foundation.typography.MyUITypography.TYPOGRAPHY.titleMedium
        )
        MyUISpacer.Height(MyUISpacings.L.base)

        MyUIDivider(
            thickness = MyUIWidth.NORMAL,
            color = MyUIColor.DIVIDER
        )

        MyUIText(
            text = "MyUIDivider",
            style = com.fantto.myui.foundation.typography.MyUITypography.TYPOGRAPHY.titleMedium
        )

        MyUISpacer.Height(MyUISpacings.S.base)
    }
}
