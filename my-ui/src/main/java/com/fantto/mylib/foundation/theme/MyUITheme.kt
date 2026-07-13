package com.fantto.mylib.foundation.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.compose.ui.unit.dp
import com.fantto.mylib.foundation.property.MyUICornerRadius
import com.fantto.mylib.foundation.property.MyUIPadding
import com.fantto.mylib.foundation.typography.MyUITypography

internal val LocalMyUICornerRadius = staticCompositionLocalOf {
    MyUICornerRadius.create(12.dp)
}

internal val LocalMyUIContentPadding = staticCompositionLocalOf {
    MyUIPadding.all(16.dp)
}

@Composable
fun MyUITheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    fitSystemWindows: Boolean = false,
    customTheme: MyUICustomTheme = MyUICustomTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = customTheme.colorScheme?.let { scheme ->
        if (darkTheme) scheme.dark else scheme.light
    } ?: run {
        when {
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                val context = androidx.compose.ui.platform.LocalContext.current
                if (darkTheme) androidx.compose.material3.dynamicDarkColorScheme(context)
                else androidx.compose.material3.dynamicLightColorScheme(context)
            }
            darkTheme -> MyUIColorScheme.darkColorScheme()
            else -> MyUIColorScheme.lightColorScheme()
        }
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val activity = view.context as? Activity ?: return@SideEffect
            val window = activity.window
            WindowCompat.setDecorFitsSystemWindows(window, fitSystemWindows)
            if (!fitSystemWindows) {
                window.statusBarColor = colorScheme.primary.toArgb()
                WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
            }
        }
    }

    val typography = customTheme.typography ?: MyUITypography.TYPOGRAPHY
    val cornerRadius = customTheme.defaultCornerRadius ?: LocalMyUICornerRadius.current
    val contentPadding = customTheme.defaultContentPadding ?: LocalMyUIContentPadding.current

    CompositionLocalProvider(
        LocalMyUICornerRadius provides cornerRadius,
        LocalMyUIContentPadding provides contentPadding
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            content = content
        )
    }
}

