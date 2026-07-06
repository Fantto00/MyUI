package com.fantto.mylib.foundation.color

import androidx.compose.ui.graphics.Color
import com.fantto.mylib.foundation.color.MyUIColor.ERROR
import com.fantto.mylib.foundation.color.MyUIColor.PRIMARY
import com.fantto.mylib.foundation.color.MyUIColor.SECONDARY
import com.fantto.mylib.foundation.color.MyUIColor.SUCCESS
import com.fantto.mylib.foundation.color.MyUIColor.TERTIARY
import com.fantto.mylib.foundation.color.MyUIColor.WARNING
import com.fantto.mylib.foundation.type.MyUIButtonType
import com.fantto.mylib.foundation.type.MyUIColorType

object MyUIButtonColor {

    fun getColor(
        type: MyUIButtonType,
        colorType: MyUIColorType
    ): MyUIColorGroup {
        val pair = when (type) {
            MyUIButtonType.PRIMARY -> PRIMARY_DARK to PRIMARY_LIGHT
            MyUIButtonType.SECONDARY -> SECONDARY_DARK to SECONDARY_LIGHT
            MyUIButtonType.TERTIARY -> TERTIARY_DARK to TERTIARY_LIGHT
            MyUIButtonType.ERROR -> ERROR_DARK to ERROR_LIGHT
            MyUIButtonType.SUCCESS -> SUCCESS_DARK to SUCCESS_LIGHT
            MyUIButtonType.WARNING -> WARNING_DARK to WARNING_LIGHT
            MyUIButtonType.INFO -> INFO_DARK to INFO_LIGHT
        }
        return when (colorType) {
            MyUIColorType.DARK -> pair.first
            MyUIColorType.LIGHT -> pair.second
        }
    }

    private val PRIMARY_DARK = MyUIColorGroup(container = PRIMARY, content = Color.White)
    private val PRIMARY_LIGHT = MyUIColorGroup(container = PRIMARY, content = Color.White)
    private val SECONDARY_DARK = MyUIColorGroup(container = SECONDARY, content = Color.White)
    private val SECONDARY_LIGHT = MyUIColorGroup(container = SECONDARY, content = Color.White)
    private val TERTIARY_DARK = MyUIColorGroup(container = TERTIARY, content = Color.White)
    private val TERTIARY_LIGHT = MyUIColorGroup(container = TERTIARY, content = Color.White)
    private val ERROR_DARK = MyUIColorGroup(container = ERROR, content = Color.White)
    private val ERROR_LIGHT = MyUIColorGroup(container = ERROR, content = Color.White)
    private val SUCCESS_DARK = MyUIColorGroup(container = SUCCESS, content = Color.White)
    private val SUCCESS_LIGHT = MyUIColorGroup(container = SUCCESS, content = Color.White)
    private val WARNING_DARK = MyUIColorGroup(container = WARNING, content = Color.Black)
    private val WARNING_LIGHT = MyUIColorGroup(container = WARNING, content = Color.Black)
    private val INFO_DARK = MyUIColorGroup(container = PRIMARY, content = Color.White)
    private val INFO_LIGHT = MyUIColorGroup(container = PRIMARY, content = Color.White)
}
