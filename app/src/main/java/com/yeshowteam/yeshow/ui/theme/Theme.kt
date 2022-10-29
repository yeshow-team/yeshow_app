package com.yeshowteam.yeshow.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorPalette = lightColors(
        primary = White,
        primaryVariant = Purple700,
        secondary = Teal200
)


@Composable
fun YeshowTheme(content: @Composable () -> Unit) {
    val colors = DarkColorPalette


    MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
    )
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colors.primary.toArgb()
            window.navigationBarColor = colors.primary.toArgb()

            WindowCompat.getInsetsController(window, view)
                ?.isAppearanceLightStatusBars = true
            WindowCompat.getInsetsController(window, view)
                ?.isAppearanceLightNavigationBars = true
        }
    }
}