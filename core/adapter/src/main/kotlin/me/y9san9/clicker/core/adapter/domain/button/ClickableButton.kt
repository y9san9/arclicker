package me.y9san9.clicker.core.adapter.domain.button

import me.y9san9.clicker.core.domain.button.ClickableButton
import me.y9san9.clicker.core.ui.button.ClickableButton as UiClickableButton

fun ClickableButton.ui(): UiClickableButton {
    return when (this) {
        is ClickableButton.Disabled -> UiClickableButton.Disabled
        is ClickableButton.Enabled -> UiClickableButton.Enabled(onClick)
    }
}
