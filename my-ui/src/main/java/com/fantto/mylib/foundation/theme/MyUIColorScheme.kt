package com.fantto.mylib.foundation.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.fantto.mylib.foundation.color.MyUIColor
import com.fantto.mylib.foundation.property.MyUICornerRadius
import com.fantto.mylib.foundation.property.MyUIPadding

@Immutable
data class MyUIColorScheme(
    val light: ColorScheme = lightColorScheme(),
    val dark: ColorScheme = darkColorScheme()
) {
    companion object {
        fun lightColorScheme(
            primary: Color = MyUIColor.PRIMARY,
            secondary: Color = MyUIColor.SECONDARY,
            tertiary: Color = MyUIColor.TERTIARY,
            background: Color = MyUIColor.BACKGROUND,
            surface: Color = MyUIColor.SURFACE,
            onBackground: Color = MyUIColor.ON_BACKGROUND,
            onSurface: Color = MyUIColor.ON_SURFACE,
            error: Color = MyUIColor.ERROR,
        ) = androidx.compose.material3.lightColorScheme(
            primary = primary,
            secondary = secondary,
            tertiary = tertiary,
            background = background,
            surface = surface,
            onBackground = onBackground,
            onSurface = onSurface,
            error = error,
        )

        fun darkColorScheme(
            primary: Color = MyUIColor.PRIMARY,
            secondary: Color = MyUIColor.SECONDARY,
            tertiary: Color = MyUIColor.TERTIARY,
            background: Color = MyUIColor.BACKGROUND_DARK,
            surface: Color = MyUIColor.SURFACE_DARK,
            onBackground: Color = MyUIColor.ON_BACKGROUND_DARK,
            onSurface: Color = MyUIColor.ON_SURFACE_DARK,
            error: Color = MyUIColor.ERROR,
        ) = androidx.compose.material3.darkColorScheme(
            primary = primary,
            secondary = secondary,
            tertiary = tertiary,
            background = background,
            surface = surface,
            onBackground = onBackground,
            onSurface = onSurface,
            error = error,
        )
    }
}

@Immutable
data class MyUICustomTheme(
    val colorScheme: MyUIColorScheme? = null,
    val typography: Typography? = null,
    val defaultCornerRadius: MyUICornerRadius? = null,
    val defaultContentPadding: MyUIPadding? = null
)

