package me.y9san9.clicker.core.adapter.ui.button

import me.y9san9.clicker.core.ui.button.ClickableButton
import me.y9san9.clicker.core.domain.button.ClickableButton as DomainClickableButton

fun ClickableButton.domain(): DomainClickableButton {
    return when (this) {
        is ClickableButton.Disabled -> DomainClickableButton.Disabled
        is ClickableButton.Enabled -> DomainClickableButton.Enabled(onClick)
    }
}
